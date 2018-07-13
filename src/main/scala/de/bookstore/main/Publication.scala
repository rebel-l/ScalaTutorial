package de.bookstore.main

object Lib {
  trait Publication[T] {
    def getQuantity(x: T): Int
  }

  def findAvailable[T: Publication](xs: List[T]): List[T] = {
    xs.filter(m => Publication[T].getQuantity(m) > 0)
  }

//  case class PublicationBook(x: Book) extends Publication[Book] {
//    def getQuantity = x.quantity
//  }
//
//  case class PublicationEBook(x: EBook) extends Publication[EBook] {
//    def getQuantity = x.quantity
//  }

  object Publication {
    def apply[A: Publication]: Publication[A] = implicitly[Publication[A]]

    implicit object PublicationMagazine extends Publication[Magazine] {
      def getQuantity(m: Magazine): Int = m.quantity
    }

    implicit object PublicationBook extends Publication[Book] {
      def getQuantity(b: Book): Int = b.quantity
    }

    implicit object PublicationEbook extends Lib.Publication[EBook] {
      def getQuantity(eb: EBook): Int = 1
    }
  }
}
