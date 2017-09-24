package nexus.algebra.instances

import nexus.algebra._

object Int8 extends IsInt[Byte] {
  def add(x: Byte, y: Byte) = (x + y).toByte
  def neg(x: Byte) = (-x).toByte
  def sub(x: Byte, y: Byte) = (x - y).toByte
  def mul(x: Byte, y: Byte) = (x * y).toByte
  def zero = 0
  def one = 1
}

object Int16 extends IsInt[Short] {
  def add(x: Short, y: Short) = (x + y).toShort
  def neg(x: Short) = (-x).toShort
  def sub(x: Short, y: Short) = (x - y).toShort
  def mul(x: Short, y: Short) = (x * y).toShort
  def zero = 0
  def one = 1
}

object Int32 extends IsInt[Int] {
  def add(x: Int, y: Int) = x + y
  def neg(x: Int) = -x
  def sub(x: Int, y: Int) = x - y
  def mul(x: Int, y: Int) = x * y
  def zero = 0
  def one = 1
}

object Int64 extends IsInt[Long] {
  def add(x: Long, y: Long) = x + y
  def neg(x: Long) = -x
  def sub(x: Long, y: Long) = x - y
  def mul(x: Long, y: Long) = x * y
  def zero = 0l
  def one = 1l
}
