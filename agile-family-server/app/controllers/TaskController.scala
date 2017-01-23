package controllers

import model.CreateTaskRequest
import model.Task
import play.api.mvc._
import play.api.libs.json.Json
import play.api.libs.json.JsError
import javax.inject.Inject

import play.api.libs.ws._;

class TaskController  @Inject() (ws: WSClient) extends Controller {

  def createTask = Action (BodyParsers.parse.json)  { request =>
      val createTaskRequestValidationResult = request.body.validate[CreateTaskRequest]
    createTaskRequestValidationResult.fold(
      errors => {
        BadRequest(Json.obj("status" -> "Bad Request", "message" -> JsError.toJson(errors)))
      },
      createTaskRequest => {
        val messageId = java.util.UUID.randomUUID.toString
        val task = new Task(messageId, createTaskRequest.name)
        val request: WSRequest = ws.url("https://fcm.googleapis.com/fcm/send")
        val res =  request.withHeaders("Authorization" -> "key=AAAADS4o7cE:APA91bEVhX2B-sUa8eyWfzYzi7m5RBX7eKc1_e4HKO30gfguvfj-Wzj_a85CTSg_qqYluIAnQVJO2KOcs1OQj_BHD085MknDYYDBu1dg53QAq9AWoQT9e-lmqe8FYeq0Yii7H15rPzN2",
                              "Content-Type" -> "application/json",
                              "project_id" -> "56609009089")
            .post("{\"condition\": \"'gankovi' in topics\",\n  \"data\": {\n    \"message\": \"" + createTaskRequest.name + "\", }}")

        println(res);
        Ok(Json.toJson(task))
      })

  }
}
