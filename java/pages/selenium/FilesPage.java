package pages.selenium;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.google.common.io.Files;
import lib.selenium.BrowserActionsImpl;

public class FilesPage extends BrowserActionsImpl {
	JavascriptExecutor jsexecutr = (JavascriptExecutor) driver;

	// click filesicon and select files

	public FilesPage clickIconandFiles() throws InterruptedException {
		try {

			WebElement icon = driver.findElementByXPath("//span[text()='Show Navigation Menu']");
			jsexecutr.executeScript("arguments[0].click();", icon);
			WebElement Fileslink = driver.findElementByXPath("(//span[text()='Files'])[2]");
			Fileslink.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;}

	
	public FilesPage clickLatestModifiedItem() {
	try {
		WebElement modifiedlink = driver
					.findElementByXPath("(//table//tbody//tr//td[4]//span//div//a[@role='button'])[1]");
			modifiedlink.click();
			WebElement publiclink = driver.findElementByXPath("//a[@title='Public Link']");
			publiclink.click();
			WebElement ele = driver.findElementByXPath("//input[@name='publicLinkURL']");
			if (ele.isEnabled()) {
				System.out.println("The link is enabled");
			} else {
				System.out.println("The link is disabled");
			}

			WebElement closebtn = driver.findElementByXPath("//button[@title='Close this window']");
			closebtn.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;}
	
	

	public FilesPage clickDownload() {
		try {

			WebElement modifiedlink = driver
					.findElementByXPath("(//table//tbody//tr//td[4]//span//div//a[@role='button'])[1]");
			modifiedlink.click();
			WebElement downloadlnk = driver.findElementByXPath("//a[@title='Download']");
			downloadlnk.click();}
		catch (Exception e) {
			e.printStackTrace();
		}
		return this;}
	
	

	public FilesPage UploadFileUsingFileStream(String from, String To) throws InterruptedException {

		File source = new File(from);
		  File dest = new File(To); 
		  try {
		  FileUtils.copyFileToDirectory(source, dest);
		  } catch (IOException e) {
		  e.printStackTrace();
		  }
		  return this;
	}

	
	
	public FilesPage clickShareAndVerifyErrormsg() {
		try {

			WebElement modifiedlink = driver
					.findElementByXPath("(//table//tbody//tr//td[4]//span//div//a[@role='button'])[1]");
			modifiedlink.click();
			WebElement share = driver.findElementByXPath("//a[@title='Share']");
			share.click();
			WebElement searchpeople = driver.findElementByXPath("//input[@title='Search People']");
			searchpeople.click();
			driver.findElementByXPath("//div[@title='Derrick Dsouza']").click();
			WebElement errormsg = driver.findElementByXPath("//li[@class='form-element__help']");
			if (errormsg.isDisplayed()) {
				System.out.println("The error message is displaying");
				driver.findElementByXPath("//span[@class='deleteIcon']").click();
				driver.findElementByXPath("//div[@title='Integration User']").click();
				driver.findElementByXPath("//span[text()='Share']").click();
				WebElement msg=driver.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
				if(msg.isDisplayed()) {
					System.out.println("You shared with integration user successfully");}
				else {
					System.out.println("Not able to share");
				}	
				
			} else {
				System.out.println("The error message is not displaying");
			}
			driver.findElementByXPath("//button[@title='Close this window']").click();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;}
	
	
	public FilesPage  uploadFile() {
		try {
			WebElement uploadfile=driver.findElementByXPath("//div[@title='Upload Files']");
			uploadfile.click();
			Thread.sleep(3000);
			//uploadfile.sendKeys("C:\\Users\\munni\\OneDrive\\Desktop\\Assessment Attachment.pdf");
			 Robot rb = new Robot();
			 
			    // copying File path to Clipboard
			   StringSelection str = new StringSelection("C:\\Users\\munni\\OneDrive\\Desktop\\Munni.pdf");
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			 
			     // press Contol+V for pasting
			     rb.keyPress(KeyEvent.VK_CONTROL);
			     rb.keyPress(KeyEvent.VK_V);
			 
			    // release Contol+V for pasting
			    rb.keyRelease(KeyEvent.VK_CONTROL);
			    rb.keyRelease(KeyEvent.VK_V);
			 
			    // for pressing and releasing Enter
			    rb.keyPress(KeyEvent.VK_ENTER);
			    rb.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("Uploaded");
			Thread.sleep(3000);
			driver.findElementByXPath("//span[text()='Done']").click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return this;
	}
	
	public FilesPage viewFileDetails() {
		try {
			Thread.sleep(3000);
			WebElement modifiedlink = driver
					.findElementByXPath("(//table//tbody//tr//td[4]//span//div//a[@role='button'])[1]");
			modifiedlink.click();
			driver.findElementByXPath("//a[@title='View File Details']").click();
			Thread.sleep(5000);
			WebElement titleEle=driver.findElementByXPath("//div[@title='Munni']");
			String Title=titleEle.getAttribute("title");
			System.out.println(Title);
			WebElement Fileextensionele=driver.findElementByXPath("(//span[text()='pdf'])[2]");
			String Extension=Fileextensionele.getText();
			System.out.println(Extension);
			
			if(Title.equalsIgnoreCase("Munni") && Extension.equalsIgnoreCase("pdf")) {
				System.out.println("File name and extensions are correct");
			driver.findElementByXPath("//a[@title='Files']").click();}
			else {
				System.out.println("wrong file uploaded");
				
			}
				
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public FilesPage deleteFile() {
		try {
			

			WebElement modifiedlink = driver
					.findElementByXPath("(//table//tbody//tr//td[4]//span//div//a[@role='button'])[1]");
			modifiedlink.click();
			driver.findElementByXPath("//a[@title='Delete']").click();
			driver.findElementByXPath("//button[@title='Delete']").click();
			Thread.sleep(3000);
			WebElement msg=driver.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
			if(msg.isDisplayed()) {
				System.out.println("File deleted successfully");}
			else {
				System.out.println("File not deleted successfully");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	
	
	
	
	
}
