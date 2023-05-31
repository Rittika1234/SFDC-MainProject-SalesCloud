package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.tamali.base.Base;
import com.tamali.login.SalesforceLogin;
import com.tamali.account.AccountPage;
import com.tamali.opportunity.OpportunityPage;

public class TestSuite {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		Base base = new Base();
		driver = base.driverSetup();
	}
	
	@Test(priority = 1)
	public void executeAllTests() throws Exception{
		
		SalesforceLogin signin = new SalesforceLogin(driver);
		signin.login();
		
		AccountPage accountPage = new AccountPage(driver);
		accountPage.checkAccountError();
		accountPage.createAccount();
		accountPage.checkContactsError();
		accountPage.createContact();
		
		OpportunityPage opportunityPage = new OpportunityPage(driver);
		opportunityPage.createOpportunity();
		opportunityPage.addProducts();
		opportunityPage.addContactRoles();
		opportunityPage.addTask();
		opportunityPage.addEvent();
		opportunityPage.attachFile();
		opportunityPage.verifyOpenActivitiesExist();
		opportunityPage.markOpportunityAsClosedWon();
			
	}
	
	@AfterSuite
	public void closeDriver() {
		// Close the driver
		driver.quit();
	}

}
