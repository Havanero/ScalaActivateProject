package models

import java.io.File

import anorm.SqlParser._
import anorm._
import play.api.Play
import play.api.Play.current
import play.api.db._
import play.db.Database


/**
  * Developed by:    cubanguy 
  * Date:            13.09.16
  * Project:         ScalaActivateProject
  */

case class Item(id: Int, title: String, description: String, amount: Int, image: String)

object Item {

  val item = {
    get[Int]("id") ~
      get[String]("title") ~
      get[String]("description") ~
      get[Int]("amount") ~
      get[String]("image") map {
      case id ~ title ~ description ~ amount ~ image => Item(id, title, description, amount, image)
    }
  }



  def all(): List[Item] = DB.withConnection { implicit c =>
    SQL("select * from inventory_paintings").as(item *)
  }

  def item_id(id: Int) = DB.withConnection { implicit c =>
    SQL("select * from inventory_paintings where id={id}").on('id -> id).as(item.singleOpt)

  }

//  def anotherMethod(id: Option[Int]): Int={
//    id match {
//      case Some(x) => SQL("select * from inventory_paintings where id={id}").on('id -> id).as(item.singleOpt)
//      case None =>
//    }
//
//  }

  def search(ItemId: Int) {
    System.out.println(ItemId)
//    item_id(ItemId)
  }

  def getListOfFiles(dir: String): List[File] = {
    val d = new File(dir)

    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList

    } else {
      System.out.println(d.exists())
      List[File]()
    }
  }

}
