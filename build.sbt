import Dependencies._

ThisBuild / scalaVersion := "2.13.3"
ThisBuild / version := "1.0.0-SNAPSHOT"
ThisBuild / organization := "com.gomezgimenez"

lazy val `slapsy` = (project in file("."))
  .settings(
    mainClass in (Compile, run) := Some("Main"),
    mainClass in assembly := Some("Main"),
    libraryDependencies ++= List(
      json4s,
      scalaTest % Test,
      webcamCapture,
      javacv
    ) ++ javaCvLibs,
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
      case _                                   => MergeStrategy.first
    }
  )
