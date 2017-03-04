package controllers

import play.api.mvc._

import scalaproj.books.dataframe.WriterJudgeDF

object Application extends Controller {

  def topX(writer: String, x: String) = Action {
    Ok(WriterJudgeDF.topX(writer, x.toInt).mkString("\n"))
  }

  def compare(writer1: String, writer2: String, x: String) = Action {
    Ok(WriterJudgeDF.compare(writer1, writer2, x.toInt).toString)
  }
}