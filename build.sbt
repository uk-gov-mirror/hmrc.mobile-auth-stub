import play.sbt.PlayImport.PlayKeys.playDefaultPort
import uk.gov.hmrc.SbtArtifactory
import uk.gov.hmrc.sbtdistributables.SbtDistributablesPlugin.publishingSettings
import uk.gov.hmrc.versioning.SbtGitVersioning

val appName: String = "mobile-auth-stub"

lazy val microservice = Project(appName, file("."))
  .enablePlugins(Seq(play.sbt.PlayScala, SbtAutoBuildPlugin, SbtGitVersioning, SbtDistributablesPlugin, SbtArtifactory): _*)
  .settings(publishingSettings: _*)
  .settings(routesGenerator := StaticRoutesGenerator)
  .settings(
    majorVersion := 0,
    scalaVersion := "2.11.12",
    playDefaultPort := 9025,
    libraryDependencies ++= AppDependencies(),
    evictionWarningOptions in update := EvictionWarningOptions.default.withWarnScalaVersionEviction(false),
    resolvers += Resolver.jcenterRepo
  )
