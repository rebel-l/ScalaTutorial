package de.bookstore.main

class Ebook(title: String, val author: String, isbn10: Long = -1, val formats: List[String] = List[String]()) extends Book(title, author, isbn10) {
  def this(title: String) = {
    this(title, "John")
  }
}
