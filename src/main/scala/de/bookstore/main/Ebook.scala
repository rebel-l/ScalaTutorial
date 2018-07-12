package de.bookstore.main

class EBook(title: String, val author: String, isbn10: Long = -1, val formats: List[String] = List[String](), quantity: Int = 1) extends Book(title, author, isbn10, quantity) {
  def this(title: String) = {
    this(title, "John")
  }

  override def toString = s"$title, $author, $isbn10, $formats"

  override def toXml = {
    <book>
      <title>{title}</title>
      <author>{author}</author>
      <isbn10>{isbn10}</isbn10>
      <formats>{formats.mkString(",")}</formats>
    </book>
  }
}

object EBook {
  def fromXml(node: scala.xml.Node): Book = {
    val title = (node \ "title").text
    val author = (node \ "author").text
    val isbn10 = (node \ "isbn10").text.toLong
    val formats: List[String] = (node \ "formats").text.split(",").toList
    new EBook(title, author, isbn10, formats)
  }
}
