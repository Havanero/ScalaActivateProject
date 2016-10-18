package controllers

import java.io.File

import models.Item
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._
import play.api.Play.current
import play.api.i18n.Messages.Implicits._
import views.html.helper.form
import java.io.File
import java.lang.Exception

class Application extends Controller {

  def index = Action {


    Ok(views.html.index(taskForm, Item.item_id(0)))
    //    Redirect(routes.Application.items)
    //    Ok("Hello World")

  }

  def items = Action {
    Ok(views.html.items(Item.all()))
  }

  def view_item(id: Int) = Action {
    Ok(views.html.view_item_details(Item.item_id(id)))
    //    Redirect(routes.Application.items)

  }

  def searchID(id: Int) = TODO

  def searchTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(taskForm, Item.item_id(0))),
      ItemId => {
        //        Item.search(ItemId)
        print("searching ----" + ItemId)
        Ok(views.html.index(taskForm, Item.item_id(ItemId.toInt)))
        //        Ok("Hello")
        //       Redirect(routes.Application.results(ItemId))
        //        Redirect(routes.Application.submit)
      }
    )
  }

  val taskForm = Form(
    "ItemId" -> nonEmptyText
  )

  def submit = Action { implicit request =>

      var ItemId = taskForm.bindFromRequest.get
      if (ItemId.isEmpty) {
        ItemId = "0"
      }
    Ok(views.html.index(taskForm, Item.item_id(ItemId.toInt)))


  }

  def uploadForm = Action {
    Ok(views.html.uploadForm(Item.getListOfFiles("public/uploaded_files/")))
  }

  def upload = Action(parse.multipartFormData) { request =>
    request.body.file("picture").map { picture =>

      val filename = picture.filename
      val contentType = picture.contentType

      picture.ref.moveTo(new File(s"public/uploaded_files/$filename"))

      Ok("File uploaded")
      Redirect(routes.Application.uploadForm())
    }.getOrElse {
      Redirect(routes.Application.uploadForm()).flashing(
        "error" -> "Missing file")
    }
  }

}
