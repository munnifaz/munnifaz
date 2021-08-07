package pages.selenium;

import java.io.IOException;
import java.util.Properties;
import com.aventstack.extentreports.ExtentTest;
import lib.selenium.BrowserActionsImpl;


public class LoginPage extends BrowserActionsImpl {

	public LoginPage(Properties prop,ExtentTest test, ExtentTest node) {
		this.prop = prop;
		this.test=test;
		this.node=node;
	}

	public LoginPage enterUserName(String Username) throws IOException {

		System.out.println("inside lognin page"+Username);
		try {
			type(locateElement("id",prop.getProperty("LoginPage.username.Id")),Username);
			
			//getDriver().findElementById(prop.getProperty("LoginPage.username.Id")).sendKeys(Username);
			reportStep("Username entered successfully", "Pass");

		} catch (Exception e) {
			reportStep("Username not entered successfully", "Fail");

			e.printStackTrace();
		}

		return this;
	}

	public LoginPage enterpassword(String Password) throws IOException {

		try {
			type(locateElement("id",prop.getProperty("LoginPage.password.Id")),Password);
			//getDriver().findElementById(prop.getProperty("LoginPage.password.Id")).sendKeys(Password);
			reportStep("Password entered successfully", "Pass");
		} catch (Exception e) {
			reportStep("Password not entered successfully", "Fail");
			e.printStackTrace();
		}

		return this;
	}

	public Homepage clickLogin() throws IOException {
		try {
			
			click(locateElement("id",prop.getProperty("LoginPage.Login.Name")));
			//getDriver().findElementByName(prop.getProperty("LoginPage.Login.Name")).click();
			reportStep("Login button clicked successfully", "Pass");
			Thread.sleep(10000);
		} catch (Exception e) {
			reportStep("Login button not clicked successfully", "Fail");
			e.printStackTrace();
		}
		return new Homepage(prop,node,wait,js);
	}

	}

