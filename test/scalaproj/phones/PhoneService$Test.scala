package scalaproj.phones

import org.scalatest.FunSuite
import scalaproj.spark.SparkContextLoader.sc

/**
  * Created by Blik on 03/04/2017.
  */
class PhoneService$Test extends FunSuite {

  test("testGetFilteredByCountry") {
    val rdd = sc.textFile("data/phone/file.txt")
    PhoneService.getFilteredByCountry(rdd, Set("Israel")).foreach(println)
  }

}
