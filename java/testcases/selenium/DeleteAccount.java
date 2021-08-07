package testcases.selenium;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.PreAndPost;
import pages.selenium.ContactsPage;
import pages.selenium.Homepage;
import pages.selenium.LoginPage;

public class DeleteAccount extends PreAndPost {

	

	@BeforeTest
	public void provideTestDetails() {
		testName="DeleteAccount";
		testDesc="Delete a newly created account";
		testAuthor="Munni";
		testCategory="Regression";
		excelFileName="Salesforce";
		sheetName="DeleteAccount";
	}
		
	@Test(dataProvider="fetchData",dependsOnMethods = {"testcases.EditAccount.editCon"})
	public void DeleteCon(String Username,String Password, String Action) throws InterruptedException, IOException {
		
		ContactsPage cp=new ContactsPage(test,node,prop,wait,js);
		Homepage HP=new Homepage(prop,node,wait, js);
		
		new LoginPage(prop,test,node).enterUserName(Username).enterpassword(Password).clickLogin();HP.VerifyHomepageDisplayed().clickAppLauncher()
		.clickViewAll().clickContacts();cp.getTheListOfNamesInList().searchUnderListTextboxInContactsPage(prop.getProperty("Accountname")).clickActionOnTheUniqueName(Action)
		.clickDeletepopup().searchUnderListTextboxInContactsPage(prop.getProperty("Accountname"));
	}
}
