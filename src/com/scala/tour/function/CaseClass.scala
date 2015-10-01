package com.scala.tour.function

/**
 * Created by kxw on 2015/7/4.
 */
/**
 *
Case Class
case class 顾名思义就是为case语句专门设计的类， 在普通类的基础上添加了和类名一直的工厂方法， 还添加了hashcode,equals和toString等方法。

由于使用了require(n >= 0)来检验参数，如果使用负数计算，将会抛出异常。
 */
object CaseClass {

  def main(args: Array[String]): Unit = {

    abstract class Expr

    case class FibonacciExpr(n: Int) extends Expr {
      require(n >= 0)
    }

    case class SumExpr(a: Expr, b: Expr) extends Expr

    def value(in: Expr): Int = in match {
      case FibonacciExpr(0) => 0
      case FibonacciExpr(1) => 1
      case FibonacciExpr(n) =>
        value(SumExpr(FibonacciExpr(n - 1), FibonacciExpr(n - 2)))
      case SumExpr(a, b) => value(a) + value(b)
      case _ => 0
    }
    println(value(FibonacciExpr(3)))

  }
}
