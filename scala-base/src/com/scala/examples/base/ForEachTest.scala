package com.scala.examples.base

/**
 * foreach 的用法
 * 
 * @author liaozhicheng.cn@163.com
 */
object ForEachTest {

  def main(args: Array[String]) {
    stringForEach("hello world")
    listForEach // 方法没有参数，调用时，直接连括号都可以不用
    mapForEach
  }

  def stringForEach(str: String) {
    str.foreach(println);
  }

  def listForEach {
    val list = List(1, 2, 3)
    list.foreach((i: Int) => println(i))
    list.foreach(i => println(i)) // Int 类型可省略
    list.foreach(println _) // 迭代器，只有一个参数，可以使用 _ 通配符来替代一个临时变量i
    list.foreach(println) // 只有一个参数，也可以直接省略
  }

  def mapForEach {
    val map = Map("a" -> 1, "b" -> 2, "c" -> 3);
    map.foreach(x => println("key: " + x._1 + ", value: " + x._2)) // key: _1, value: _2
  }

}