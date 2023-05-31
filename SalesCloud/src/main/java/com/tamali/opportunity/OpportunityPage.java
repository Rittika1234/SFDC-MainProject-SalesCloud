package com.tamali.opportunity;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import com.tamali.base.Wait;
//import com.utilityFiles.CaptureScreenshot;

public class OpportunityPage {
	WebDriver driver;
	public String filePath = null;
	
	//Opportunities
	
	@FindBy(xpath = "//a[@title = 'Opportunities Tab']" )
    WebElement opportunities;
	
	@FindBy(xpath = "//input[@value = ' New ']") 
	WebElement newOpportunityButton;
	
	@FindBy (xpath="//input[@id = 'opp3']") 
	WebElement opportunityNameInput;
	
	@FindBy(xpath = "//input[@value = ' Save ']") 
	WebElement saveButton;
	
	@FindBy (xpath= "//input[@id = 'opp4']") 
	WebElement accountNameInput;
	
	@FindBy (xpath= "//input[@id = 'opp9']") 
	WebElement date;
	
	@FindBy (xpath= "//select[@id = 'opp11']")
	WebElement stageSelect;
	
	//Add Products
	
	@FindBy(xpath = "//input[@value = 'Add Product']") 
	WebElement addProductButton;
	
	@FindBy(xpath = "//*[@id=\"01u2w000006Ybg8\"]") 
	WebElement productCheckBox;
	
	@FindBy(xpath = "//input[@value= 'Select']") 
	WebElement selectButton;
	
	@FindBy(xpath = "(//input[@id='Quantity01u2w000006Ybg8'])[1]") 
	WebElement quantityInput;
	
	@FindBy(xpath = "//input[@value = ' Save ']")
	WebElement saveProductButton;
	
	//Add ContactRoles
	
	@FindBy(xpath = "(//input[@title='New Contact Roles'])[1]")  
	WebElement newContactRoles;
	
	@FindBy(xpath = "//select[@id = 'role0']") 
	WebElement roleSelect;
	
	@FindBy(xpath = "//input[@value = ' Save ']") 
	WebElement contactRolesSaveButton;
	
	
	//Add Task
	
	@FindBy(xpath = "(//h3[normalize-space()='Open Activities'])[1]") 
	WebElement openActivities;
	
	@FindBy(xpath = "//input[@value = 'New Task']") 
	WebElement newTask;
	
	@FindBy(xpath = "//input[@id = 'tsk5']") 
	WebElement taskSubjectInput;
	
	@FindBy(xpath = "//select[@id = 'tsk12']") 
	WebElement taskStatusSelect;
	
	@FindBy(xpath ="//*[@id=\"reminder_select_check\"]") 
	WebElement uncheckedReminderCheckbox;

	@FindBy(xpath ="//input[@value = ' Save ']") 
	WebElement taskSubmit;
	
	
	//Add Event
	
	@FindBy(xpath = "//input[@value = 'New Event']") 
	WebElement newEvent;
	
	@FindBy(xpath ="//input[@id = 'evt5']") 
	WebElement eventSubjectInput;
	
	@FindBy(id ="//*[@id=\"reminder_select_check\"]") 
	WebElement reminderCheckbox;
	
	@FindBy(xpath = "//input[@value = ' Save ']") 
	WebElement submitEvent;
	
	
	//Attach a file
	
	@FindBy(xpath ="//input[@title='Attach File']") 
	WebElement attachFileButton;
	
	@FindBy(xpath = "//input[@id='file']") 
	WebElement chooseFileInput;
	
	@FindBy(xpath = "//input[@id='Attach']") 
	WebElement attachButton;
	
	@FindBy(xpath ="//input[@value = ' Done ']") 
	WebElement done;
	
	@FindBy(xpath = "//input[@title = 'Edit']") 
	WebElement opportunityEditButton;
	
	//Closed Won 
	
	@FindBy(id = "errorDiv_ep") 
	WebElement errorText;
	
	@FindBy(xpath= "//td[@id='topButtonRow']//input[@title='Cancel']") 
	WebElement cancelButton;
	
	@FindBy(xpath ="//a[@title='Edit - Record 2 - Tamali Sarkar']") 
	WebElement taskEdit;
	
	@FindBy(xpath ="(//a[@title='Del - Record 1 - Tamali Sarkar'][normalize-space()='Del'])[1]") 
	WebElement deleteEvent;
	
	public OpportunityPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	}
	 
	 
	//This methods create an Opportunity 
	
	public void createOpportunity() throws InterruptedException, IOException {
		 
		 // Navigate to the Opportunities tab and click
		 opportunities.click();
		 
         // Click the "New" button to create a new opportunity
		 newOpportunityButton.click();
	     
		 // Enter the opportunity details
		 opportunityNameInput.sendKeys("600 Units");
		 accountNameInput.sendKeys("Riya");
		 date.sendKeys("22/04/2026");
		 
	     // Select the opportunity stage
	     Select Stages = new Select(stageSelect);
	     Stages.selectByVisibleText("Prospecting");
	     
	     // Click the "Save" button to create the opportunity
	     saveButton.click();
	     
	     System.out.println("Opportunity successfully Created");
	      
	 }
     
	//This method adds a product to an opportunity
	
	public void addProducts() {
		 
		    Wait wait = new Wait();
		   
		   
	    	// click on the add products button and wait for the page to load
		    wait.explicit(30,addProductButton,driver);
		    addProductButton.click();
	    	
		    // find the checkbox element and click on it
	    	try {
	    		productCheckBox = driver.findElement(By.xpath("//*[@id=\"01u2w000006Ybg8\"]"));
	    		productCheckBox.click();
	        } catch (StaleElementReferenceException e) {
	            System.out.println("Element is stale, retrying...");
	            productCheckBox = driver.findElement(By.xpath("//*[@id=\"01u2w000006Ybg8\"]"));
	            productCheckBox.click();
	        }
	    	
	    	// click on the select button and wait for the page to load
	    	selectButton.click();
	    	
	    	// enter the quantity and click on save
	    	//wait.waitExplicit(30,quantityInput,driver);
	    	quantityInput.sendKeys("1");
	    	saveProductButton.click();
	    	
	    	System.out.println("Product is added Successfully");
	 }
	 
	  //This method adds contact roles to an opportunity
	
      public void addContactRoles() {
    	    
	    	//Then it clicks on the New button to add a new contact role
    	    newContactRoles.click();
    	    
	    	//After that, it selects the role as "Business User" from the dropdown
	    	Select Stages = new Select(roleSelect);
		    Stages.selectByVisibleText("Business User");
		    
		    //it clicks on the Save button to save the contact role
		    contactRolesSaveButton.click();
		    
		    System.out.println("Contact Roles is created Successfully");
		 
	 }
      
     // This method adds a new task to Opportunity
      
     public void addTask() {
	    	
	    	// Then clicks on "New Task" button
	    	newTask.click();
	    	
	    	taskSubjectInput.sendKeys("Email");
	    	
	    	// Sets the status of the task as "In Progress"
	    	Select Stages = new Select(taskStatusSelect);
		    Stages.selectByVisibleText("In Progress");
		    
		    // unchecked the "Remainder" checkbox
		    uncheckedReminderCheckbox.click();
		    
		    // Submits the task by clicking on the "Save" button
		    taskSubmit.click();
		    
		    System.out.println("New Task Added Successfully");
	    	
     }
     
    // This method adds a new event to Opportunity
     
    public void addEvent() {
	    	
	    	// Click on the New Event button
	    	newEvent.click();
	  
	    	// Enter the subject for the event and click on the Save button
	    	eventSubjectInput.sendKeys("Meeting");
	    	submitEvent.click();
	    	
	    	System.out.println("New Event is created Successfully");
	    	
     }
     
     //Attach File to Opportunity
    
     public void attachFile() {
    	  
    	    //Clicks on the "Attach File" button
    	    attachFileButton.click();
	    	
	    	//Sends the file path of the attachment to the file input field
	    	String FilePath = System.getProperty("user.dir");
	    	chooseFileInput.sendKeys(FilePath+"\\AttachFile\\AttachFile1.txt");
	    	
	    	//Clicks the "Attach" button
	    	attachButton.click();
	    	
	    	//Clicks the "Done" button
	    	done.click();
	    	
	    	System.out.println("File Attached Successfully");
	    	
     }
     
     public void verifyOpenActivitiesExist() {
    	 
		 // Click on the edit button of the Opportunity
    	 opportunityEditButton.click();
    	 
		 // Select "Closed Won" from the Stage dropdown of the Opportunity
		 Select changeStage = new Select(stageSelect);
		 changeStage.selectByVisibleText("Closed Won");
		 
		 saveButton.click();
		 
	     String ErrorMsg = errorText.getText();
	     
	     System.out.println("Open activities must be completed before closing the opportunity "+ErrorMsg);
	     
	     cancelButton.click();
     }
     
     //Change the Opportunity Stage to "Closed Won"
     
     public void markOpportunityAsClosedWon() {
    	 
    	 // Click on the edit button of the Task
    	 taskEdit.click();
    	
    	 // Select "Completed" from the Status dropdown of the Task
    	 Select Stages = new Select(taskStatusSelect);
		 Stages.selectByVisibleText("Completed");
		 
		 taskSubmit.click();
		 
		 // Delete the Event
		 deleteEvent.click();
		 driver.switchTo().alert().accept();
		 
		 System.out.println("Task Closed Successfully");
		 
		 
		 // Click on the edit button of the Opportunity
		 opportunityEditButton.click();
		 
		 // Select "Closed Won" from the Stage dropdown of the Opportunity
		 Select changeStage = new Select(stageSelect);
	     changeStage.selectByVisibleText("Closed Won");
	     
	     // Click on the save button to update the Opportunity stage
	     saveButton.click();
	     
	     System.out.println("Opportunity Stage Changed to Closed Won Successfully");
	     
	     // Set the file path for the screenshot
	     filePath = System.getProperty("user.dir") + "/Screenshots/OpportunityClosedWon.png";
     }
}
