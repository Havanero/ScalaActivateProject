import com.csvreader.CsvReader
import org.junit.runner._
import org.specs2.mutable._
import org.specs2.runner._
import play.api.test._

import scala.collection.mutable.ListBuffer
import scala.io.Source

//import com.csvreader.CsvReader;
//import scala.io.{BufferedSource, Source}

/**
  * add your integration spec here.
  * An integration test will fire up a whole play application in a real (or headless) browser
  */
@RunWith(classOf[JUnitRunner])
class IntegrationSpec extends Specification {


  "Application" should {

    "Work from within a browser" in new WithBrowser {
      browser.goTo("http://localhost:" + port)

      browser.pageSource must contain("Welcome to Dev Apps")

      val url = "http://localhost:9000/assets/uploaded_files/report_file_to_mimic_home_office_csv.csv"

      val listPeeps = List(Persons("Fred", "London", "Male", "20-10-76", "UK"),
        Persons("Antonio", "Berlin", "Male", "20-10-71", "Spain"), Persons("Maria", "Berlin", "Male", "20-10-76", "France"))

      var fruits = new ListBuffer[String]()

      // add one element at a time to the ListBuffer
      fruits += "Apple"
      fruits += "Banana"
      fruits += "Orange"
      val fruitsList = fruits.toList


      //      listPeeps.apply(Seq(Persons("Fred","London","Male","20-10-76","UK")))

      val r = callReader(url)
      r.readHeaders()

      var csvPersonsList = List[Persons]()
      var csvPersonsBufferList = ListBuffer.empty[Persons]
      val full_names = "sskskks"

      while (r.readRecord()) {
        csvPersonsBufferList += Persons(r.get("Name"), r.get("Address"), r.get("Sex"), r.get("DOB"),
          r.get("CountryOfOrigin"))
        println(r.get("Name"), r.get("Address"), r.get("Sex"), r.get("DOB"),
          r.get("CountryOfOrigin"))
      }


      var pp = csvPersonsBufferList.filter(_.CountryOfOrigin == "Germany").slice(0, 1)
      //      pp.getClass().getField("name")
      //      val h = PersonUtils().getMethods[Persons]

      r.close()


      def callReader(url: String): CsvReader = {
        val csvFile = Source.fromURL(url).bufferedReader()
        new CsvReader(csvFile)
      }


    }
  }
}
