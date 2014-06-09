name := "scala-spring-data"

version := "1.0"

organization := "my org"

scalaVersion := "2.10.4"

//resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

lazy val springVersion = "3.2.1.RELEASE"

libraryDependencies := Seq(
  "org.springframework.data" % "spring-data-jpa" % "1.3.0.RELEASE",
  "org.springframework" % "spring-orm" % springVersion,
  "org.springframework" % "spring-jdbc" % springVersion,
  "org.springframework" % "spring-tx" % springVersion,
  "org.springframework" % "spring-core" % springVersion,
  "org.springframework" % "spring-context" % springVersion,
  "org.hibernate.javax.persistence" % "hibernate-jpa-2.0-api" % "1.0.1.Final",
  "org.hibernate" % "hibernate-entitymanager" % "4.1.9.Final",
  "org.hsqldb" % "hsqldb" % "2.2.9",
  "org.specs2" %% "specs2" % "2.3.12" % "test",
  "org.scala-lang" % "scala-compiler" % scalaVersion.value
)