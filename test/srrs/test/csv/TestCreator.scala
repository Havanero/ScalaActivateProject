package srrs.test.csv

import scala.collection.mutable.ListBuffer

/**
  * Developed by:    cubanguy 
  * Date:            11.10.16
  * Project:         play-scala
  */
object TestCreator extends CSV {


  def main(args: Array[String]): Unit = {
//    val cSVCreator = new CSVFileImpl()
//
//    var dataList = ListBuffer.empty[SCUCaseUploadCSV]
//    dataList += SCUCaseUploadCSV("name", "Address")
//    cSVCreator.headerData=dataList.toArray
//
//    for (x <- cSVCreator.headerData) {
//      println("header data " + x)
//    }
//
//    dataList.clear()
//    dataList += SCUCaseUploadCSV(name="Ccc",address = "london")
//    dataList += SCUCaseUploadCSV(name="Nelson",address = "Madrid")
//    dataList += SCUCaseUploadCSV(name="Hans",address = "Berlin")
//    dataList += SCUCaseUploadCSV(name="Nick",address = "Washington")
//
//    cSVCreator.bodyData = dataList.toArray
//    for (x <- cSVCreator.bodyData) {
//      println("body data " + x.asInstanceOf[SCUCaseUploadCSV].name)
//    }
//
 }

}

case class SCUCaseUploadCSV(name: String, address: String) extends CSV {

}