package srrs.test.csv

import com.csvreader.CsvReader

/**
  * Developed by:    cubanguy 
  * Date:            11.10.16
  * Project:         play-scala
  */
class CSVFileImpl extends CSVFile {

  override type T = CSV
  override var headerData: Array[T] = _
  override var bodyData: Array[T] = _


  def addHeaderRecord(dataArray: Array[T]): T = {
    headerData = dataArray
    new T().addCsvData(headerData)

  }

  def addBodyRecord(dataArray: Array[T]): T = {
    bodyData = dataArray
    new T().addCsvData(bodyData)
  }

  override var handlerReader: CsvReader = _
  override var pFilePath: String = _
}
