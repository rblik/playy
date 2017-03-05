package scalaproj.books.dataframe

import scalaproj.books.WriterJudge
import scalaproj.books.dataframe.DataFrameCreator.createBooksDF
import scalaproj.books.dataframe.PopularDFWordsService.{topX => popX}

/**
  * Created by Blik on 03/04/2017.
  */
object WriterJudgeDF extends WriterJudge{

  override def topX(author: String, x: Int): List[String] ={
    val dataFrame = createBooksDF("data/books/" + author + "/*.txt")
    popX(dataFrame, x)
  }
}
