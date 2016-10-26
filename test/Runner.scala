import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

/**
  * Developed by:    cubanguy 
  * Date:
1. Green chair      22.09.16
  * Project:         play-scala
  */

@CucumberOptions(features = Array("test/bdd/stories"),
  glue = Array("bb.steps"), plugin = Array("pretty", "html:bbreport"), tags = Array("@dev"))
@RunWith(classOf[Cucumber])
class Runner extends {

}
