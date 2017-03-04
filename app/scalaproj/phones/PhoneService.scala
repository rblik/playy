package scalaproj.phones

import org.apache.spark.rdd.RDD

/**
  * Created by Blik on 03/04/2017.
  */
object PhoneService {
  private val broadcast = CommonConfig.broadcast
  private val getOperator = (phone: String) => broadcast.value.getOrElse(phone.substring(0, phone.length - 7), Operator("", ""))

  def getFilteredByCountry(rdd: RDD[String], countries: Set[String]): List[String] = {
    rdd.filter(phone => countries.contains(getOperator(phone).country))
      .take(10).toList
  }
}
