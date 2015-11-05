package com.scala.tour.function

/**
 * Created by kxw on 2015/7/4.
 */
/**
  函数式真正的威力
函数式除了能简化代码外，更重要的是他关注的是Input和Output，函数本身没有副作用。

就是Unix pipeline一样，简单的命令组合在一起威力无穷。

如果你喜欢Unix pipeline的方式，你一定也会喜欢函数式编程。

这个例子是用函数式的代码模拟

cat file | grep 'warn' | grep '2013' | wc
List的filter方法接受一个过滤函数，返回一个新的List，作为下一个方法的输入。
 */
object FunctionTruePower {
  def main(args: Array[String]): Unit = {

    val file = List("warn 2013 msg", "warn 2012 msg",
      "error 2013 msg", "warn 2013 msg")

    println("cat file | grep 'warn' | grep '2013' | wc : "
      + file.filter(_.contains("warn")).filter(_.contains("2013")).size)

    println(file.contains("warn"))

  }

}
