package com.scala.tour.function

/**
 * Created by kxw on 2015/7/4.
 */
/**
模式匹配
模式匹配是类似switch-case特性，但更加灵活；也类似if-else，但更加简约。

这个例子展示的使用用模式匹配实现斐波那契。 使用case来匹配参数，如果case _，则可以匹配任何参数。

试着将

case n: Int
修改为

case n: Int if (n > 1)
case后添加if语句判断,这样修改当输入负数时，就不会无限循环。

模式匹配也可以匹配类型，在case _ 前加上

case n: String => fibonacci(n.toInt)
这样就可以匹配String类型
 */
object PatternMatch {
  def main(args: Array[String]): Unit = {

    def fibonacci(in: Any): Int = in match {
      case 0 => 0
      case 1 => 1
      case n: Int if (n > 1) => fibonacci(n - 1) + fibonacci(n - 2)
      case n: String => fibonacci(n.toInt)
      case _ => 0
    }

    println(fibonacci(3))
    println(fibonacci(-3))
    println(fibonacci("4"))

  }
}
