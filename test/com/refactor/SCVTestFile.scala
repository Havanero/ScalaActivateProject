package com.refactor

import com.csvreader.CsvReader
import srrs.test.csv.{CSV, CSVFileImpl}

import scala.collection.mutable.ListBuffer

/**
  * Developed by:    cubanguy 
  * Date:            12.10.16
  * Project:         play-scala
  */
object SCVTestFile extends CSVFileImpl {

  def main(args: Array[String]): Unit = {

    var saveCsvBody = ListBuffer.empty[ScuUploadCSV]
    var saveCsvHeader = ListBuffer.empty[ScuUploadCSV]

    pFilePath = "/home/cubanguy/IdeaProjects/ScalaActivateProject/resources/NewBG.zip"
    if (isFilesUnzipped) {
      handlerReader = new CsvReader(getFullFilePathForExtension("csv"))
      handlerReader.readHeaders()

      saveCsvHeader += ScuUploadCSV(name = "Name", address = "Address", sex = "Sex", dob = "DOB",
        countryOrigin = "CountryOfOrigin", validated = "Validated")
      addHeaderRecord(saveCsvHeader.toArray)

      for (x <- handlerReader.getHeaders) {
        while (handlerReader.readRecord()) {
          saveCsvBody += ScuUploadCSV(name = handlerReader.get("Name"), address = handlerReader.get("Address"),
            dob = handlerReader.get("DOB"), sex = handlerReader.get("Sex"),
            countryOrigin = handlerReader.get("CountryOfOrigin"), validated =
              validated_fields(name = handlerReader.get("Name"),
                countryOrigin = handlerReader.get("CountryOfOrigin"), dob = handlerReader.get("DOB"),
                "Matt", "Spain", "20-10-76"))
        }
      }
      addBodyRecord(saveCsvBody.toArray)
    }
    pFilePath = getFullFilePathForExtension("csv")
    for (x <- headerData) {
      val hf = Array(x.asInstanceOf[ScuUploadCSV].name, x.asInstanceOf[ScuUploadCSV].address,
        x.asInstanceOf[ScuUploadCSV].dob, x.asInstanceOf[ScuUploadCSV].sex, x.asInstanceOf[ScuUploadCSV].countryOrigin,
        x.asInstanceOf[ScuUploadCSV].validated)
      writeCSVHeader(hf)
    }
    for (y <- bodyData) {
      val bf = Array(y.asInstanceOf[ScuUploadCSV].name, y.asInstanceOf[ScuUploadCSV].address,
        y.asInstanceOf[ScuUploadCSV].dob, y.asInstanceOf[ScuUploadCSV].sex, y.asInstanceOf[ScuUploadCSV].countryOrigin,
        y.asInstanceOf[ScuUploadCSV].validated)
      println(bf.toList)
      writeCSVBody(bf)
    }

  }

  def validated_fields(name: String, countryOrigin: String, dob: String, withN:String, withC:String, withDob:String): String = {
    (name, countryOrigin, dob) match {
      case (`withN`, `withC`, `withDob`) => "OK"
      case null => "No"
    }
  }


//  def validate_fields(name: String, countryOrigin: String, dob: String, args: Array[String]): String = {
//    (name, countryOrigin, dob) match {
//      case (args.update() => "XX"
//      case _ => "No"
//    }
//  }

  def checkFields(v1: String, v2: String, v3: String, checkValues: Seq[(String, String, String)]): String = {
    checkValues.filter(cv => cv._1 == v1 && cv._2 == v2 && cv._3 == v3).map(_.==(true))
    "ok"
  }
}

case class ScuUploadCSV(name: String, address: String, sex: String, dob: String, countryOrigin: String,
                        validated: String) extends CSV {

}