package de.bookstore.main

object Lib {
  trait Publication[T] {
    def getQuantity: Int
  }

  def findAvailable[T](xs: List[Publication[T]]): List[Publication[T]] = {
    xs.filter(p => p.getQuantity > 0)
  }

  case class PublicationBook(x: Book) extends Publication[Book] {
    def getQuantity = x.quantity
  }

  case class PublicationEBook(x: EBook) extends Publication[EBook] {
    def getQuantity = x.quantity
  }
}
