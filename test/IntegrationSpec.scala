import com.csvreader.CsvReader
import cucumber.api.scala.{EN, ScalaDsl}
import org.junit.Test
import org.junit.runner._
import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest._
import org.specs2.mutable._
import org.specs2.runner._
import play.api.libs.ws.WS
import play.api.test._

import scala.collection.mutable.ListBuffer
import scala.io.Source

//import com.csvreader.CsvReader;
//import scala.io.{BufferedSource, Source}

/**
  * add your integration spec here.
  * An integration test will fire up a whole play application in a real (or headless) browser
  */
//@RunWith(classOf[JUnitRunner])
class IntegrationSpec extends WithApplication with ScalaDsl with EN with ShouldMatchers {


//    describe("As a case worker I would like to make sure that new cases are reflected inside CSV") {
//      it("Must do something") {
//        System.setProperty("webdriver.chrome.driver", "/home/cubanguy/Downloads/chromedriver")
//        val drive = new ChromeDriver()
//        drive.get("http://localhost:9000/uploadForm")
//        val elems: scala.collection.mutable.Buffer[WebElement] = drive.findElements(By.tagName("a")).asScala
//        println(elems.size)
//
//        for (links: WebElement <- elems) {
//          println("All links on the page " + links.getText)
//        }
//
//        val elem = drive.findElement(By.tagName("body")).getText
//        printf("we are at " + elem.toUpperCase)
//        drive.quit()
//
//      }
//      it("Must be ok") {}
//    }
//

  //
//  "Application" should {
//
//    "Work from within a browser" in new WithBrowser {
//      browser.goTo("http://localhost:" + port)
//
//      browser.pageSource must contain("Welcome to Dev Apps")
//
//      val url = "http://localhost:9000/assets/uploaded_files/report_file_to_mimic_home_office_csv.csv"
//
//      val listPeeps = List(Persons("Fred", "London", "Male", "20-10-76", "UK"),
//        Persons("Antonio", "Berlin", "Male", "20-10-71", "Spain"), Persons("Maria", "Berlin", "Male", "20-10-76", "France"))
//
//      var fruits = new ListBuffer[String]()
//
//      // add one element at a time to the ListBuffer
//      fruits += "Apple"
//      fruits += "Banana"
//      fruits += "Orange"
//      val fruitsList = fruits.toList
//
//
//      //      listPeeps.apply(Seq(Persons("Fred","London","Male","20-10-76","UK")))
//
//      val r = callReader(url)
//      r.readHeaders()
//
//      var csvPersonsList = List[Persons]()
//      var csvPersonsBufferList = ListBuffer.empty[Persons]
//      val full_names = "sskskks"
//
//      while (r.readRecord()) {
//        csvPersonsBufferList += Persons(r.get("Name"), r.get("Address"), r.get("Sex"), r.get("DOB"),
//          r.get("CountryOfOrigin"))
//        println(r.get("Name"), r.get("Address"), r.get("Sex"), r.get("DOB"),
//          r.get("CountryOfOrigin"))
//      }
//
//
//      var pp = csvPersonsBufferList.filter(_.CountryOfOrigin == "Germany").slice(0, 1)
//      //      pp.getClass().getField("name")
//      //      val h = PersonUtils().getMethods[Persons]
//
//      r.close()
//
//
//      def callReader(url: String): CsvReader = {
//        val csvFile = Source.fromURL(url).bufferedReader()
//        new CsvReader(csvFile)
//      }
//
//
//    }
//  }

}
