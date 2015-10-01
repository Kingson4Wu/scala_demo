package com.scala.tour.practice

/**
 * Created by kxw on 2015/7/5.
 */
/**
 * 相等性
在Scala中==等效于equals，这一点和Java不同。更自然一些。

写一个完全正确的equal函数并不容易，这个例子也有子类会不对称的Bug。

尝试将class修改为case class,并删除equals函数。

case类会自动生成正确的equals函数。
 */
object Equality {
  def main(args: Array[String]) {

    class Person(val name: String) {
      override def equals(other: Any) = other match {
        case that: Person => name.equals(that.name)
        case _ => false
      }
    }

    println(new Person("Black") == new Person("Black"))

  }
}
