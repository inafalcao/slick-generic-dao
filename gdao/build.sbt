name := """gdao"""
organization := "inafalcao"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

libraryDependencies += filters
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "inafalcao.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "inafalcao.binders._"
libraryDependencies += "org.scaldi" %% "scaldi-play" % "0.5.15"
libraryDependencies += "com.typesafe.play" %% "play-slick" % "2.1.0"
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1206-jdbc42"
