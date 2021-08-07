package testcases.selenium;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.PreAndPost;
import pages.selenium.Homepage;
import pages.selenium.LoginPage;

public class CreateNewOpp extends PreAndPost {

	@BeforeTest
	public void provideTestDetails() {
		testName="createNewopp";
		testDesc="Creating new oppurtunity";
		testAuthor="Munni";
		testCategory="Regression";
		excelFileName="Salesforce";
		sheetName="CreateNewopp";
	}
		
	@Test(dataProvider="fetchData")
	public void createNewOpp(String Username,String Password, String NewOpp) throws InterruptedException, IOException {
		Homepage HP=new Homepage(prop,node, wait, js);
		
		new LoginPage(prop,test,node).enterUserName(Username).enterpassword(Password);HP.VerifyHomepageDisplayed().clickAppLauncher()
		.clickViewAll().clickSales().clickBootcamplink().clickNewOppInCampaignAndFillDetails(NewOpp).verifyNewOpp();
		
	}
	
}
