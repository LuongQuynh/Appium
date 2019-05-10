package DenefitionSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CaculatorSteps {

	AndroidDriver driver;

	@Given("^I am staying caculator app$")
	public void i_am_staying_caculator_app() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("deviceName", "4200819acaa4b48f");
		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^I add (.+) and (.+)$")
	public void i_add_and(String number1, String number2) {
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_04")).click();
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_05")).click();
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();

	}

	@Then("^I have (.+)$")
	public void i_have(String result) {
		WebElement expectResult = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc"));
		Assert.assertEquals(result, expectResult.getText());
	}

}