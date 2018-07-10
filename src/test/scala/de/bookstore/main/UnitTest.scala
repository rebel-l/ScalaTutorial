package de.bookstore.main

import org.scalatest._

class UnitTest(component: String) extends FlatSpec{
  "A Book" should "print the right digit" in {
    val book = new Book("Clean Code", "Uncle Bob", 3826655486L)
    assert(book.getDigit === "6")
  }
}
