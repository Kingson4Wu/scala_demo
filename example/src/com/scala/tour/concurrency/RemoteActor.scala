package com.scala.tour.concurrency

/**
 * Created by kxw on 2015/7/5.
 */
/**
 * 远程Actor
Actor是并发模型，也使用于分布式。

这个例子创建一个Echo服务器，通过actorOf来注册自己。

然后再创建一个client，通过akka url来寻址。

除了是通过url创建的，其他使用的方法和普通Actor一样。
  *
  */
object RemoteActor {
  def main(args: Array[String]) {

    import akka.actor.{Actor, Props}
    import com.typesafe.config.ConfigFactory

    implicit val system = akka.actor.ActorSystem("RemoteSystem",
      ConfigFactory.load.getConfig("remote"))
    class EchoServer extends Actor {
      def receive = {
        case msg: String => println("echo " + msg)
      }
    }

    val server = system.actorOf(Props[EchoServer], name = "echoServer")

    //val echoClient = system.actorFor("akka://RemoteSystem@127.0.0.1:2552/user/echoServer")
    val echoClient = system.actorSelection( "/RemoteSystem@127.0.0.1:2552/user/echoServer")

    echoClient ! "Hi Remote"

    //system.shutdown()
    system.terminate()


  }
}
