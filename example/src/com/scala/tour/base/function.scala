package com.scala.tour.base

/**
 * Created by kxw on 2015/7/4.
 */
object function {
  def main(args: Array[String]): Unit = {

    /**
    可以使用def来定义一个函数。函数体是一个表达式。

    使用Block表达式的时候，默认最后一行的返回是返回值，无需显式指定。

    函数还可以像值一样，赋值给var或val。因此函数也可以作为参数传给另一个函数。
     **/
    def square(a: Int) = a * a

    def squareWithBlock(a: Int) = {
      a * a
    }

    val squareVal = (a: Int) => a * a

    def addOne(f: Int => Int, arg: Int) = f(arg) + 1

    println("square(2):" + square(2))
    println("squareWithBlock(2):" + squareWithBlock(2))
    println("squareVal(2):" + squareVal(2))
    println("addOne(squareVal,2):" + addOne(squareVal, 2))
  }
}
