package com.scala.tour.function

/**
 * Created by kxw on 2015/7/4.
 */

/**
 * Word Count
Word Count是一个MapReduce的一个经典示例。在函数式编程中，Word Count最直观的实现方法也是MapReduce。

这个例子介绍了List的两个重要的高阶方法map和reduceLeft。

map接受一个转换函数,返回转换结果。

reduceLeft接受一个合并函数，依次遍历合并。

使用高阶方法可以代替大部分需要循环的操作，使代码更清晰
 */
object WordCount {
  def main(args: Array[String]): Unit = {

    val file = List("warn 2013 msg", "warn 2012 msg msg",
      "error 2013 msg", "warn 2013 msg")

    def wordcount(str: String): Int = str.split(" ").count("msg" == _)

    val num = file.map(wordcount).reduceLeft(_ + _)

    println("wordcount:" + num)

    val map =file.map(wordcount)

    map.foreach(x => println(x))

    println("-----------")
    println(map.take(0))
    println(map.take(1))
    println(map.take(5))
    println("-----------")
    println(map.contains(3))
    println(map.contains(1))
    println("-----------")
    println(map.toList)


  }
}
