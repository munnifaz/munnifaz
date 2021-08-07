package testcases.selenium;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.PreAndPost;
import pages.selenium.Homepage;
import pages.selenium.LoginPage;

public class TaskWithMandatoryFields extends PreAndPost {

	@BeforeTest
	public void provideTestDetails() {
		testName="TestwithMandatoryfields";
		testDesc="Testing with Mandatory fields";
		testAuthor="Munni";
		testCategory="Regression";
		excelFileName="Salesforce";
		sheetName="Login";
	}
		
	
	@Test(dataProvider="fetchData")
	
	public void taskwithMandatoryfields(String Username, String Password ) throws IOException {
		
		Homepage HP=new Homepage(prop,node, wait, js);
					new LoginPage(prop,test,node).enterUserName(Username).enterpassword(Password);HP.VerifyHomepageDisplayed().clickAppLauncher()
					.clickViewAll().clickSales().clickTaskTab().clickNewTaskinsideTaskTab().enterNameInNewTaskWindow()
					.enterCommentsInNewTaskWindow().clickSaveInNewTaskWindow().verifyErrorMsgInNewTaskWindow();
}
}