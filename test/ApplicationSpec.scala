import java.io._
import java.util.zip.{ZipEntry, ZipInputStream}

import au.com.bytecode.opencsv.CSVWriter
import bb.steps.{CsvData, Validate}
import com.csvreader.CsvReader
import org.junit.runner._
import org.specs2.mutable._
import org.specs2.runner._
import play.api.test.Helpers._
import play.api.test._

import scala.collection.JavaConversions._
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Add your spec here.
  * You can mock out a whole application including requests, plugins etc.
  * For more information, consult the wiki.
  */

@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "Application" should {

    "send 404 on a bad request" in new WithApplication {
      route(FakeRequest(GET, "/boum")) must beSome.which(status(_) == NOT_FOUND)
    }

    "render the index page" in new WithApplication {
      val home = route(FakeRequest(GET, "/")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain("Welcome to Dev Apps")
    }

//    def getRowData(x: mutable.LinkedHashMap[String, String]): (ListBuffer[String]) = {
//      val dataList = ListBuffer.empty[String]
//      for (k <- x.keys)
//        dataList += x.get(k).getOrElse().asInstanceOf[String]
//      dataList
//    }
    def getFileWithExtension(fileExt: String): String = {
      val fileInZip = getZippedListings("/home/cubanguy/IdeaProjects/ScalaActivateProject/resources/NewBG.zip").
        find(x => x.contains(fileExt)).getOrElse().asInstanceOf[String]

      readFile(fileInZip, "/home/cubanguy/IdeaProjects/ScalaActivateProject/resources/NewBG.zip")

    }

    "download link for csv" in new WithApplication() {

      val f = getFileWithExtension("csv")

      println(f)


      for (fileNames <- getZippedListings("/home/cubanguy/IdeaProjects/ScalaActivateProject/resources/NewBG.zip")) {
        if (fileNames.contains(".csv")) {
          val newFile = new File("/home/cubanguy/IdeaProjects/ScalaActivateProject/resources/zip_files" +
            File.separator + fileNames)
          //          println("---- Found CSv File to read at " + newFile.getAbsolutePath)
          println("checking files " + readFile("report_file_to_mimic_home_office_csv.csv",
            path = "/home/cubanguy/IdeaProjects/ScalaActivateProject/resources/NewBG.zip"))
        }
      }

//      val url = "http://localhost:9000/assets/uploaded_files/report_file_to_mimic_home_office_csv.csv"
//      val csvFile = Source.fromURL(url).bufferedReader()

      CsvData.pFilePath="/home/cubanguy/IdeaProjects/ScalaActivateProject/resources/NewBG.zip"
      if(CsvData.isFilesUnzipped)
        CsvData.pFilePath="/home/cubanguy/IdeaProjects/ScalaActivateProject/resources/report_file_to_mimic_home_office_csv.csv"
      val csvReader = new CsvReader(CsvData.getFilePath)
      CsvData.handlerReader = csvReader


      var fieldArray = new ListBuffer[String]
      var bodyArray = new ListBuffer[String]

      for (h <- CsvData.getCsvHeaderSchema)
        bodyArray += h

      bodyArray += "Validation"
      CsvData.setWriteCsvSchemaHeader(bodyArray.toArray)

//      val validation:Validate = new Validate(CsvData)

      for (x <- CsvData.getCsvRecordSchema.values) {
        val (dataList: ListBuffer[String]) = CsvData.getRowData(x)

        x.get("CountryOfOrigin").getOrElse() match {
          case "UK" => dataList += "Brexit"
          case "Germany" => dataList += "DEXIT"
          case "Spain" => dataList += "SEXIT"
          case _ => dataList += "XXX"
        }
        CsvData.setWriteCsvSchemaBody(dataList.toArray)
      }

    }


  }

  def readFile(fileName: String, path: String): String = {
    getZippedListings1(path).find(x => x.getName == fileName) match {
      case Some(_) => "%s%s%s".format(new File(path).getParent, File.separator, fileName)
      case None => String.valueOf(None)
    }
  }

  def isFileExtensionPresent(Extension: String, spath: String): Boolean = {

    getZippedListings1(filePath = spath) match {
      case getZippedListings1 if Extension.contains("csv") => true
      case getZippedListings1 if Extension.contains("pdf") => true
      case _ => false
    }
  }

  def getZippedListings(filePath: String): List[String] = {

    var bufferList = ListBuffer[String]()
    val zis: ZipInputStream = new ZipInputStream(new
        FileInputStream(filePath))

    var ze: ZipEntry = zis.getNextEntry
    //    val prefixes = Iterator.iterate(zis.getNextEntry.getName)(_.lines.next()).toList
    //    println("lines ", prefixes)
    while (ze != null) {
      val fileName = ze.getName
      ze = zis.getNextEntry

      bufferList += fileName
    }
    val fileList = bufferList.toList
    zis.closeEntry()
    zis.close()

    fileList
  }

  def getZippedListings1(filePath: String): List[File] = {

    var bufferList = ListBuffer[File]()
    val zis: ZipInputStream = new ZipInputStream(new
        FileInputStream(filePath))

    var ze: ZipEntry = zis.getNextEntry
    //    val prefixes = Iterator.iterate(zis.getNextEntry.getName)(_.lines.next()).toList
    //    println("lines ", prefixes)
    while (ze != null) {
      val fileName = ze.getName
      ze = zis.getNextEntry

      bufferList += new File(fileName)
    }
    val fileList = bufferList.toList
    zis.closeEntry()
    zis.close()

    fileList
  }

  def openFileModifyUpload(fileName: String): String = {
    val newFile = "new"
    val out = new BufferedWriter(new FileWriter(fileName))
    val writer = new CSVWriter(out)
    val headers = Array("name", "age", "dept")
    val data = Array("John", "23", "computerscience")
    val listOfRecords = List(headers, data)
    writer.writeAll(listOfRecords)
    out.close()
    newFile
  }

  def extractFileLoad(zipFileName: String): Boolean = {
    val INPUT_ZIP_FILE: String = "/home/cubanguy/IdeaProjects/ScalaActivateProject/resources/NewBG.zip"
    val OUTPUT_FOLDER: String = "/home/cubanguy/IdeaProjects/ScalaActivateProject/resources/zip_files"

    val outDir = new File(new File(INPUT_ZIP_FILE).getAbsoluteFile.getAbsolutePath).getParent

    val buffer = new Array[Byte](1024)

    try {
      val zis: ZipInputStream = new ZipInputStream(new FileInputStream(INPUT_ZIP_FILE))
      var ze: ZipEntry = zis.getNextEntry
      while (ze != null) {
        val fileName = ze.getName
        val newFile = new File(OUTPUT_FOLDER + File.separator + fileName)
        println("file unzip : " + newFile.getAbsoluteFile)
        //create folders
        //      new File(newFile.getParent()).mkdirs();
        val fos = new FileOutputStream(newFile)
        var len: Int = zis.read(buffer)
        while (len > 0) {
          fos.write(buffer, 0, len)
          len = zis.read(buffer)
        }
        fos.close()
        ze = zis.getNextEntry
      }
      zis.closeEntry()
      zis.close()
      true
    }
    catch {
      case e: Exception => false
    }
  }


}
