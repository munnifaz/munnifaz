package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login extends Baseclass {

	@Given("Enter the username as {string}")
	public void EnterUsername(String username) {
		driver.findElementById("username").sendKeys(username);
	}
	
	@Given("Enter the password as {string}")
	public void EnterPassword(String password) {
		driver.findElementById("password").sendKeys(password);
	
	}
	
	@When("click Login Button")
	public void clickLoginButton() {
		driver.findElementByName("Login").click();
	}
	
	
	@Then("Verify home page is displayed")
	public void Verifyhomepageisdisplayed () throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, 100);
		//wait.until(ExpectedConditions.titleContains(driver.getTitle()));
		Thread.sleep(10000);
		if (driver.getTitle().contains("Home")) {
			System.out.println("Home page displayed");
		}

		else {

			System.out.println("Home page not displayed");
		}
	}
	}


