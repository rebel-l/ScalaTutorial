package de.bookstore.main

import scala.collection.mutable.ListBuffer

trait IndexTypeParameter[T] {
  val els = ListBuffer[T]()

  def add(e: T) = {
    els += e
  }

  def remove(e: T) = {
    els -= e
  }
}
