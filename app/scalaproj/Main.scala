package scalaproj

import akka.actor.Actor

import scalaproj.books.rdd.WriterJudgeRDD

/**
  * Created by Blik on 03/04/2017.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val kafka = WriterJudgeRDD.topX("kafka", 5)
    println("kafka = " + kafka.mkString(", "))
  }
}
