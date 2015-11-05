package com.scala.tour.concurrency

import java.util.concurrent.TimeUnit

/**
 * Created by kxw on 2015/7/5.
 */
/**
 * 同步返回
Actor非常适合于较耗时的操作。比如获取网络资源。

这个例子通过调用ask函数来获取一个Future。

在Actor内部通过 sender ! 传递结果。

Future像Option一样有很多高阶方法，可以使用foreach查看结果。
 */
object ReturnSync {
  def main(args: Array[String]) {


    import akka.actor.ActorDSL._
    import akka.pattern.ask

    implicit val ec = scala.concurrent.ExecutionContext.Implicits.global
    implicit val system = akka.actor.ActorSystem()

    val versionUrl = "https://raw.github.com/scala/scala/master/starr.number"

    val fromURL = actor(new Act {
      become {
        case url: String => sender ! scala.io.Source.fromURL(url)
          .getLines().mkString("\n")
      }
    })

    val version = fromURL.ask(versionUrl)(akka.util.Timeout(5 ,TimeUnit.SECONDS))
    version.foreach(println _)

    system.shutdown

  }
}
