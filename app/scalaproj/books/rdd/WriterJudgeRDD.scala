package scalaproj.books.rdd

import scalaproj.books.WriterJudge
import scalaproj.books.rdd.PopularRDDWordsService.{topX => popX}
import scalaproj.spark.SparkContextLoader._

/**
  * Created by Blik on 03/04/2017.
  */
object WriterJudgeRDD extends WriterJudge{

  override def topX(author: String, x: Int): List[String] = {
    val rdd = sc.textFile("data/books/" + author + "/*.txt")
    popX(rdd, x)
  }
}
