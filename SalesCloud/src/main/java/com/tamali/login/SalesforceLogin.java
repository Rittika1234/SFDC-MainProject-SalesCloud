package com.tamali.login;

//import com.tamali.base.Wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesforceLogin{
	
	WebDriver driver;
	
	 @FindBy(id ="username" )
	 static WebElement usernameInput;  // Find the element with the id "username" and store it in a WebElement variable called Username
	 
	 @FindBy(id ="password" ) 
	 static WebElement passwordInput; // Find the element with the id "password" and store it in a WebElement variable called Password
	 
	 @FindBy(xpath ="//*[@id=\"Login\"]" ) 
	 static WebElement loginbutton;   //Login Button Element
	 
	 //Constructor
	 public SalesforceLogin(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this); // Initialize the WebElement variables in this class using the driver
	}
	 
	 public void login() {
            
            usernameInput.sendKeys("abc@company.sandbox");  // Enter the username into the Username field
            passwordInput.sendKeys("abc@1234");  // Enter the password into the Password field
	        loginbutton.click();  // Click on the Login button
	 }
}
