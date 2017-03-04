name := "playy"

version := "1.0"

lazy val `playy` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.10.6"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core_2.10
libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.6.0" excludeAll ExclusionRule(organization = "javax.servlet")

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql_2.10
libraryDependencies += "org.apache.spark" % "spark-sql_2.10" % "1.6.0" excludeAll ExclusionRule(organization = "javax.servlet")

// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming_2.10
libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "1.6.0" excludeAll ExclusionRule(organization = "javax.servlet")

// https://mvnrepository.com/artifact/org.scalatest/scalatest_2.10
libraryDependencies += "org.scalatest" % "scalatest_2.10" % "3.0.1"

// https://mvnrepository.com/artifact/com.typesafe/config
libraryDependencies += "com.typesafe" % "config" % "1.3.1"

// https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml
libraryDependencies += "org.apache.poi" % "poi-ooxml" % "3.15"

libraryDependencies ++= Seq( jdbc , cache , ws   , specs2 % Test )

dependencyOverrides ++= Set(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.4"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

