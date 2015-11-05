package com.scala.tour.concurrency

/**
 * Created by kxw on 2015/7/5.
 */
/**
 * 并行集合
这个例子是访问若干URL，并记录时间。如果能并行访问，就可以大幅提高性能。

尝试将

urls.map
修改为

urls.par.map
这样每个map中的函数都可以并发执行。

当函数式和并发结合，就会这样让人兴奋。
 */
object ParallelCollection {
  def main(args: Array[String]) {

    val urls = List("http://scala-lang.org",
      "https://github.com/yankay/scala-tour")

    def fromURL(url: String) = scala.io.Source.fromURL(url)
      .getLines().mkString("\n")

    val t = System.currentTimeMillis()
    urls.map(fromURL(_))
    println("time: " + (System.currentTimeMillis - t) + "ms")

    val t2 = System.currentTimeMillis()
    urls.par.map(fromURL(_))//并行集合
    //返回一个map，只不过这个map是并行去执行fromURL()函数生成的
    println("time: " + (System.currentTimeMillis - t2) + "ms")

  }
}
