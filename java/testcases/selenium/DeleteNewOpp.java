package testcases.selenium;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.PreAndPost;
import pages.selenium.Homepage;
import pages.selenium.LoginPage;

public class DeleteNewOpp extends PreAndPost{

	
	@BeforeTest
	public void provideTestDetails() {
		testName="DeleteNewOpp";
		testDesc="Delete a newly created opp";
		testAuthor="Munni";
		testCategory="Regression";
		excelFileName="Salesforce";
		sheetName="CreateNewopp";
	}
		
	@Test(dataProvider="fetchData")
	public void deleteNewOpp(String Username,String Password, String NewOpp) throws InterruptedException, IOException {
		
		Homepage HP=new Homepage(prop,node,wait, js);
		new LoginPage(prop,test,node).enterUserName(Username).enterpassword(Password);HP.VerifyHomepageDisplayed().clickAppLauncher()
		.clickViewAll().clickSales().clickBootcamplink().deleteNewOpp(NewOpp).verityDeletedOpp(NewOpp);
		
	}
}
