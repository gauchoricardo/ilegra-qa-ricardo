package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/reports/cucumberTests.json", "html:target/reports/"},
        features = "src/test/resources/features",
        glue = {"steps"}      
)
public class RunCucumber extends RunBase{

    @AfterClass
    public static void stop(){
      getDriver().quit();
    }

}
