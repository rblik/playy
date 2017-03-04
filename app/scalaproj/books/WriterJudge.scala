package scalaproj.books

/**
  * Created by Blik on 03/04/2017.
  */
trait WriterJudge {
  def topX(author: String, x: Int): List[String]

  def compare(writer1: String, writer2: String, x: Int): Int = {
    val writer1Words = topX(writer1, x)
    val writer2Words = topX(writer2, x)
    writer1Words.intersect(writer2Words).length
  }
}
