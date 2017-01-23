package com.scala.examples.base

/**
 * 1. <- 在 scala 中称为 generator
 * 2. until, to 关键字
 * 3. 带 if 条件的 for 循环
 * 4. 嵌套 for 循环
 * 5. for yield
 */
object ForSettementTest {

  def main(args: Array[String]) {
    baseFor
    forTest2
  }

  def baseFor {
    // 1. <- 在 scala 中称为 generator
    // <- 用于遍历集合对象(可遍历对象) B，在每次遍历的过程中，生成一个新的对象 A(本例中的i变量)，这个 A 是 val，而不是 var，然后对循环体中对 A 进行处理
    // 不需要显式的指定A的类型，因为Scala使用自动推导的方式根据B的元素类型得出A的类型
    for (i <- 0 to 3) {
      println(i) // 0,1,2,3  包含开始和结束
    }

    for (i <- 0 until 3) {
      println(i) // 0,1,2  含开始不含结束
    }

    // 2. until, to 关键字
    val r: Range = 10 to 13 // 10,11,12,13
    val r1 = 10.to(13) // 等价 10 to 13
    val r2 = 10 to (13, 2) // 10,12 （[10, 13] 步长为2迭代）
    for (i <- r2) {
      println(i)
    }

    // 3. 带 if 条件的 for 循环
    val myArray: Array[String] = new Array[String](10)
    for (i <- 0 until myArray.length) {
      myArray(i) = "value " + i;
    }

    for (str <- myArray if str.endsWith("3")) {
      println(str) // value 3
    }

    for (str <- myArray if str.endsWith("3") if str.endsWith("5")) {
      println(str) // 没有任何输出，相当于语句： str.endsWith("3") && str.endsWith("5")
    }

    // 4. 嵌套 for 循环
    for (i <- 0 until 3; j <- 0 to 3) {
      println(i + ":" + j) // 0:0,0:1,0:2,0:3,1:0,1:1,...2:3
    }

    // 5. for yield, scala 中的 for 循环是有返回值的

    // yield 关键字的简短总结:
    // 针对每一次 for 循环的迭代, yield 会产生一个值，被循环记录下来 (内部实现上，像是一个缓冲区).
    // 当循环结束后, 会返回所有 yield 的值组成的集合.
    // 返回集合的类型与被遍历的集合类型是一致的.
    val ia: Array[Int] = Array(0, 1, 2, 3, 4, 5)
    val t = for (i <- ia if i % 2 == 0) yield i;
    t.foreach(println) // 0,2,4

    val t2 = for (i <- ia) yield i * 2
    t2.foreach(println) // 0, 2, 4, 6, 8, 10
  }

  def forTest2 {
    val r = for {
      i <- 0 until 10
      if i % 2 == 0
      if i > 5
    } yield i

    r.foreach(println) // 6,8
  }

}