package bdd.steps

import java.io.FileWriter

import au.com.bytecode.opencsv.CSVWriter
import com.csvreader.CsvReader

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Developed by:    cubanguy 
  * Date:            04.10.16
  * Project:         play-scala
  */
trait CsvDataT extends ZipFilesUtils {

  def csvHeaderSchema: Array[String] = {
    handlerReader.readHeaders()
    handlerReader.getHeaders.map(_.lines.next())
  }

  var handlerReader: CsvReader

  def getCsvReader: CsvReader = {
    handlerReader
  }

  def getCsvHeaderSchema: Array[String] = {
    csvHeaderSchema
  }

  def getCsvRecordSchema: mutable.LinkedHashMap[Int, mutable.LinkedHashMap[String, String]] = {
    csvRecordSchema
  }

  def csvRecordSchema: mutable.LinkedHashMap[Int, mutable.LinkedHashMap[String, String]] = {
    val mapFields = mutable.LinkedHashMap[Int, mutable.LinkedHashMap[String, String]]()
    var i = 0
    while (handlerReader.readRecord()) {
      val hashHeader = mutable.LinkedHashMap[String, String]()
      for (c <- 0 until handlerReader.getHeaderCount) {
        hashHeader.put(handlerReader.getHeader(c), handlerReader.get(handlerReader.getHeader(c)))
      }
      mapFields.put(i, hashHeader)
      i = i + 1
    }
    mapFields
  }

  def setWriteCsvSchemaHeader(fields: Array[String]) = {
    val writer = new CSVWriter(new FileWriter(getFilePath), CSVWriter.DEFAULT_SEPARATOR,
      CSVWriter.NO_QUOTE_CHARACTER)
    val entries = fields.map(_.lines.next())
    writer.writeNext(entries)
    writer.close()
  }

  def setWriteCsvSchemaBody(data: Array[String]) = {
    val writer = new CSVWriter(new FileWriter(getFilePath, true), CSVWriter.DEFAULT_SEPARATOR,
      CSVWriter.NO_QUOTE_CHARACTER)
    val entries = data.map(_.lines.next())
    writer.writeNext(entries)
    writer.close()
  }

  def getRowData(x: mutable.LinkedHashMap[String, String]): (ListBuffer[String]) = {
    val dataList = ListBuffer.empty[String]
    for (k <- x.keys)
      dataList += x.get(k).getOrElse().asInstanceOf[String]
    dataList
  }

}
