import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List( //Zeile 5
      organization := "de.bookstore",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Scala_JaxEnter_Tutorial",
    logBuffered in Test := false,
    libraryDependencies ++= testDeps
  )
