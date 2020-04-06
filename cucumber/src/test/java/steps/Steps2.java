/**
 * @author Solomon
 * This is the code to file "login.feature2" this will run the test twice , once for each user
 * step definition class
 * To import all the missing imports click on Ctrl + shift + o
 * New user created qatest 
 * Password qatest1
 */
package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps2 {
	
	private WebDriver driver;
	
	@Given("I am in the login page of the Bank Application")
	public void i_am_in_the_login_page_of_the_Para_Application() {
	    
		WebDriverManager.chromedriver().setup();							//Using WebDriverManager after adding to POM.xml
		driver = new ChromeDriver();
		driver.get("http://parabank.parasoft.com/parabank/index.htm");
	}

	@When("I enter the valid {string} and {string}")
	public void i_enter_the_valid_credentials(String username, String password) {
	   
		try {
			Thread.sleep(3000);
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//input[@class='button']")).click();
		} 
		catch (InterruptedException e) {
			System.out.println("Failed in Login");
			e.printStackTrace();
		}
	}

	@Then("I should be taken to the Overview page screen")
	public void i_should_be_taken_to_the_Overview_page_screen() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		try {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='rightPanel']/div/div/h1")));
			driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/h1")).isDisplayed();
			driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
			driver.close();																	//Closing the browser
			driver.quit();
		} 
		catch (InterruptedException e) {
			System.out.println("Failed in validation");
			e.printStackTrace();
			driver.close();																	//Closing the browser
			driver.quit();
		}
	}
}
