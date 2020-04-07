/**
 * @author Solomon
 * This is the code to file "login.feature6" this will run the test twice , once for each user
 * step definition class
 * To import all the missing imports click on Ctrl + shift + o
 * New user created "qatest"
 * Password "qatest1"
 * This site is deleting the users every day so need to create before running this test
 */
package steps;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps6 extends BaseUtil{

	private BaseUtil baseUtil;	

	public Steps6(BaseUtil util) {
		this.baseUtil = util;
	}	

	private WebDriver driver;


	@Before()
	public void setup() {
		WebDriverManager.chromedriver().setup();							//Using WebDriverManager after adding to POM.xml
		driver = new ChromeDriver();
	}

	@Given("am in the login page of the Para Bank Application")
	public void am_in_the_login_page_of_the_Para_Bank_Application() {

		driver.get("http://parabank.parasoft.com/parabank/index.htm");
	}

	@When("enter valid {string} and {string} with {string}")
	public void enter_valid_credentials(String username, String password, String userFullName) {

		baseUtil.userFullName = userFullName;
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@class='button']")).click();

	}

	@Then("should be taken to the Overview page")
	public void should_be_taken_to_the_Overview_page() {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		try {
			Thread.sleep(5000);
			String actualUserFullName = driver.findElement(By.className("smallText")).getText().toString();
			System.out.println(baseUtil.userFullName.toString());
			assertTrue(actualUserFullName , actualUserFullName.contains(baseUtil.userFullName));
			driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
		} 
		catch (InterruptedException e) {
			System.out.println("Failed in validation");
			e.printStackTrace();
		}
	}

	@After()
	public void tearDown() {
		driver.close();																	//Closing the browser
		driver.quit();
	}
}
