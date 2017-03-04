package scalaproj.spark

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

import scala.reflect.ClassTag

/**
  * Created by Blik on 03/02/2017.
  */
object SparkContextLoader {
  val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("wordcount"))
  val sql = new SQLContext(sc)
  def broadcast[T: ClassTag](value: T): Broadcast[T] = sc.broadcast(value: T)
}
