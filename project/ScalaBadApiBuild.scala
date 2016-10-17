import sbt._
import sbt.Keys._

object ScalatBadApiBuild extends Build {

  lazy val scalabadapi = Project(
    id = "scala-bad-api",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "scala-bad-api",
      organization := "org.kurochan",
      version := "0.1",
      scalaVersion := "2.11.8",
      libraryDependencies ++= Seq(
        "com.typesafe.akka" %% "akka-http-core"              % "2.4.2",
        "com.typesafe.akka" %% "akka-http-experimental"      % "2.4.2",
        "ch.qos.logback"    %  "logback-classic"             % "1.1.4",
        "com.typesafe.akka" %% "akka-slf4j"                  % "2.4.2",
        "org.kurochan"      %% "logback-stackdriver-logging" % "0.0.1"
      ),
      resolvers ++= Seq(
        "logback-stackdriver-logging" at "http://kurochan.github.io/logback-stackdriver-logging/"
      )
    )
  )
}
