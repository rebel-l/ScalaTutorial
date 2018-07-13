package de.bookstore.main

import scala.collection.mutable.ListBuffer

class IndexTypeMember {
  type ElementType

  val els = ListBuffer[ElementType]()

  def add(e: ElementType) = {
    els += e
  }

  def remove(e: ElementType) = {
    els -= e
  }
}
