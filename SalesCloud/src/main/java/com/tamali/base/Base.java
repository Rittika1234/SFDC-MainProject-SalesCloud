package com.tamali.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base
{
	// Declaring WebDriver and URL as static variables so that they can be accessed throughout the class
	
	public static WebDriver driver;
	public static String url = "https://login.salesforce.com/?locale=in";
	public static Properties prop;
	
	// Method to set up the WebDriver instance based on the browser specified in the configuration file
	
	public WebDriver driverSetup()
	{
		prop=new Properties();
		
		try 
		{
			// Loading the configuration file
			prop.load(new FileInputStream("src/main/java/config/config.properties"));
		}	
		 catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		// Checking which browser is specified in the configuration file and creating the corresponding WebDriver instance
		if(prop.getProperty("browserName").matches("edge"))
		{
			
			 driver=new EdgeDriver();
		}
		
		if(prop.getProperty("browserName").matches("chrome"))
		{

			 driver=new ChromeDriver();
		}
		
		if(prop.getProperty("browserName").matches("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		
		// Maximizing the window and setting up timeouts
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Navigating to the URL specified in the static variable
	    driver.get(url);
	    
		return driver;
		
	}
	
	// Method to quit the browser
	
	public void closeBrowser()
	{
		driver.quit();
	}

}
