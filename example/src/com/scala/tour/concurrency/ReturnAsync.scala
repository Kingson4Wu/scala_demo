package com.scala.tour.concurrency

/**
 * Created by kxw on 2015/7/5.
 */
/**
 * 异步返回
异步操作可以最大发挥效能。Scala的Future很强大，可以异步返回。

可以实现Future的onComplete方法。当Future结束的时候就会回调。

在调用ask的时候，可以设定超时。
 */
object ReturnAsync {
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

    val version = fromURL.ask(versionUrl)(akka.util.Timeout(5 * 1000))
    version onComplete {
      case msg => println(msg); system.shutdown
    }

  }
}
