package com.scala.tour.base

/**
 * Created by kxw on 2015/7/4.
 */

/**
范型
之前的例子可以使用泛型变得更简洁更灵活。

试着将

"123456"
修改为

123456
虽然msg由String类型变为Int类型，但是由于使用了泛型，代码依旧可以正常运行。
 */
object Generics {
  def main(args: Array[String]): Unit = {


    def withClose[A <: {def close() : Unit}, B](closeAble: A)(f: A => B): B =
      try {
        f(closeAble)
      } finally {
        closeAble.close()
      }

    class Connection {
      def close() = println("close Connection")
    }
    val conn: Connection = new Connection()
    val msg = withClose(conn) { conn => {
      println("do something with Connection")
      "123456"
    }
    }

    println(msg)

  }
}
