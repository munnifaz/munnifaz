package testcases.selenium;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.PreAndPost;
import pages.selenium.ContactsPage;
import pages.selenium.Homepage;
import pages.selenium.LoginPage;

public class UpdateAccount extends PreAndPost {

	@BeforeTest
	public void setFile() {
		excelFileName = "Salesforce";
		sheetName = "UpdateAccount";
	}

	@Test(dataProvider = "fetchData")
	public void updateCon(String Username, String Password, String Actions, String Email) throws InterruptedException, IOException {

		ContactsPage cp = new ContactsPage(test,node,prop,wait,js);
		Homepage HP=new Homepage(prop,node, wait, js);

		new LoginPage(prop,test,node).enterUserName(Username).enterpassword(Password);HP.VerifyHomepageDisplayed().clickAppLauncher().clickViewAll().clickContacts();
		

	}
}
