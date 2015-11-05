package com.scala.tour.base

/**
 * Created by kxw on 2015/7/4.
 */
object NameArgs {
  def main(args: Array[String]): Unit = {

    /**
    这个例子演示了按名称传递参数，由于有除以0，所以运行该程序会产生异常。

    试着将

    def log(msg: String)
    修改为

    def log(msg: => String)
    由按值传递修改为按名称传递后将不会产生异常。

    因为log函数的参数是按名称传递，参数会等到实际使用的时候才会计算，所以被跳过。

    按名称传递参数可以减少不必要的计算和异常。
     */


    var logEnable = false //val 不可变，var可变

    //def log(msg: String) =
    def log(msg: => String) =
      if (logEnable) println(msg)

    val MSG = "programing is running"

    log(MSG + 1 / 0)

    logEnable = true
    log(MSG)

  }
}
