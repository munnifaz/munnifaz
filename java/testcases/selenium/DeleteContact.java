package testcases.selenium;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.PreAndPost;
import pages.selenium.ContactsPage;
import pages.selenium.Homepage;
import pages.selenium.LoginPage;

public class DeleteContact extends PreAndPost {

	
	@BeforeTest
	public void provideTestDetails() {
		testName="DeleteContact";
		testDesc="Delete newly created contact";
		testAuthor="Munni";
		testCategory="Regression";
		excelFileName="Salesforce";
		sheetName="DeleteContact";
	}
		
	@Test(dataProvider="fetchData")
	public void DeleteCon(String Username,String Password) throws InterruptedException, IOException {
		Homepage HP=new Homepage(prop,node, wait, js);
		
		new LoginPage(prop,test,node).enterUserName(Username).enterpassword(Password);HP.VerifyHomepageDisplayed().clickAppLauncher()
		.clickViewAll().clickSales().clickrecentrecordundercontacts(prop.getProperty("Contactname")).deleteContact();
		
	}
}
