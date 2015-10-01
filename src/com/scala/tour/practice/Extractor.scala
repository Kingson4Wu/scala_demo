package com.scala.tour.practice

/**
 * Created by kxw on 2015/7/5.
 */
/**
 * 抽取器
抽取器可以帮助模式匹配进行解构。

这个例子是构建一个Email抽取器，只要实现unapply函数就可以了。

Scala的正则表达式会自带抽取器，可以抽取出一个List。List里的元素是匹配()里的表达式。

抽取器很有用，短短的例子里就有两处使用抽取器：

case user :: domain :: Nil
解构List

case Email(user, domain)
解构Email。
 */
object Extractor {
  def main(args: Array[String]) {

    import scala.util.matching.Regex

    object Email {
      def unapply(str: String) = new Regex("""(.*)@(.*)""")
        .unapplySeq(str).get match {
        case user1 :: domain :: Nil => Some(user1, domain)
        case _ => None
      }
    }

    "user@domain3.com" match {
      case Email(user2, domain) => println(user2 + "@" + domain)
    }

  }
}
