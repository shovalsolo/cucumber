/**
 * @author Solomon
 * This is the code to file "login.feature3" this will run the test twice , once for each user using DataTable to run
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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps3 {
	
	private WebDriver driver;
	
	@Given("I am in the login page of the Bank Application3")
	public void i_am_in_the_login_page_of_the_Para_Application3() {
	    
		WebDriverManager.chromedriver().setup();							//Using WebDriverManager after adding to POM.xml
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("I enter the valid credentials3")
	public void i_enter_the_valid_credentials3(DataTable table) {
		
		List < String> loginForm = table.asList();
	   
		try {
			Thread.sleep(3000);
			driver.findElement(By.name("txtUsername")).sendKeys(loginForm.get(0));
			driver.findElement(By.name("txtPassword")).sendKeys(loginForm.get(1));
			driver.findElement(By.xpath("//input[@class='button']")).click();
		} 
		catch (InterruptedException e) {
			System.out.println("Failed in Login");
			e.printStackTrace();
		}
	}

	@Then("I should be taken to the Overview page screen3")
	public void i_should_be_taken_to_the_Overview_page_screen3() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		try {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[contains(text(),'Dashboard')]")));
			driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).isDisplayed();
			driver.findElement(By.xpath("//a[@id='welcome']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
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
