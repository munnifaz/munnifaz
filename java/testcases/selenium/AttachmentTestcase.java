package testcases.selenium;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.PreAndPost;
import pages.selenium.Homepage;
import pages.selenium.LoginPage;

public class AttachmentTestcase extends PreAndPost {

	

	@BeforeTest
	public void setFile() {
		excelFileName="Salesforce";
		sheetName="Attachment";
	}
		
	@Test(dataProvider="fetchData")
	public void createCon(String Username,String Password, String From, String To) throws InterruptedException, IOException {
		
		Homepage HP=new Homepage(prop,node, wait, js);
		new LoginPage(prop,test,node).enterUserName(Username).enterpassword(Password);HP.VerifyHomepageDisplayed()
		.clickViewAll().clickServiceConsole().clickIconandFiles().clickLatestModifiedItem().UploadFileUsingFileStream(From,To)
		.clickShareAndVerifyErrormsg().uploadFile().viewFileDetails().deleteFile();
		
}
}
