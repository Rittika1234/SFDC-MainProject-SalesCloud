package com.tamali.base;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
   // Declaring WebDriver as a static variable so that it can be accessed throughout the class
   public static WebDriver driver;
  
	//Method to define explicit wait 
	
	public void explicit(int sec, WebElement element ,WebDriver driver) {
		    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(sec));
		    waits.until(ExpectedConditions.visibilityOf(element));
	}

}

