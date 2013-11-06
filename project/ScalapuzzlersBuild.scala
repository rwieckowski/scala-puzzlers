import sbt._
import sbt.Keys._

object ScalapuzzlersBuild extends Build {

  lazy val scalapuzzlers = Project(
    id = "scala-puzzlers",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "scala-puzzlers",
      organization := "pl.rawie.puzzlers",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.2",
      libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % "1.9.2" % "test"
      )
      // add other settings here
    )
  )
}
