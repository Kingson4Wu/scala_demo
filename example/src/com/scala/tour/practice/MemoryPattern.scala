package com.scala.tour.practice

/**
 * Created by kxw on 2015/7/5.
 */
/**
 * 记忆模式
记忆模式可以解决手动编写存取cache代码的麻烦。

这个例子中，memo可以将一个不含cache函数，包装成一个含有cache功能的。

还是斐波那契的例子，通过cache可以使性能提高。

尝试将

fibonacci_(n - 1) + fibonacci_(n - 2)
修改为

memo(fibonacci_)(n - 1) + memo(fibonacci_)(n - 2)
可以提高更多性能。
 */
object MemoryPattern {
  def main(args: Array[String]) {

    import scala.collection.mutable.WeakHashMap

    val cache = new WeakHashMap[Int, Int]
    def memo(f: Int => Int) = (x: Int) => cache.getOrElseUpdate(x, f(x))

    def fibonacci_(in: Int): Int = in match {
      case 0 => 0;
      case 1 => 1;
      //case n: Int => fibonacci_(n - 1) + fibonacci_(n - 2)
      case n: Int => memo(fibonacci_)(n - 1) + memo(fibonacci_)(n - 2)
    }
    val fibonacci: Int => Int = memo(fibonacci_)

    val t1 = System.currentTimeMillis()
    println(fibonacci(40))
    println("it takes " + (System.currentTimeMillis() - t1) + "ms")

    val t2 = System.currentTimeMillis()
    println(fibonacci(40))
    println("it takes " + (System.currentTimeMillis() - t2) + "ms")

  }
}
