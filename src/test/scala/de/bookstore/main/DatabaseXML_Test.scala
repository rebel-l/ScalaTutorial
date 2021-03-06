package de.bookstore.main

class DatabaseXML_Test extends UnitTest("DatabaseXML"){
  "A Database" should "output all books" in {
    val db = new DatabaseXML("src/test/resources/database.xml")
    assert(db.findBooks().size === 5)
  }

  "A Database" should "output all non ebooks" in {
    val db = new DatabaseXML("src/test/resources/database.xml")
    assert(db.findBooks(bookType = "book").size === 3)
  }

  "A Database" should "output all ebooks" in {
    val db = new DatabaseXML("src/test/resources/database.xml")
    assert(db.findBooks(bookType = "ebook").size === 2)
  }

  "A Database" should "find all books with 'Clean Coder' in title" in {
    val db = new DatabaseXML("src/test/resources/database.xml")
    assert(db.findBooks(title = "Clean Coder")(0).title === "Clean Coder")
  }

  "A Database" should "output a list with 1 element for title 'Clean Coder' and bookType 'book" in {
    val db = new DatabaseXML("src/test/resources/database.xml")
    val books = db.findBooksAdvanced("Clean Coder", "book")
    assert(books.length === 1)
  }
}
