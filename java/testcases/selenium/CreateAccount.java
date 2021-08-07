package testcases.selenium;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.PreAndPost;
import pages.selenium.Homepage;
import pages.selenium.LoginPage;

public class CreateAccount extends PreAndPost{
	
	
	@BeforeTest
	public void provideTestDetails() {
		testName="createAccount";
		testDesc="Create account with mandatory fields";
		testAuthor="Munni";
		testCategory="Regression";
		excelFileName="Salesforce";
		sheetName="CreateAccount";
	}
	
	
	@Test(dataProvider="fetchData") 
	public void CreateAcc(String Username,String Password,String Title,String FirstName,String LastName,String email,String inputtext) throws InterruptedException, IOException 
		{
		Homepage HP=new Homepage(prop,node, wait, js);
		new LoginPage(prop,test,node)
		.enterUserName(Username).enterpassword(Password).clickLogin();HP.VerifyHomepageDisplayed().Globalsmallicon().newContact().clickSaluation().title(Title).firstName(FirstName).lastName(LastName)
		.email(email).clickSearchAcc().ClickNewAcc().enterAccName(inputtext).clickSave().clickSave1().Accountdisplaymsg();
		
			
	}

}
