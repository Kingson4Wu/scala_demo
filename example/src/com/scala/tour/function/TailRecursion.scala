package com.scala.tour.function

/**
 * Created by kxw on 2015/7/4.
 */

/**
 * 尾递归
尾递归是递归的一种，特点在于会在函数的最末调用自身。尾递归是函数式编程的常见写法。

这个例子是foldLeft的尾递归实现。foldLeft和reduceLeft相比更常用，多一个初始参数。

当用List做match case时。可以使用 :: 来解构。返回第一个元素head和剩余元素tail。

注：尾递归会在编译期优化，因此不用担心递归造成的栈溢出问题。
 */

object TailRecursion {
  def main(args: Array[String]): Unit = {

    val file = List("warn 2013 msg", "warn 2012 msg",
      "error 2013 msg", "warn 2013 msg")

    def wordcount(str: String): Int = str.split(" ").count("msg" == _)

    def foldLeft(list: List[Int])(init: Int)(f: (Int, Int) => Int): Int = {
      list match {
        case List() => init
        case head :: tail => foldLeft(tail)(f(init, head))(f)
      }
    }

    val num = foldLeft(file.map(wordcount))(0)(_ + _)

    println("wordcount:" + num)

  }
}
