package testcases.selenium;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.PreAndPost;
import pages.selenium.ContactsPage;
import pages.selenium.Homepage;
import pages.selenium.LoginPage;

public class CreateContact extends PreAndPost {
	
	
	@BeforeTest
	public void provideTestDetails() {
		testName="CreateContact";
		testDesc="create contact with Mandatory Fields";
		testAuthor="Munni";
		testCategory="Regression";
		excelFileName="Salesforce";
		sheetName="CreateContact";
	}
		
	@Test(dataProvider="fetchData")
	public void createCon(String Username,String Password, String FName, String LName) throws InterruptedException, IOException {
		
		ContactsPage cp=new ContactsPage(test,node,prop,wait,js);
		Homepage HP=new Homepage(prop,node,wait, js);
		new LoginPage(prop,test,node).enterUserName(Username).enterpassword(Password);HP.VerifyHomepageDisplayed()
		.clickAppLauncher().clickViewAll().clickSales().clickBootcamplink().addContacts()
		.typeNewContact().clickSaluation().allInputDetailsForNewContact(FName,LName)
		.nextbtnAddContactstoCompaignPage().submitBtninAddtoCampaignPage();
		cp.ClickContactsIcon().verifyAccUnderBootcamp(prop.getProperty("Contactname"));
		
	}
	
	
	
	
}
