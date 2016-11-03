import sbt.Keys._

name := "play-scala"

version := "1.0-SNAPSHOT"
logBuffered in Test := false


lazy val commonSettings = Seq(
  scalaVersion := "2.11.8",
  organization := "com.example"
)
lazy val scalatest = "org.scalatest" %% "scalatest" % "3.0.0"

lazy val integration: Project = Project("integration-test", file("integration-test"))

lazy val root = (project in file(".")).enablePlugins(PlayScala)
      .configs(IntegrationTest).
      settings(commonSettings: _*).
      settings(Defaults.itSettings: _*).
      settings(
        libraryDependencies += scalatest % "it,test",
        libraryDependencies +=  "org.mockito" % "mockito-all" % "1.10.19" % "test",
        libraryDependencies += "info.cukes" % "cucumber-scala_2.10" % "1.1.8" % "test",
        libraryDependencies += "info.cukes" % "cucumber-junit" % "1.2.2" % "test",
        libraryDependencies += "info.cukes" % "cucumber-picocontainer" % "1.1.8" % "test",
        libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "2.42.2" % "test",
        libraryDependencies += "org.scalatestplus" % "play_2.11" % "1.4.0" % "test",
        libraryDependencies += "junit" % "junit" % "4.11" % "test",
        libraryDependencies += "net.sf.opencsv" % "opencsv" % "2.0"
      // other settings here
  )


scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "com.github.detro.ghostdriver" % "phantomjsdriver" % "1.0.4",
  "org.mockito" % "mockito-all" % "1.10.19" % "test",
  "info.cukes" % "cucumber-scala_2.10" % "1.1.8" % "test",
  "info.cukes" % "cucumber-junit" % "1.2.2" % "test",
  "info.cukes" % "cucumber-picocontainer" % "1.1.8" % "test",
  "org.seleniumhq.selenium" % "selenium-java" % "2.42.2" % "test",
  "org.scalatestplus" % "play_2.11" % "1.4.0" % "test",
  "junit" % "junit" % "4.11" % "test",
  "net.sf.opencsv" % "opencsv" % "2.0"
)

libraryDependencies ++= Seq(
  jdbc,
  "com.typesafe.play" %% "anorm" % "2.5.0"
)
resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1200-jdbc41"
libraryDependencies += "net.sourceforge.javacsv" % "javacsv" % "2.0"

//maintainer := "havanero"
//dockerExposedPorts in Docker := Seq(9000, 9443)

lazy val dockerSettings = Seq(
  //things the docker file generation depends on are listed here
  dockerfile in docker := {
    new sbtdocker.mutable.Dockerfile {
      copy(baseDirectory(_ / "config" / "dev.conf").value, file("app/dev.conf"))
    }
  }
)

javaOptions in Test += "-Dconfig.file=conf/dev.conf"
testOptions in IntegrationTest += Tests.Setup(() => println("setup"))

testOptions in IntegrationTest += Tests.Cleanup(() => println("cleanup"))

