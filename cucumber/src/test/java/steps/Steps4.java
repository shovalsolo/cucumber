/**
 * @author Solomon
 * This is the code to file "login.feature4" this is an Example for how to use Hooks
 * step definition class
 * To import all the missing imports click on Ctrl + shift + o
 * New user created qatest 
 * Password qatest1
 */
package steps;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps4 {
	
	private WebDriver driver;
	
	@Before()
	public void setup() {
		WebDriverManager.chromedriver().setup();							//Using WebDriverManager after adding to POM.xml
		driver = new ChromeDriver();
	}
	
	@Given("I am in the login page of the Bank Application Hooks")
	public void i_am_in_the_login_page_of_the_Para_Application_Hooks() {
	    
		driver.get("http://parabank.parasoft.com/parabank/index.htm");
	}

	@When("I enter the valid credentials Hooks")
	public void i_enter_the_valid_credentials_Hooks(DataTable table) {
		
		List < String> loginForm = table.asList();
	   
		try {
			Thread.sleep(3000);
			driver.findElement(By.name("username")).sendKeys(loginForm.get(0));
			driver.findElement(By.name("password")).sendKeys(loginForm.get(1));
			driver.findElement(By.xpath("//input[@class='button']")).click();
		} 
		catch (InterruptedException e) {
			System.out.println("Failed in Login");
			e.printStackTrace();
		}
	}

	@Then("I should be taken to the Overview page screen Hooks")
	public void i_should_be_taken_to_the_Overview_page_screen_Hooks() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		try {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='rightPanel']/div/div/h1")));
			driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/h1")).isDisplayed();
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
