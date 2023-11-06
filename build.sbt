ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "so77398294"
  )
  .dependsOn(macros)

lazy val macros = (project in file("macros"))
  .settings(
    libraryDependencies ++= Seq(
      scalaOrganization.value % "scala-reflect" % scalaVersion.value,
    ),
  )
