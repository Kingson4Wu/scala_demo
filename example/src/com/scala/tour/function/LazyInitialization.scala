package com.scala.tour.function

/**
 * Created by kxw on 2015/7/4.
 */
/**
 * Lazy初始化
Lazy可以延迟初始化字段。加上lazy的字段会在第一次访问的时候初始化，而不是类初始化的时候初始化。

这个例子是从github获得Scala的版本号，由于访问网络需要较多时间。可以使用lazy来延迟获取。 防止可能的浪费。

Lazy非常适合于初始化非常耗时的场景
 */
object LazyInitialization {

  def main(args: Array[String]): Unit = {

    class ScalaCurrentVersion(val url: String) {
      lazy val source= {
        println("fetching from url...")
        scala.io.Source.fromURL(url).getLines().toList
      }
      lazy val majorVersion = source.find(_.contains("version.major"))
      lazy val minorVersion = source.find(_.contains("version.minor"))
    }

    val version = new ScalaCurrentVersion(
      "https://raw.github.com/scala/scala/master/build.number")
    println("get scala version from " + version.url)
    version.majorVersion.foreach(println _)//list.foreach(x => println(x))
    version.minorVersion.foreach(println _)

  }
}
