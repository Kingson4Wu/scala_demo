package com.scala.tour.function

/**
 * Created by kxw on 2015/7/4.
 */
/**
函数式的威力
这个例子是用指令式编程判断一个List中是否含有奇数。

试着将

containsOdd(list)
替换为

list.exists((x: Int) => x % 2 ==1)
通过将函数作为参数，可以使程序更简洁。还可以再简化为

list.exists(_ % 2 == 1)
可以用_替代参数

相比于Ruby等动态语言,这威力来自于科学而不是魔法
 */

object FunctionPower {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)

    def containsOdd(list: List[Int]): Boolean = {
      for (i <- list) {
        if (i % 2 == 1)
          return true;
      }
      return false;
    }

    println("list contains Odd ? " + containsOdd(list))
    println("list contains Odd ? " + list.exists((x: Int) => x % 2 ==1))
    println("list contains Odd ? " + list.exists(_ % 2 == 1))

    println("list contains Odd ? " + list.exists(_ == 5))
    println("list contains Odd ? " + list.contains(2))

  }
}
