package testcases.selenium;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.PreAndPost;
import pages.selenium.LoginPage;

public class Login extends PreAndPost{
		
	@BeforeTest
	public void provideTestDetails() {
		testName="Login";
		testDesc="Logon with Mandatory Fields";
		testAuthor="Munni";
		testCategory="Regression";
		excelFileName="Salesforce";
		sheetName="Login";
	}
		
	
	@Test(dataProvider="fetchData")
	public void login(String Username, String Password) throws IOException {
	new LoginPage(prop,test,node).
				enterUserName(Username)
				.enterpassword(Password).clickLogin().VerifyHomepageDisplayed();
				
	}

}


