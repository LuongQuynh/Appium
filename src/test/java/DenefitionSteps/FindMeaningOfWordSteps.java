package DenefitionSteps;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;

public class FindMeaningOfWordSteps {
	
	AndroidDriver driver;
	 @Given("^I am staying TFlat app$")
	    public void i_am_staying_tflat_app() throws Throwable {
		  DesiredCapabilities cap = new DesiredCapabilities();
		  cap.setCapability("platformName", "ANDROID");
		  cap.setCapability("deviceName", "4200819acaa4b48f");
		  cap.setCapability("appPackage", "com.idmgroup.cdo.enar");
		  cap.setCapability("appActivity", "com.idmgroup.cdo.enar.MainActivity");
		  driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	    }

	    @When("^I type a word on search field$")
	    public void i_type_a_word_on_search_field() throws Throwable {
	    	driver.findElement(By.className("android.widget.EditText")).sendKeys("hello");
	    	WebDriverWait wait = new WebDriverWait(driver, 10);
	    	WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.view.View")));
	    	popUp.click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	driver.findElement(By.className("android.view.View")).click();
	    	
	    	
	    	
	    }

	    @Then("^I see vietnamese of word$")
	    public void i_see_vietnamese_of_word() throws Throwable {
	    	WebElement result = driver.findElement(By.className("android.view.View"));
	    	Assert.assertEquals("A1 said when you meet someone or start talking with someoneأهلاً وسَهْلاً / مَرْحَباًHello, Christina. How are you?",result.getText());
	    }

}
