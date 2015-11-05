package com.scala.tour.base

/**
 * Created by kxw on 2015/7/4.
 */



object Clazz {

  /**
  可以用class关键字来定义类。并通过new来创建类。

  在定义类时可以定义字段，如firstName，lastName。这样做还可以自动生成构造函数。

  可以在类中通过def定义函数。var和val定义字段。

  函数名是任何字符如+,-,*,/。

  试着将

  obama.age_=(51)
  简化为

  obama.age = 51
  这样的简化更像调用一个变量。
   */

  def main(args: Array[String]): Unit = {

    class Person(val firstName: String, val lastName: String) {

      private var _age = 0

      def age = _age //get方法

      def age_=(newAge: Int) = _age = newAge //set 方法

      //getter ， setter 名字固定

      def fullName() = firstName + " " + lastName

      override def toString() = fullName()
    }

    val obama: Person = new Person("Barack", "Obama")

    println("Person: " + obama)
    println("firstName: " + obama.firstName)
    println("lastName: " + obama.lastName)
    obama.age_=(51)
    println("age: " + obama.age)
    obama.age=52
    println("age: " + obama.age)
  }
}