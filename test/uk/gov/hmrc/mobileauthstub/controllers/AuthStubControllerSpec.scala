/*
 * Copyright 2019 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.mobileauthstub.controllers

import play.api.http.Status
import play.api.mvc._
import play.api.test.FakeRequest
import play.api.test.Helpers._
import uk.gov.hmrc.mobileauthstub.views.html.sign_in_response
import uk.gov.hmrc.play.test.UnitSpec

import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits.global

class AuthStubControllerSpec extends UnitSpec {

  private val messagesActionBuilder: MessagesActionBuilder = new DefaultMessagesActionBuilderImpl(stubBodyParser[AnyContent](), stubMessagesApi())
  private val cc                                           = stubControllerComponents()

  private val mcc: MessagesControllerComponents = DefaultMessagesControllerComponents(
    messagesActionBuilder,
    DefaultActionBuilder(stubBodyParser[AnyContent]()),
    cc.parsers,
    cc.messagesApi,
    cc.langs,
    cc.fileMimeTypes,
    ExecutionContext.global
  )

  val controller = new AuthStubController(mcc)

  val fakeRequest: FakeRequest[AnyContent] = FakeRequest("GET", "/gg/sign-in")

  "GET /gg/sign-in" should {
    "return 200 and an html page with a success code" in {
      val result = controller.signIn()(fakeRequest)
      status(result) shouldBe Status.OK
      contentAsString(result) should include(sign_in_response().toString)
    }
  }

}
