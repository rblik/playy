package scalaproj.books.dataframe

import org.apache.spark.sql.DataFrame

import scalaproj.spark.SparkContextLoader
import scalaproj.spark.SparkContextLoader.sc
import SparkContextLoader.sql.implicits._

/**
  * Created by Blik on 03/04/2017.
  */
object DataFrameCreator {
  val create: (String) => DataFrame = (path: String) =>  sc.textFile(path).flatMap("\\w+".r.findAllIn(_)).toDF("word")
}
