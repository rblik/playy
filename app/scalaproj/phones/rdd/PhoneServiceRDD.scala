package scalaproj.phones.rdd

import org.apache.spark.rdd.RDD

import scalaproj.phones.{CommonConfig, Operator}

/**
  * Created by Blik on 03/04/2017.
  */
object PhoneServiceRDD {
  private val broadcast = CommonConfig.broadcast
  private val getOperator = (phone: String) => broadcast.value.getOrElse(phone.substring(0, phone.length - 7), Operator("", ""))

  def getFilteredByCountry(rdd: RDD[String], countries: Set[String]): List[String] = {
    rdd.filter(phone => countries.contains(getOperator(phone).country))
      .take(10).toList
  }
}
