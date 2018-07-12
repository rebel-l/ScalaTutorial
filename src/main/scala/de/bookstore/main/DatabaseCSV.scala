package de.bookstore.main

import scala.collection.mutable.ListBuffer
import java.io._

import scala.util.control.NonFatal
import java.nio.file.{Files, Paths}
import java.security.AccessControlException

class DatabaseCSV(dbPath: String = "src/main/resources/database.csv") extends Database {

  val books: ListBuffer[Book] = ListBuffer[Book]()
  readFromFile()

  private def readFromFile() = {
    val reader = new BufferedReader(new FileReader(dbPath))
    try {
      for (line <- Iterator.continually(reader.readLine()).takeWhile(_ != null)) {
        lineToBook(line) match {
          case Some(book) => update(book)
          case None => println("Line is not valid: " + line)
        }
      }
    } catch {
      case e: IOException => e.printStackTrace()

      // DO NOT USE THIS: Catches JVM errors too!
      //case e: Throwable => e.printStackTrace()

      // Use this instead to catch everything non fatal
      case NonFatal(e) => e.printStackTrace()
    } finally {
      reader.close()
    }
  }

  private def lineToBook(line: String): Option[Book] = {
    try {
      val splitLine = line.split(";").map(_.trim)
      return Some(Book.fromCSV(splitLine))
    } catch {
      case NonFatal(e) => None
    }
  }

  def update(book: Book) = {
    def validate(book: Book): Either[String, Book] = {
      if (Book.validateISBN10(book.isbn10)) {
        Right(book)
      } else {
        Left("Book has invalid ISBN10: " + book)
      }
    }

    validate(book).fold(
      error => println(error),
      success => { this.books += book }
    )
  }

  def save(filePath: String = "src/main/resources/database.csv") = {
    if (!Files.exists(Paths.get(filePath))) {
      throw new AccessControlException("File does not exist")
    }
    val csv = books.map(b => b.exportCSV)
    val pw = new PrintWriter(new File(filePath))
    pw.write(csv.mkString("\n"))
    pw.close()
  }

  def findBooks(title: String = "", bookType: String = ""): List[Book] = {
    return this.books.toList
  }
}
