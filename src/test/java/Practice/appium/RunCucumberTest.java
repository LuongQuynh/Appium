package Practice.appium;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},glue="DenefitionSteps",features = "src\\test\\resources\\Practice\\appium\\LookUpNewWord.feature" , monochrome=true)
public class RunCucumberTest {
}