package srrs.test.csv

import java.io.FileWriter

import au.com.bytecode.opencsv.CSVWriter
import bdd.steps.ZipFilesUtils
import com.csvreader.CsvReader

/**
  * Developed by:    cubanguy 
  * Date:            11.10.16
  * Project:         play-scala
  */
trait CSVFile extends ZipFilesUtils {
  type T
  var headerData: Array[T]
  var bodyData: Array[T]
  var handlerReader: CsvReader

  def addHeaderRecord(headerData: Array[T]): T

  def addBodyRecord(bodyData: Array[T]): T

  def writeCSVBody(bodyData: Array[String]) = {
    val writer = new CSVWriter(new FileWriter(getFilePath, true), CSVWriter.DEFAULT_SEPARATOR,
      CSVWriter.NO_QUOTE_CHARACTER)
    val entries = bodyData.map(_.lines.next())
    writer.writeNext(entries)
    writer.close()
  }

  def writeCSVHeader(fields: Array[String]) = {
    val writer = new CSVWriter(new FileWriter(getFilePath), CSVWriter.DEFAULT_SEPARATOR,
      CSVWriter.NO_QUOTE_CHARACTER)
    val entries = fields.map(x => x.toString)
    writer.writeNext(entries)
    writer.close()
  }

}
