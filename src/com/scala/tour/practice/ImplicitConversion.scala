package com.scala.tour.practice

/**
 * Created by kxw on 2015/7/5.
 */
/**
 *

隐式转换
implicit可以定义一个转换函数，可以在使用相应类型的时候自动转换。

这个例子可以将String自动转换为Date类型。隐式转换是实现DSL的重要工具。
 */
object ImplicitConversion {
  def main(args: Array[String]) {

    import java.text.SimpleDateFormat

    implicit def strToDate(str: String) =
      new SimpleDateFormat("yyyy-MM-dd").parse(str)

    println("2013-01-01 unix time: " + "2013-01-01".getTime()/1000l)

    println("2013-01-01 unix time: " + "2013-01-01".concat("-kingson"))

  }
}
