import play.core.PlayVersion
import sbt._

object AppDependencies {

  private val play26Bootstrap          = "3.0.0"
  private val hmrcTestVersion          = "3.9.0-play-26"
  private val scalaTestVersion         = "3.0.5"

  val compile: Seq[ModuleID] = Seq(
    "uk.gov.hmrc" %% "bootstrap-frontend-play-26" % play26Bootstrap
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
