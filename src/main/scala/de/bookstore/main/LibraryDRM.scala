package de.bookstore.main

import scala.collection.mutable.ListBuffer

class LibraryDRM extends Library {
  val books = ListBuffer[Book]()

  def add(book: Book) { books += book }

  class DRMBook(title: String, val author: String, isbn10: Long = -1) extends Book(title, author, isbn10) {}
}
