package com.scala.tour.base

/**
 * Created by kxw on 2015/7/4.
 */

/**
Traits就像是有函数体的Interface。使用with关键字来混入。

这个例子是给java.util.ArrayList添加了foreach的功能。

试着再在with ForEachAble[Int]后面加上

with JsonAble
给list添加toJson的能力
 */
/**
 * Traits 和 super.method ，override一起使用，功能强大。
 * super.method 是调用左边混入的traits的方法
 */

object Traits {
  def main(args: Array[String]): Unit = {

    trait ForEachAble[A] {
      def iterator: java.util.Iterator[A]
      def foreach(f: A => Unit) = {
        val iter = iterator
        while (iter.hasNext)
          f(iter.next)
      }
    }

    trait JsonAble {
      def toJson() =
        scala.util.parsing.json.JSONFormat.defaultFormatter(this)
    }

    val list = new java.util.ArrayList[Int]() with ForEachAble[Int]  with JsonAble
    list.add(1); list.add(2)

    println("For each: "); list.foreach(x => println(x))
    println("Json: " + list.toJson())

  }
}
