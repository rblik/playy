package scalaproj.books.dataframe

import org.scalatest.FunSuite

import scalaproj.books.dataframe.DataFrameCreator.create

/**
  * Created by Blik on 03/04/2017.
  */
class PopularDFWordsService$Test extends FunSuite {

  test("testTopX") {
    val df = create("data/books/" + "kafka" + "/*.txt")
    PopularDFWordsService.topX(df, 5).foreach(println)
  }
}
