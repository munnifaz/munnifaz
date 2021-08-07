package pages.selenium;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import lib.selenium.BrowserActionsImpl;

public class ContactsPage extends BrowserActionsImpl {
	
	public ContactsPage(ExtentTest test, ExtentTest node,Properties prop,WebDriverWait wait, JavascriptExecutor js) {
	//	this.driver=driver;
		this.prop=prop;
		this.wait=wait;
		this.js=js;
		this.test=test;
		this.node=node;
	}
	
 	private String Email;
	private static String PhoneNum;

	public ContactsPage ClickContactsIcon() throws IOException {
		try {
			getDriver().findElementByXPath("//span[text()='Contacts Menu']//preceding::lightning-icon[1]").click();
			reportStep("successfully click contacts ICON", "Pass");
		} catch (Exception e) {
			reportStep("Not able to click contacts ICON", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage verifyAccUnderBootcamp(String ConName) throws IOException {
		try {
			String accName = driver
					.findElementByXPath(
							"(//p[text()='Recent records']/following-sibling::one-app-nav-bar-menu-item)[1]/a/span")
					.getText();
			System.out.println(accName);
			System.out.println(ConName);
			if (accName.equalsIgnoreCase(ConName)) {
				reportStep("Successfully verified account under bootcamp", "Pass");
			} else {
				reportStep("Not able to verify the account under bootcamp", "Fail");
				System.out.println("not verified account creation under bootcamp campaign");
			}
		} catch (Exception e) {
			reportStep("Not able to verify the account under bootcamp", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage getTheListOfNamesInList() throws IOException {
		int i=1;
		do {
			
			try {
				getDriver().findElementByXPath("//table/tbody/tr["+i+"]//th//a").sendKeys(Keys.PAGE_DOWN);
				
				//System.out.println(driver.findElementByXPath("//table/tbody/tr["+i+"]//th//a").getText());
		        
		    } catch (org.openqa.selenium.NoSuchElementException e) {
		    	reportStep("Not able to print the list of names in List", "Fail");
		        break;
		    }
			
			i=i+1;
			
		} while (true);
		return this;
	}
		

	
	public ContactsPage searchUnderListTextboxInContactsPage(String AccName) throws InterruptedException, IOException {

		try {
			System.out.println(AccName);
			wait = new WebDriverWait(getDriver(), 100);
			WebElement searchlistbox=getDriver().findElementByXPath(prop.getProperty("ContactsPage.seachlistTextbox.XPath"));
			wait.until(ExpectedConditions.visibilityOf(searchlistbox));
			searchlistbox.clear();
			searchlistbox.sendKeys(AccName);
			searchlistbox.sendKeys(Keys.ENTER);
			reportStep("Successfully entered AccName in search Text Box", "Pass");
		} catch (Exception e) {
			reportStep("Not able to enter AccName in search Text Box", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage clickActionOnTheUniqueName(String Action) throws IOException {
		try {
			  js = (JavascriptExecutor) getDriver();
			WebElement mt = getDriver().findElement(By.xpath(
					"//a[@role='button'][@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']/span"));
			js.executeScript("arguments[0].scrollIntoView(true);", mt);
			Thread.sleep(1000);
			getDriver().findElementByXPath("//table/tbody/tr[1]/td[8]//div").click();
			
			WebElement editAction=getDriver().findElementByXPath("//a[@title='"+Action+"']");
			Thread.sleep(1000);
			editAction.click();
			reportStep("Successfully clicked Edit on the AccName", "Pass");

		} catch (Exception e) {
			reportStep("Not able to click Edit on the AccName", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage editContactDetailsTitle(String Title) throws IOException {

		try {

			WebElement title = getDriver().findElementByXPath(prop.getProperty("ContactsPage.editcontactdetailsTitle.XPath"));
			title.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Title);
			reportStep("Successfully edited Title field", "Pass");
		} catch (Exception e) {
			reportStep("Not able to edit Title field", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage editContactDetailsBirthDate(String Birthday) throws IOException {

		try {
			WebElement Birthdayfromapp = getDriver().findElementByXPath(prop.getProperty("ContactsPage.editcontactsdetailsbirthdate.XPath"));
			Birthdayfromapp.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Birthday);
			reportStep("Successfully edited Birthday field", "Pass");

		} catch (Exception e) {
			reportStep("Not able to edit Birthday field", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage editContactDetailsleadsource(String leadsource) throws IOException {

		try {
			getDriver().findElementByXPath(prop.getProperty("ContactsPage.leadsource.XPath")).sendKeys(leadsource);
			reportStep("Successfully edit the leadsource details", "Pass");
		} catch (Exception e) {
			reportStep("Not able to edit the leadsource details", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage editContactDetailsPhonenum(String phone) throws IOException {
		try {
			WebElement Phonenumber = getDriver().findElementByXPath(prop.getProperty("ContactsPage.phonenum.XPath"));
			Phonenumber.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), phone);
			PhoneNum = phone;
			reportStep("Successfully edit the phoneNum details", "Pass");

		} catch (Exception e) {
			reportStep("Not able to edit the Phonenum details", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage editContactDetailsEmail(String email) throws IOException {

		try {

			WebElement emailele = getDriver().findElementByXPath(prop.getProperty("ContactsPage.ContactDetailsemail.XPath"));
			emailele.clear();
			emailele.sendKeys(email);
			// emailele.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), email);
			Email = email;
			reportStep("Successfully edit the email details", "Pass");

		} catch (Exception e) {
			reportStep("Not able to edit the email address", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage editContactDetailsStreet(String street) throws IOException {
		try {
			WebElement area = getDriver().findElementByXPath(prop.getProperty("ContactsPage.street.XPath"));
			area.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), street);
			reportStep("Successfully edit the Street details", "Pass");
		} catch (Exception e) {
			reportStep("Not able to edit the Street details", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage editContactDetailsLevel(String Level) throws IOException {
		try {

			WebElement Levelele = getDriver().findElementByXPath(prop.getProperty("ContactsPage.level.XPath"));
			Levelele.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Level);
			reportStep("Successfully edit the Level details", "Pass");
		} catch (Exception e) {
			reportStep("Not able to edit the Level details", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage ClickSaveBtnOnEditWindow() throws IOException {
		try {
			 wait = new WebDriverWait(getDriver(), 60);
			WebElement savebtn = getDriver().findElementByXPath(prop.getProperty("ContactsPage.savebtn.XPath"));
			wait.until(ExpectedConditions.elementToBeClickable(savebtn));
			savebtn.click();
			reportStep("Successfully clicked on Edit window", "Pass");

		} catch (Exception e) {
			reportStep("Not able to click on Edit window", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage VerifyPhoneNumberAfterEdit() throws IOException {
		try {
			Thread.sleep(2000);
			 wait = new WebDriverWait(getDriver(),120);
			WebElement getphonenum = getDriver().findElementByXPath("//table//tbody//tr[1]//td[5]//span[@dir='ltr']");
			wait.until(ExpectedConditions.visibilityOf(getphonenum));
			String Phonenumfromapp = getphonenum.getText();
			String exactphonenumber = Phonenumfromapp.replaceAll("\\D", "");
			System.out.println(exactphonenumber);
			if (exactphonenumber.equals(PhoneNum)) {
				//System.out.println("The testcase passed & phone number updated and verified");
				reportStep("Successfully verified phonenum", "Pass");
			} else {
				//System.out.println("The testcase failed & phone number is not verified");
				reportStep("Not able to verify Phonenum", "Fail");
			}

		} catch (Exception e) {
			reportStep("Not able to verify Phonenum", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage verifyEmail() throws IOException {
		try {
			wait = new WebDriverWait(getDriver(), 60);
			WebElement Emailele = getDriver().findElementByXPath("//table//tbody//tr[1]//td[6]//span//a");
			wait.until(ExpectedConditions.visibilityOf(Emailele));
			String emailFromApp = Emailele.getText();
			System.out.println(emailFromApp);
			if (emailFromApp.equals(Email)) {
				//System.out.println("The testcase passed & Email updated and verified");
				reportStep("Successfully verified Email", "Pass");
			} else {
				//System.out.println("The testcase failed & Email is not verified");
				reportStep("Email Not verified successfully", "Fail");
			}
		} catch (Exception e) {
			reportStep("Email Not verified successfully", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage clickDeletepopup() throws IOException {
		try {
			wait = new WebDriverWait(driver, 60);
			WebElement Deletepopup = getDriver().findElementByXPath("//span[text()='Delete']");
			Deletepopup.click();

			WebElement msg = driver
					.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
			wait.until(ExpectedConditions.visibilityOf(msg));
			if (msg.isDisplayed()) {
				System.out.println("Deleted msg displayed");
				reportStep("Successfully clicked on delete popup", "Pass");
			} else {
				System.out.println("Delete msg not displayed");
				reportStep("Unable to click on delete popup", "Fail");
			}

			Thread.sleep(10000);
		} catch (Exception e) {
			reportStep("Unable to click on delete popup", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	/*
	 * public ContactsPage verifyContactDeleted(String Name) { try { WebElement
	 * NoItems = getDriver().findElementByXPath("//span[text()='No items to display.']");
	 * wait = new WebDriverWait(driver, 60);
	 * wait.until(ExpectedConditions.visibilityOf(NoItems)); if
	 * (NoItems.isDisplayed()) {
	 * System.out.println("The account was deleted successfully"); } else {
	 * System.out.println("The account was Not deleted");
	 * 
	 * } } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return this; }
	 */

	public ContactsPage deleteContact() throws InterruptedException, IOException {

		try {
			wait = new WebDriverWait(driver, 60);
			getDriver().findElementByXPath("//ul[@class='slds-button-group-list']//li[4]//button[@type='button']").click();
			getDriver().findElementByXPath("//a[@name='Delete']//span").click();
			Thread.sleep(2000);
			getDriver().findElementByXPath("//span[text()='Delete'][@class=' label bBody']").click();
			WebElement msg = driver
					.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
			wait.until(ExpectedConditions.visibilityOf(msg));
			if (msg.isDisplayed()) {
				//System.out.println("The contact has been deleted msg is displaying");
				reportStep("Successfully deleted the contact", "Pass");
			} else {

				reportStep("Unable to verify the deleted contact","Fail");
			}
		} catch (Exception e) {
			reportStep("Unable to verify the deleted contact","Fail");
			e.printStackTrace();
		}
		return this;
	}
}
