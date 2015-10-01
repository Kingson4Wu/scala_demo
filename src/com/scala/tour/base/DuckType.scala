package com.scala.tour.base

/**
 * Created by kxw on 2015/7/4.
 */

/**
走起来像鸭子，叫起来像鸭子，就是鸭子。

这个例子中使用

{ def close(): Unit }
作为参数类型。因此任何含有close()的函数的类都可以作为参数。

不必使用继承这种不够灵活的特性。
 */

object DuckType {
  def main(args: Array[String]): Unit = {

    /*def withClose(closeAble: {def close(): Unit},
                  op: {def close(): Unit} => Unit) {*/
      def withClose(closeAble: {def close(): Unit})
                   (op: {def close(): Unit} => Unit) {//Currying
      try {
        op(closeAble)
      } finally {
        closeAble.close()
      }
    }
    /**
     * 参数：
     * （1）普通变量：a : type
     * （2）函数：b : type => type
     */

    class Connection {
      def close() = println("close Connection")
    }

    val conn: Connection = new Connection()
    withClose(conn)( conn =>
      println("do something with Connection"))

  }

}

/**
柯里化
这个例子和上面的功能相同。不同的是使用了柯里化(Currying)技术。

def add(x:Int, y:Int) = x + y
是普通的函数

def add(x:Int) = (y:Int) => x + y
是柯里化后的函数，相当于返回一个匿名函数表达式。

 def add(x:Int)(y:Int) = x + y
是简化写法

柯里化可以让我们构造出更像原生语言提供的功能的代码
 */
