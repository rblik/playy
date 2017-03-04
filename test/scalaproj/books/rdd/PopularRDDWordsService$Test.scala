package scalaproj.books.rdd

import org.scalatest.FunSuite

import scalaproj.books.rdd.PopularRDDWordsService.topX
import scalaproj.spark.SparkContextLoader.sc

/**
  * Created by Blik on 03/04/2017.
  */
class PopularRDDWordsService$Test extends FunSuite {

  test("testTopX") {
    val rdd = sc.parallelize(List("java", "java", "java", "scala", "groovy", "groovy"))

    assertResult("java") {
      val top1 = topX(rdd, 1)
      top1.head
    }

  }

}
