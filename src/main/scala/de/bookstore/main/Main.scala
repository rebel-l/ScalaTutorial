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
  }
}
