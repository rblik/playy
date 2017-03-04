package scalaproj.books

import com.typesafe.config.ConfigFactory.load
import scalaproj.spark.SparkContextLoader.sc

/**
  * Created by Blik on 03/03/2017.
  */
object UserConfig {
  @transient
  private val excluded = load("user").getString("garbage").split(", ").toSet[String]

  val excludedBroadcast = sc.broadcast(excluded)
}
