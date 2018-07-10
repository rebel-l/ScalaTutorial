package de.bookstore.main

class Book (val title: String, author: String, var isbn10: Long) extends Export {
  def this(title: String) {
    this(title, "", -1)
  }

  def getDigit: String = {
    isbn10.toString().takeRight(1)
  }

  override def toString: String = title + ", " + author + ", " + this.isbn10

  def encode = false
  def exportCSV: String = {
    title + ";" + author + ";" + this.isbn10
  }

  def toXml = {
    <book>
      <title>{title}</title>
      <author>{author}</author>
      <isbn10>{isbn10}</isbn10>
    </book>
  }
}

object Book {
  def validateISBN10(isbn: Long): Boolean = {
    var s: Int = 0
    var t: Int = 0

    val digits = isbn.toString().map(_.toChar)
    for (i <- 0 to 8) {
      t += digits(i);
      s += t;
    }

    (s % 11) == digits(9).asDigit
  }

  def fromXml(node: scala.xml.Node): Book = {
    val title = (node \ "title").text
    val author = (node \ "author").text
    val isbn10 = (node \ "isbn10").text.toLong
    new Book(title, author, isbn10)
  }

  def unapply(book: Book) = Some(book.title, book.isbn10)
}
