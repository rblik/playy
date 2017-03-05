package scalaproj.phones.dataframe

import org.scalatest.FunSuite

import scalaproj.books.dataframe.DataFrameCreator._

/**
  * Created by Blik on 03/05/2017.
  */
class PhoneServiceDF$Test extends FunSuite {

  test("testGetCountByCountry") {
    val df = createPhonesDF("data/phone/file.txt")
    PhoneServiceDF.getCountByCountry(df, Set("Israel"))
  }
}
