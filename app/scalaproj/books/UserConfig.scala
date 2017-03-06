package scalaproj.books

import com.typesafe.config.ConfigFactory.load
import org.apache.spark.broadcast.Broadcast

import scalaproj.spark.SparkContextLoader.sc

/**
  * Created by Blik on 03/03/2017.
  */
object UserConfig {
  @transient
  private val excluded = load("user").getString("garbage").split(", ").toSet[String]

  val excludedBroadcast: Broadcast[Set[String]] = sc.broadcast(excluded)
}
