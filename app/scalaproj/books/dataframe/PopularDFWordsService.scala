package scalaproj.books.dataframe

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

import scalaproj.books.UserConfig.excludedBroadcast

/**
  * Created by Blik on 03/04/2017.
  */
object PopularDFWordsService {

  def topX(lines: DataFrame, x: Int): List[String] = {
    val broadcast = excludedBroadcast
    lines.withColumn("word", lower(col("word")))
      .where(length(col("word")) > 3)
      .filter(not(col("word").isin(broadcast.value.toSeq: _*)))
      .groupBy(col("word")).agg(count("word").as("count"))
      .sort(col("count").desc)
      .take(x)
      .map(r => r(0).toString)
      .toList
  }
}
