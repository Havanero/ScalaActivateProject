package bb.steps

import java.io.{File, FileInputStream, FileOutputStream}
import java.util.zip.{ZipEntry, ZipInputStream}

import scala.collection.mutable.ListBuffer

/**
  * Developed by:    cubanguy 
  * Date:            10.10.16
  * Project:         play-scala
  */
trait ZipFilesUtils {

  var pFilePath: String

  def getFilePath: String = {
    pFilePath
  }

  def getZippedListings: List[String] = {
    val bufferList = ListBuffer[String]()
    val zis: ZipInputStream = new ZipInputStream(new
        FileInputStream(pFilePath))
    var ze: ZipEntry = zis.getNextEntry
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

  def isFileExtensionPresent(Extension: String): Boolean = {
    getZippedListings.find(x => x.contains(Extension)) match {
      case Some(_) => true
      case None => false
    }
  }

  def getPathFromFileName(fileName: String): String = {
    getZippedListings.find(x => x == fileName) match {
      case Some(_) => "%s%s%s".format(new File(pFilePath).getParent, File.separator, fileName)
      case None => String.valueOf(None)
    }
  }

  def isFilesUnzipped: Boolean = {
    val OUTPUT_FOLDER = new File(new File(pFilePath).getAbsoluteFile.getAbsolutePath).getParent
    val buffer = new Array[Byte](1024)
    try {
      val zis: ZipInputStream = new ZipInputStream(new FileInputStream(pFilePath))
      var ze: ZipEntry = zis.getNextEntry
      while (ze != null) {
        val fileName = ze.getName
        val newFile = new File(OUTPUT_FOLDER + File.separator + fileName)
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

  def getFullFilePathForExtension(fileExt: String): String = {
    val fileInZip = getZippedListings.
      find(x => x.contains(fileExt)).getOrElse().asInstanceOf[String]
    getPathFromFileName(fileInZip)
  }
}
