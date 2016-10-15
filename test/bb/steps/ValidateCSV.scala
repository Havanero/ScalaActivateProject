package bb.steps

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebElement}
import org.scalatest.{FunSpec, ShouldMatchers}

import scala.collection.JavaConverters._
import scala.collection.mutable


/**
  * Developed by:    cubanguy 
  * Date:            22.09.16
  * Project:         play-scala
  */
class ValidateCSV extends FunSpec with ScalaDsl with EN with ShouldMatchers {

//  describe("As a case worker I would like to make sure that new cases are reflected inside CSV") {
//    it("Must do something") {
//      System.setProperty("webdriver.chrome.driver", "/home/cubanguy/Downloads/chromedriver")
//      val drive = new ChromeDriver()
//      drive.get("http://localhost:9000/uploadForm")
//      val elems: mutable.Buffer[WebElement] = drive.findElements(By.tagName("a")).asScala
//      println(elems.size)
//
//      for (links: WebElement <- elems) {
//        println("All links on the page " + links.getText)
//      }
//
//      val elem = drive.findElement(By.tagName("body")).getText
//      printf("we are at " + elem.toUpperCase)
//      drive.quit()
//
//    }
//    it("Must be ok") {}
//  }
//

  Given("""^That I have a created a new case$""") {
    () =>
      //// Write code here that turns the phrase above into concrete actions
      println("hello")
  }


  When("""^I download the csv$""") {
    () =>
    //// Write code here that turns the phrase above into concrete actions
          System.setProperty("webdriver.chrome.driver", "/home/cubanguy/Downloads/chromedriver")
          val drive = new ChromeDriver()
          drive.get("http://localhost:9000/uploadForm")
          val elems: mutable.Buffer[WebElement] = drive.findElements(By.tagName("a")).asScala
          println(elems.size)

          for (links: WebElement <- elems) {
            println("All links on the page " + links.getText)
          }

          val elem = drive.findElement(By.tagName("body")).getText
          printf("we are at " + elem.toUpperCase)
          drive.quit()


  }
  Then("^I would like to make sure Ahmed bala bala banak aba field match all the names on the case$") {
    // Write code here that turns the phrase above into concrete actions
  }

}
