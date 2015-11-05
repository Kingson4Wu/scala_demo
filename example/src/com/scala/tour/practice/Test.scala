package com.scala.tour.practice

/**
 * Created by kxw on 2015/7/5.
 */
/**
 * 测试
Scala可以使用Spec2，ScalaTest来测试， DSL可以使测试更方便。

这个例子是测试一个阶乘函数。使用should/in来建立测试用例。

测试是默认并发执行的。
 */
object Test {
  def main(args: Array[String]) {


    import org.specs2.mutable._

    class FactorialSpec extends Specification {
      args.report(color = false)

      def factorial(n: Int) = (1 to n).reduce(_ * _)

      "The 'Hello world' string" should {
        "factorial 3 must be 6" in {
          factorial(3) mustEqual 6
        }
        "factorial 4 must greaterThan 6" in {
          factorial(4) must greaterThan(6)
        }
      }
    }
    specs2.run(new FactorialSpec)

  }
}
