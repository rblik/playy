package scalaproj.phones.dataframe

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.{col, count, udf}
import org.apache.spark.storage.StorageLevel

import scalaproj.phones.{CommonConfig, Operator}

/**
  * Created by Blik on 03/05/2017.
  */
object PhoneServiceDF {
  private val broadcast = CommonConfig.broadcast

  def getCountByCountry(phones: DataFrame, countries: Set[String]): Long = {

    val country = udf((phone: String) => broadcast.value.getOrElse(phone.substring(0, phone.length - 7), Operator("", "")).country)

//    http://apache-spark-user-list.1001560.n3.nabble.com/How-to-trace-debug-serialization-td18230.html#a18254
    val dataFrame = phones
      .withColumn("phone", col("phone"))
      .withColumn("country", country(col("phone")))
      .filter(col("country").isin(countries.toSeq: _*))
      .select(col("country"))
      .groupBy(col("country")).agg(count("country").as("count"))
      .sort(col("count").desc)
    dataFrame.persist(StorageLevel.MEMORY_ONLY)
    dataFrame.show
    dataFrame.count
  }
}
