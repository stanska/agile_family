package model

import play.api.libs.json._

case class CreateTaskRequest(name: String)

object CreateTaskRequest {

  implicit val CreateTaskRequest = Json.format[CreateTaskRequest]

}