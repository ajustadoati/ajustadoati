name := """simple-rest-scala"""

version := "1.0-SNAPSHOT"

lazy val root = project.in(file(".")).enablePlugins(PlayScala)

resolvers ++= Seq(
  "anormcypher" at "http://repo.anormcypher.org/",
  "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"
)


libraryDependencies ++= Seq(
  "org.anormcypher" %% "anormcypher" % "0.6.0"
)

libraryDependencies += filters


libraryDependencies ++= Seq(
  ws
)

