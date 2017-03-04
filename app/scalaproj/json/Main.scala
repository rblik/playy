package scalaproj.json

import scalaproj.spark.SparkContextLoader.sql
import org.apache.spark.sql.functions._

/**
  * Created by Blik on 03/04/2017.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val linkedIn = sql.read.json("data/linkedin/*.json")
    linkedIn.show()

    val withSalary = linkedIn.withColumn("salary", size(col("keywords")) * col("age") * 10)
    withSalary.show()

    val keywords = linkedIn.select(explode(col("keywords")).as("keyword"))
    keywords.show()

    val orderBy = keywords.groupBy(col("keyword")).agg(count("keyword").as("amount")).orderBy(col("amount").desc)
    orderBy.show()

    val first = orderBy.first()(0)
    println("most popular word is " + first)

    val select = withSalary.where(col("salary").leq(1200).and(array_contains(col("keywords"), first))).select("name")
    select.show()
  }

}
