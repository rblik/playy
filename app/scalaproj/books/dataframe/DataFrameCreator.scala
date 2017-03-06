package scalaproj.books.dataframe

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.DataFrame

import scalaproj.spark.SparkContextLoader
import scalaproj.spark.SparkContextLoader.sc
import SparkContextLoader.sql.implicits._

/**
  * Created by Blik on 03/04/2017.
  */
object DataFrameCreator {
  val rdd: String => RDD[String] = (path: String) => sc.textFile(path)
  val rowDF: String => DataFrame = (path: String) =>  rdd(path).flatMap("\\w+".r.findAllIn(_)).toDF("word")
  val wordDF: String => DataFrame = (path: String) =>  rdd(path).toDF("phone")
}
