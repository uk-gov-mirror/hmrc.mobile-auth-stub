import play.core.PlayVersion
import play.sbt.PlayImport._
import sbt._

object AppDependencies {

  private val play25Bootstrap = "3.7.0"
  private val hmrcTestVersion = "3.1.0"
  private val scalaTestVersion = "3.0.4"
  private val pegdownVersion = "1.6.0"

  val compile: Seq[ModuleID] = Seq(
    ws,
    "uk.gov.hmrc" %% "bootstrap-play-25" % play25Bootstrap
  )

  def test(scope: String): Seq[ModuleID] = Seq(
    "uk.gov.hmrc" %% "hmrctest" % hmrcTestVersion % scope,
    "org.pegdown" % "pegdown" % pegdownVersion % scope,
    "com.typesafe.play" %% "play-test" % PlayVersion.current % scope,
    "org.scalatest" %% "scalatest" % scalaTestVersion % scope
  )

  def apply(): Seq[ModuleID] = compile ++ test("test")

}
