import play.core.PlayVersion
import sbt._

object AppDependencies {

  private val play26Bootstrap          = "0.34.0"
  private val hmrcTestVersion          = "3.4.0-play-26"
  private val scalaTestVersion         = "3.0.5"
  private val scalaTestPlusPlayVersion = "3.1.2"
  private val pegdownVersion           = "1.6.0"
  private val scalaMockVersion         = "4.1.0"

  val compile: Seq[ModuleID] = Seq(
    "uk.gov.hmrc" %% "bootstrap-play-26" % play26Bootstrap
  )

  def test(scope: String): Seq[ModuleID] = {
    Seq(
      "uk.gov.hmrc" %% "hmrctest" % hmrcTestVersion % scope,
      "com.typesafe.play" %% "play-test" % PlayVersion.current % scope,
      "org.scalatest" %% "scalatest" % scalaTestVersion % scope
    )
  }

  def apply(): Seq[ModuleID] = compile ++ test("test")
}
