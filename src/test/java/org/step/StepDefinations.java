package org.step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinations {
	public static WebDriver driver;
	
	@Given("User should be navigate to LoginPage")
	public void userShouldBeNavigateToLoginPage() {
		try {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://adactinhotelapp.com/");
			driver.manage().window().maximize();
			System.out.println("User Successfully Navigate to LoginPage");
		} catch (Exception e) {
			System.out.println("User Failed to enter the LoginPage");
		}
		   
	}
	
	@When("User enter username {string} and password {string}")
	public void userEnterUsernameAndPassword(String username, String password) {
		try {
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
               System.out.println("User successfully enters Credentials");
		} catch (Exception e) {
			System.out.println("User Failed to enters Credentials");
		}
		
	    
	}
	@And("User click the login button")
	public void userClickTheLoginButton() {
		try {
			driver.findElement(By.xpath("//input[@class='login_button']")).click();
			System.out.println("User Successfully clicked login button");
			
		} catch (Exception e) {
			System.out.println("User Failed to click login button");
			
		}
		
	   
	}
	
	@Then("User should validate the message {string}")
	public void userShouldValidateTheMessage(String message) {
		
		try {
			String Homepagetitleandlogintitle = driver.getTitle();
			System.out.println(Homepagetitleandlogintitle);
			
			switch(message.trim()) {
			
			case "Welcome to Adactin Group of Hotels":
				String Homepagetext = driver.findElement(By.xpath("//td[contains(text(),'Welcome to Adactin')]")).getText().trim();
				System.out.println("HomePage message text is :" + " " + Homepagetext);
				
				if(Homepagetext.equalsIgnoreCase(message)) {
					System.out.println("Homepage message successfully verified");
				}else {
					System.out.println("Homepage message failed to verify");
				}

				break;
				
			case "Invalid Login details or Your Password might have expired. Click here to reset your password":
				String invalidtxt = driver.findElement(By.xpath("//div[@class='auth_error']")).getText().trim();
				System.out.println("Loginpage error text is :" + " "+ invalidtxt );
				
				if(invalidtxt.equalsIgnoreCase(message)) {
					System.out.println("Loginpage error message successfully verified");
				}else {
					System.out.println("Loginpage error message failed to verified");
				}
				break;
				
			case "Enter Username":
				String userntxt = driver.findElement(By.xpath("//span[@id='username_span']")).getText().trim();
				System.out.println("Error Message: " +"  " + userntxt);
				
				if(userntxt.equalsIgnoreCase(message)) {
					System.out.println("Enter Username error message verified");
				}else {
					System.out.println("Enter Username error message not verified");
			          }
				break;
				
			case "Enter Password":
				String passntxt = driver.findElement(By.xpath("//span[@id='password_span']")).getText().trim();
				System.out.println("Error Message: " +"  " + passntxt);
				
				if(passntxt.equalsIgnoreCase(message)) {
					System.out.println("Enter Password error message verified");
				}else {
					System.out.println("Enter Password error message not verified");
				}
				
				break;
				
			default:
				System.out.println("Unkown");
			
			}
			
		} 
		catch (Exception e) {
			System.out.println("Exception");
	        }	
		
		
	}
}	