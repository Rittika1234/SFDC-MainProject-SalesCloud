package com.tamali.account;

//import java.io.IOException;
//import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import com.utilityFiles.CaptureScreenshot;

import com.tamali.base.Wait;

//This class is used to handle the account functionality of the application write in capital

public class AccountPage {
	 WebDriver driver;
	 public String filePath = null;
	
	 // Web elements related to accounts
	 
	 @FindBy(xpath = "//input[@id='acc2']") 
	 WebElement accountNameInput;
	 
	 @FindBy(xpath = "//input[@value = ' Save ']") 
	 WebElement saveButton;
	 
	 @FindBy(xpath = "//a[@title = 'Accounts Tab']" ) 
	 WebElement accountsTab;
	 
	 @FindBy(xpath = "//div[@class = 'topLeft']//a[@title = 'Close']" ) 
	 WebElement popUp;
	 
	 @FindBy(xpath = "//input[@title = 'New']")
	 WebElement newAccountButton;
	 
	 By accountField = By.id("acc2");
	 
	 @FindBy(xpath ="//div[@class='errorMsg']")
     WebElement accountErrorMessage;
	 
	 // Web elements related to contacts 
	 
	 @FindBy(xpath = "//input[@value = 'New Contact']")
	 WebElement newContactButton;
	 
	 @FindBy(xpath = "//input[@value = ' Save ']")
	 WebElement saveContactButton;
	 
	 @FindBy(xpath = "//div[@class = 'errorMsg']") 
	 WebElement contactErrorMessage;
	 
	 @FindBy(xpath = "//input[@id = 'name_lastcon2']") 
	 WebElement contactLastNameInput;
    
	// Constructor to initialize the driver and web elements
	 
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
   // Method to check if account error message is shown
    
    public void checkAccountError() {
    	
    	Wait wait = new Wait();
		
    	accountsTab.click();   // Click on the Accounts link
        
    	wait.explicit(30,popUp,driver);
        popUp.click();
        
        wait.explicit(30,newAccountButton,driver);
        
       // Create a new account with mandatory fields missing 
       newAccountButton.click();  
    	
       wait.explicit(30,saveButton,driver);
        
       saveButton.click();
       
       // Wait for the error message to be displayed and capture a screenshot of the error message
       wait.explicit(20, accountErrorMessage, driver);
       String ErrorMsg = accountErrorMessage.getText();
       
       System.out.println("Error message showing for not giving mandatory Fields in Account: "+ErrorMsg);
       
       filePath = System.getProperty("user.dir") + "/Screenshots/CheckAccountError.png";
       
    }
    
    //This method creates an account 
    
	public void createAccount() throws InterruptedException {
        
        // Enter the account name and click on the create account button
        accountNameInput.sendKeys("Riya");
        saveButton.click();
        
        System.out.println("Account Created Successfully");
        
    }
    
	// Method to check if Contact error message is shown
	
    public void checkContactsError() {
    	
    	Wait wait = new Wait();
    	
    	wait.explicit(30, newContactButton, driver);
    	newContactButton.click(); // Click on the New Contact button
    	 
    	saveContactButton.click(); // Click on the Save button
    	
    	String ErrorMsg = contactErrorMessage.getText(); // Get the error message text
    	
    	System.out.println("Error message showing for not giving mandatory Fields in Contact: "+ErrorMsg);
    	 
    	filePath = System.getProperty("user.dir") + "/Screenshots/CheckContactsError.png"; // Set the file path for the screenshot  
    	
    }
    
    //This method creates an Contact 
    
    public void createContact() {
    	
    	contactLastNameInput.sendKeys("Sarkars");  // Enter the last name of the contact
    	saveContactButton.click();  // Click the save button to create the contact
    	
    	System.out.println("Contact Created Successfully");
    }
    
}

