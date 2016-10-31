package bdd.steps

import com.csvreader.CsvReader

/**
  * Developed by:    cubanguy 
  * Date:            04.10.16
  * Project:         play-scala
  */
object CsvData extends CsvDataT {

  override var handlerReader: CsvReader = _
  override var pFilePath: String = _
}

