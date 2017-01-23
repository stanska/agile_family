package model

import play.api.libs.json._

case class Task(id:String, name:String)

object Task {

  implicit val messageFormat = Json.format[Task]

}
