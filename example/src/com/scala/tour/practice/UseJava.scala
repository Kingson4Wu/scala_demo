package com.scala.tour.practice

/**
 * Created by kxw on 2015/7/5.
 */
/**
 * 使用Java
Scala和Java可以非常方便的互操作，前面已经有大量Scala直接使用Java的例子。

同样Java也可以使用Scala。这个例子演示使用@BeanProperty注解来生成Java Style的Bean。

尝试将

var name: String
修改为

//@BeanProperty var name: String
这样就给bean添加了getter/setter。 Apache BeanUtils就可以正常工作。
 */
object UseJava {
  def main(args: Array[String]) {

    //import org.apache.commons.beanutils.BeanUtils
    import scala.beans.BeanProperty

    class SimpleBean(@BeanProperty var name: String) {
    }

    val bean = new SimpleBean("foo")

    //println(BeanUtils.describe(bean))

  }

}
