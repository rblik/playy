package scalaproj.books.rdd

import org.apache.spark.rdd.RDD

import scalaproj.books.UserConfig.excludedBroadcast

/**
  * Created by Blik on 03/03/2017.
  */
object PopularRDDWordsService {


  def topX(lines: RDD[String], x: Int): List[String] = {
    val broadcast = excludedBroadcast
    lines.map(_.toLowerCase)
//      .flatMap(_.split(" "))
      .flatMap("\\w+".r.findAllIn(_))
      .filter(_.length > 3)
      .filter(!broadcast.value.contains(_))
      .map(_ -> 1)
      .reduceByKey(_ + _)
      .sortBy(_._2, ascending = false)
      .keys take x toList
  }

}
