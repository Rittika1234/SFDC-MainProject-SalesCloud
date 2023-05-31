package testextentreport;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.tamali.base.Base;
import com.tamali.login.SalesforceLogin;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tamali.account.AccountPage;
import com.tamali.opportunity.OpportunityPage;

public class TestSuite {
	
	public static WebDriver driver;
	public static ExtentSparkReporter reporter = new ExtentSparkReporter(
			System.getProperty("user.dir") + "/ExtentReport/extentReportFile.html");
	public static ExtentReports extent = new ExtentReports();
	
	@BeforeSuite
	public void setup() {
		Base base = new Base();
		driver = base.driverSetup();
		extent.attachReporter(reporter);
		reporter.config().setDocumentTitle("Automation Result");
		reporter.config().setReportName("Sales Cloud Automation Test");
		reporter.config().setTheme(Theme.DARK);
		ExtentTest logger = extent.createTest("Driver Test");
		logger.log(Status.INFO, "Browser launched");
		logger.log(Status.INFO, "Navigated to https://cognizantsandbox3-dev-ed.develop.my.salesforce.com/");
	}
	
	@Test(priority = 1)
	public void login() throws Exception{
		SalesforceLogin signin = new SalesforceLogin(driver);
		
		signin.login();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Login Test");
		logger.log(Status.INFO, "Login to SalesForce Account");
		
        logger.log(Status.PASS, "Login Test is passed");
		
		extent.flush();
			
	}
	
	@Test(priority = 2)
	public void account() throws Exception{
		AccountPage accountpage = new AccountPage(driver);
		
		accountpage.checkAccountError();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Account Test");
		logger.log(Status.INFO, "Verify that correct error message is shown on not entering mandatory fields in Account");
		
		accountpage.createAccount();
		logger.log(Status.INFO, "Create Account with mandatory fields");
		
		accountpage.checkContactsError();
		logger.log(Status.INFO, "Verify that correct error message is shown on not entering mandatory fields in Contact");
		
		accountpage.createContact();
		logger.log(Status.INFO, "Create Contact with mandatory fields");
		
        logger.log(Status.PASS, "Account test is passed");
		
		extent.flush();
			
	}
	
	@Test(priority = 3)
	public void opportunity() throws Exception{
		OpportunityPage opportunitypage = new OpportunityPage(driver);
		
		opportunitypage.createOpportunity();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Opportunity Test");
		logger.log(Status.INFO, "Create Opportunity with mandatory fields");
		
		opportunitypage.addProducts();
		logger.log(Status.INFO, "Add Products to Opportunity");
		
		opportunitypage.addContactRoles();
		logger.log(Status.INFO, "Add ContactRoles to Opportunity");
		
		opportunitypage.addTask();
		logger.log(Status.INFO, "Add Task to Opportunity");
		
		opportunitypage.addEvent();
		logger.log(Status.INFO, "Add Event to Opportunity");
		
		opportunitypage.attachFile();
		logger.log(Status.INFO, "Attach a File to Opportunity");
		
		opportunitypage.verifyOpenActivitiesExist();
		logger.log(Status.INFO, "Open Activities exist or not");
		
		opportunitypage.markOpportunityAsClosedWon();
		logger.log(Status.INFO, "Change Opportunity stage to Closed Won");
		
        logger.log(Status.PASS, "Opportunity test is passed");
		
		extent.flush();
			
	}
	
	@AfterSuite
	public void closeDriver() {
		// Close the driver
		driver.quit();
	}

}
