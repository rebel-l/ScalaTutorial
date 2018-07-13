package de.bookstore.main

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")

    val ebook = new EBook(title="Learning Scala", "John");
    println(ebook.author) // Prints John
    println(ebook.isbn10) // Prints -1
    println(ebook.formats) // Prints List()
    println(ebook)
    println(s"Title: ${ebook.title}")

    // printf style
    val price = 200.0
    println(f"Price: $price")
    println(f"Price: $price%.0f")

    // raw
    println(raw"no line\nbreak")


    val book0 = new Book("Clean Code", "Uncle Bob", 3826655486L)
    val book1 = new Book("Code Complete 2", "Steve McConnell", 735619670L, 0)
    val book2 = new Book("The Pragmatic Programmer", "Andrew Hunt", 3446223096L, 0)
    val book3 = new EBook("Lord of the Rings", "J.R.R. Tolkien")

    val books = List(book0, book1, book2, book3)
    println(Lib.findAvailable(books))



    val libOnline1 = new LibraryOnline()
    var oBook1 = new libOnline1.OnlineBook("The neophytes guide to Scala", "Kaffeecoder", -1)
    var oBook2 = new libOnline1.OnlineBook("Clean Code", "Uncle Bob", 3826655486L)

    val libOnline2 = new LibraryOnline()
    var oBook3 = new libOnline2.OnlineBook("The Pragmatic Programmer", "Andrew Hunt", 3446223096L)

    val libDRM = new LibraryDRM()
    var drmBook = new libDRM.DRMBook("Stufen", "Hermann Hesse", 3458357475L)

    /*
    oBook1 = drmBook // not possible
    oBook1 = oBook2 // possible
    oBook1 = oBook3 // not possible
    */



    val eIndex = new EBookIndex()
    val bIndex = new BookIndex()

    val glIndex = new GermanLyricIndex()
    val aIIndex = new AIIndex()
  }
}
