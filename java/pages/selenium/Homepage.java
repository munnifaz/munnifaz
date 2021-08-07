package pages.selenium;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import lib.selenium.BrowserActionsImpl;

public class Homepage extends BrowserActionsImpl {

	public Homepage(Properties prop, ExtentTest node, WebDriverWait wait, JavascriptExecutor js) {
		// this.driver = driver;
		this.wait = wait;
		this.js = js;
		this.prop = prop;
		//this.test = test;
		this.node = node;
	}
	
	Random rand = new Random();
	int rand_int1 = rand.nextInt(1000);
	private String FName, LName;
	public String AccountName;

	// public static String AccName;

	public Homepage VerifyHomepageDisplayed() throws IOException {
		try {
			String title = getDriver().getTitle();
			if (title.contains("Home")) {
				reportStep("HomePage displayed successfully", "Pass");
			} else {
				reportStep("HomePage not displayed successfully", "Fail");
			}

		} catch (Exception e) {
			reportStep("HomePage not displayed successfully", "Fail");
			e.printStackTrace();
		}

		return this;
	}

	// click global actions icon
	public Homepage Globalsmallicon() throws InterruptedException, IOException {
		wait = new WebDriverWait(getDriver(), 60);
		js = (JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		try {
			WebElement smallicon = getDriver().findElementByXPath(prop.getProperty("Homepage.smallicon.XPath"));
			smallicon.click();
			reportStep("Successfully clicked Global Action ICON", "Pass");
		} catch (Exception e) {
			reportStep("Not able to clic Global Action ICON", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	// clicking the new contact
	public Homepage newContact() throws IOException, InterruptedException {
		Thread.sleep(2000);
		try {
			WebElement contact = getDriver().findElementByXPath(prop.getProperty("Homepage.contact.XPath"));
			contact.click();
			reportStep("Successfully clicked NewContact link", "Pass");
		} catch (Exception e) {
			reportStep("Not able to clic NewContact link", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	// Filling the details
	public Homepage clickSaluation() throws IOException {
		try {
			getDriver().findElementByXPath(prop.getProperty("Homepage.Saluation.XPath")).click();
			reportStep("Successfully clicked Saluation", "Pass");
		} catch (Exception e) {
			reportStep("Not able to click Saluation", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage title(String Title) throws IOException {
		try {
			getDriver().findElementByXPath("(//a[text()='" + Title + "'])[1]").click();
			reportStep("Successfully selected saluation as" + Title, "Pass");
		} catch (Exception e) {
			reportStep("Not able to select saluation as" + Title, "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage firstName(String FirstName) throws IOException {
		try {
			WebElement firstName = getDriver().findElementByXPath(prop.getProperty("Homepage.firstName.XPath"));
			firstName.sendKeys(FirstName);
			FName = FirstName;
			reportStep("Successfully Entered firstName as" + FirstName, "Pass");

		} catch (Exception e) {
			reportStep("Not able to enter firstName as" + FirstName, "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage lastName(String LastName) throws IOException {
		try {
			WebElement lastname = getDriver().findElementByXPath(prop.getProperty("Homepage.lastname.XPath"));
			lastname.sendKeys(LastName + rand_int1);
			LName = LastName + rand_int1;
			AccountName = FName + " " + LName;
			System.out.println(AccountName);
			FileOutputStream write = new FileOutputStream("./src/main/resources/config.properties");
			prop.setProperty("Accountname", AccountName);
			prop.store(write, "");
			reportStep("Successfully Entered LastName as" + LastName, "Pass");

		} catch (Exception e) {
			reportStep("Not able to Enter LastName as" + LastName, "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage email(String email) throws IOException {
		try {
			getDriver().findElementByXPath(prop.getProperty("Homepage.email.XPath")).sendKeys(email);
			reportStep("Successfully Entered email", "Pass");
		} catch (Exception e) {
			reportStep("Not able to enter email", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	// Creating the Account

	public Homepage clickSearchAcc() throws InterruptedException, IOException {
		try {
			getDriver().findElementByXPath(prop.getProperty("Homepage.searchaccount.XPath")).click();
			reportStep("Successfully clicked on SearchAccount", "Pass");
			Thread.sleep(1000);
		} catch (Exception e) {
			reportStep("Not able to click on SearchAccount", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage ClickNewAcc() throws IOException {
		try {
			getDriver().findElementByXPath(prop.getProperty("Homepage.Clicknewaccount.XPath")).click();
			reportStep("Successfully clicked on ClickNewAccount", "Pass");
		} catch (Exception e) {
			reportStep("Not able to click on ClickNewAccount", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	// Giving the Details in account, it is identifying as same window

	public Homepage enterAccName(String inputtext) throws IOException {
		try {
			getDriver().findElementByXPath(prop.getProperty("Homepage.enteraccname.XPath")).sendKeys(inputtext);
			reportStep("Successfully entered AccountName", "Pass");
		} catch (Exception e) {
			reportStep("Not able to enter AccountName", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage clickSave() throws InterruptedException, IOException {
		try {
			getDriver().findElementByXPath(prop.getProperty("Homepage.clicksave.XPath")).click();
			reportStep("Successfully clicked on Savebtn in Homepage", "Pass");
			Thread.sleep(1000);
		} catch (Exception e) {
			reportStep("Not able to click save on Homepage", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage clickSave1() throws IOException {
		try {
			getDriver().findElementByXPath(prop.getProperty("Homepage.clicksave1.XPath")).click();
			reportStep("Successfully clicked on Save btn", "Pass");
		} catch (Exception e) {
			reportStep("Not able to click save btn", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	// checking the account creation successful or not
	public Homepage Accountdisplaymsg() throws IOException {
		Boolean Accountcreatedmsg = getDriver().findElementByXPath(prop.getProperty("Homepage.Accountcreatedmsg.XPath"))
				.isDisplayed();
		if (Accountcreatedmsg) {
			// Assert.assertTrue(true);
			// System.out.println("The testcase passed & Contact successfully created");
			reportStep("Successfully dislayed Accountcreated Message", "Pass");
		} else {
			// Assert.fail();
			reportStep("Not able to dislay Accountcreated Message", "Fail");

		}
		return this;
	}

	public Homepage clickAppLauncher() throws IOException {
		try {
			getDriver().findElementByXPath(prop.getProperty("Homepage.clickAppLauncher.XPath")).click();
			reportStep("Successfully click on AppLauncher", "Pass");
		} catch (Exception e) {
			reportStep("not able to click on AppLauncher", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage clickViewAll() throws IOException {
		try {
			wait = new WebDriverWait(getDriver(), 60);
			// getDriver().findElementByXPath("//div[@class='slds-icon-waffle']").click();
			WebElement ViewAllbutton = getDriver().findElementByXPath(prop.getProperty("Homepage.viewAllButton.XPath"));
			// getDriver().findElementByXPath("//button[text()='View All']").click();
			wait.until(ExpectedConditions.elementToBeClickable(ViewAllbutton));
			ViewAllbutton.click();
			reportStep("Successfully clicked ViewAll ", "Pass");
		} catch (Exception e) {
			reportStep("Not able to click viewAll", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage clickContacts() throws IOException {
		try {
			getDriver().findElementByXPath(prop.getProperty("Homepge.searchappstext.XPath")).sendKeys("Contacts");
			getDriver().findElementByXPath("//mark[text()='Contacts']").click();
			reportStep("Successfully clicked contacts Tab", "Pass");
		} catch (Exception e) {
			reportStep("Not able to click contacts Tab", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage clickSales() throws IOException {
		try {
			getDriver().findElementByXPath("//input[@class='slds-input']").sendKeys("Sales");
			getDriver().findElementByXPath("(//mark[text()='Sales'])[3]").click();
			reportStep("Successfully clicked sales Tab", "Pass");
		} catch (Exception e) {
			reportStep("Not able to click sales Tab", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public FilesPage clickServiceConsole() throws IOException {
		try {
			getDriver().findElementByXPath("//input[@class='slds-input']").sendKeys("Service Console");
			getDriver().findElementByXPath("//mark[text()='Service Console']").click();
			reportStep("Successfully clicked serviceconsole Tab", "Pass");
		} catch (Exception e) {
			reportStep("Not able to click serviceconsole Tab", "Fail");
			e.printStackTrace();
		}
		return new FilesPage();
	}

	// Click on Campaigns small ICON ->BootCamp link
	public CampaignPage clickBootcamplink() throws InterruptedException, IOException {
		try {

			WebElement SmallIconbesidebootcamptab = driver
					.findElementByXPath("//span[text()='Campaigns Menu']//preceding::lightning-primitive-icon[1]");
			js.executeScript("arguments[0].click();", SmallIconbesidebootcamptab);
			Thread.sleep(1000);
			WebElement Bootcamplink = getDriver().findElementByXPath("(//span[text()='BootCamp'])[1]");
			js.executeScript("arguments[0].click();", Bootcamplink);
			reportStep("Successfully clicked Bootcamp Link", "Pass");
		} catch (Exception e) {
			reportStep("Not able to click Bootcamp Link", "Fail");
			e.printStackTrace();
		}
		return new CampaignPage(test,node,prop, wait, js);
	}

	public ContactsPage clickrecentrecordundercontacts(String ContactName) throws IOException {
		try {
			getDriver().findElementByXPath("//span[text()='Contacts Menu']//preceding::lightning-icon[1]").click();
			WebElement accName = getDriver().findElementByXPath(
					"(//p[text()='Recent records']/following-sibling::one-app-nav-bar-menu-item)[1]//a//span//span");
			wait.until(ExpectedConditions.visibilityOf(accName));
			String Contactlnk = accName.getText();
			if (Contactlnk.equalsIgnoreCase(ContactName)) {
				System.out.println("Contact match");
				js.executeScript("arguments[0].click();", accName);
				Thread.sleep(2000);
				reportStep("Successfully clicked recent record displayed under contacts", "Pass");

			} else {
				System.out.println("Contact not found under Bootcamp Link");
			}

		} catch (Exception e) {
			reportStep("Not able to click recent record displayed under contacts", "Fail");
			e.printStackTrace();
		}
		return new ContactsPage(test,node,prop, wait, js);
	}

	public Homepage clickTaskTab() throws IOException {
		try {
			getDriver().findElementByXPath("//a[@title='Tasks']/following-sibling::one-app-nav-bar-item-dropdown//div")
					.click();
			reportStep("Successfully Clicked Task Tab", "Pass");
		} catch (Exception e) {
			reportStep("Not able to click Task Tab", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage clickNewTaskinsideTaskTab() throws IOException {
		try {
			WebElement newtask = getDriver().findElementByXPath("(//span[text()='New Task'])[1]");
			js.executeScript("arguments[0].click();", newtask);
			reportStep("successfully cliked NewTask Inside Task Tab", "Pass");
		} catch (Exception e) {
			reportStep("Not able to click NewTask inside Task Tab", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage enterNameInNewTaskWindow() throws IOException {
		try {
			getDriver().findElementByXPath("//input[@title='Search Contacts']").click();
			getDriver().findElementByXPath("//div[@title='test dd']").click();
			reportStep("Successfully entered name in NewTask Window", "Pass");
		} catch (Exception e) {
			reportStep("Not able to enter Name in NewTask Window", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage enterCommentsInNewTaskWindow() throws IOException {
		try {
			getDriver().findElementByXPath(
					"//textarea[@class='textarea textarea uiInput uiInputTextArea uiInput--default uiInput--textarea']")
					.sendKeys("Automation");
			reportStep("Successfully entered comments in New Task Window", "Pass");
		} catch (Exception e) {
			reportStep("Not able to enter comments in New Task Window", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage clickSaveInNewTaskWindow() throws IOException {
		try {
			getDriver().findElementByXPath("//button[@title='Save']").click();
			reportStep("Successfully Clicked save btn in NewTask Window", "Pass");
		} catch (Exception e) {
			reportStep("Not able to click save btn in NewTask Window", "Fail");
			e.printStackTrace();
		}
		return this;
	}

	public Homepage verifyErrorMsgInNewTaskWindow() throws IOException {
		try {

			WebElement Errormsg = driver
					.findElementByXPath("//li[text()='These required fields must be completed: Subject']");
			if (Errormsg.isDisplayed()) {
				System.out.println(
						"Tc passed & The required fields must be completed : subject error message is displaying ");
				reportStep("Successfully verified Error message", "Pass");
			} else {
				System.out.println("TC Failed & The error message is not displaying");
			}
		} catch (Exception e) {
			reportStep("Not able to verify Error message in NewTaskWindow", "Fail");
			e.printStackTrace();
		}
		return this;
	}

}
