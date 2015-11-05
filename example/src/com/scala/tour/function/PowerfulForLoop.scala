package com.scala.tour.function

/**
 * Created by kxw on 2015/7/4.
 */

/**
 * 更强大的For循环
循环语句是指令式编程的常见语句，Scala对其加以改进，成为适应函数式风格的利器。

For循环也是有返回值的，返回的是一个List。在每一轮迭代中加入yield，yield后的值可以加入到List中。

这个例子是使用for循环代替map函数。
 */
object PowerfulForLoop {
  def main(args: Array[String]): Unit = {

    val file = List("warn 2013 msg", "warn 2012 msg",
      "error 2013 msg", "warn 2013 msg")

    def wordcount(str: String): Int = str.split(" ").count("msg" == _)

    val counts =
      for (line <- file)
        yield wordcount(line)

    val num = counts.reduceLeft(_ + _)

    println("wordcount:" + num)

  }
}
