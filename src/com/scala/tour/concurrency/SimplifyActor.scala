package com.scala.tour.concurrency

/**
 * Created by kxw on 2015/7/5.
 */
/**
 * Actor更简化的用法
可以通过更简化的办法声明Actor。

通过

akka.actor.ActorDSL
中的actor函数。这个函数可以接受一个Actor的构造器Act，启动并返回Actor。
 */
object SimplifyActor {
  def main(args: Array[String]): Unit = {

    import akka.actor.ActorDSL._
    import akka.actor.ActorSystem

    implicit val system = ActorSystem()

    val echoServer = actor(new Act {
      become {
        case msg => println("echo " + msg)
      }
    })
    echoServer ! "hi"
    system.shutdown

  }

}
