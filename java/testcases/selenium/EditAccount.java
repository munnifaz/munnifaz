package testcases.selenium;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.PreAndPost;
import pages.selenium.ContactsPage;
import pages.selenium.Homepage;
import pages.selenium.LoginPage;

public class EditAccount extends PreAndPost {
	
	@BeforeTest
	public void provideTestDetails() {
		testName="EditAccount";
		testDesc="Edit the account details";
		testAuthor="Munni";
		testCategory="Regression";
		excelFileName="Salesforce";
		sheetName="EditAccount";
	}
		
	@Test(dataProvider="fetchData" ,dependsOnMethods={"testcases.CreateAccount.CreateAcc"})
	public void editCon(String Username,String Password, String Action,String Title,String Birthday, String leadsource,String level,String street,String Phone, String Email) throws InterruptedException, IOException {
		
		ContactsPage cp=new ContactsPage(test,node,prop,wait,js);
		Homepage HP=new Homepage(prop,node, wait, js);
		new LoginPage(prop,test,node).enterUserName(Username).enterpassword(Password).clickLogin();HP.VerifyHomepageDisplayed().clickAppLauncher()
		.clickViewAll().clickContacts();cp.getTheListOfNamesInList().searchUnderListTextboxInContactsPage(prop.getProperty("Accountname")).clickActionOnTheUniqueName(Action)
		.editContactDetailsTitle(Title)
		.editContactDetailsBirthDate(Birthday)
		.editContactDetailsleadsource(leadsource)
		.editContactDetailsLevel(level)
		.editContactDetailsStreet(street)
		.editContactDetailsPhonenum(Phone)
		.editContactDetailsEmail(Email)
		.ClickSaveBtnOnEditWindow()
		.VerifyPhoneNumberAfterEdit()
		.verifyEmail();
		
	
	
}
}