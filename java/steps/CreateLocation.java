package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLocation extends Baseclass {

	public String Location;
	public String Locationtypebasecls;

	@When("click App Launcher")
	public void click_app_launcher() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

	}

	@When("click viewAll")
	public void click_view_all() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ViewAllbutton = driver.findElement(By.xpath("(//button[text()='View All'])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(ViewAllbutton));
		ViewAllbutton.click();

	}

	@When("click locations")
	public void click_locations() {
		driver.findElementByXPath("//input[@class='slds-input']").sendKeys("Locations");
		driver.findElementByXPath("//mark[text()='Locations']").click();
	}

	@When("click new in Location page")
	public void click_new_in_location_page() {
		driver.findElementByXPath("//a[@title='New']").click();
	}

	@When("Enter Location Name")
	public void enter_location_name() {

		driver.findElementByXPath("(//input[@class=' input'])[1]").sendKeys("Sydney");
		Location = "Sydney";
	}

	@When("Enter Location Type")
	public void enter_location_type() {
		driver.findElementByXPath("//a[@class='select']").click();
		driver.findElementByXPath("//a[@title='Plant']").click();

	}

	@When("Enter the External Reference")
	public void enter_the_external_reference() {
		driver.findElementByXPath("(//input[@class=' input'])[2]").sendKeys("Ref");

	}

	@When("Click on save")
	public void click_on_save() {
		driver.findElementByXPath("//button[@title='Save']").click();
	}

	@Then("Verify the location created")
	public void verify_the_location_created() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement msg = driver.findElementByXPath("//div[@data-key='success']");
		wait.until(ExpectedConditions.elementToBeClickable(msg));
		if (msg.isDisplayed()) {

			System.out.println("Location created");
		} else {
			System.out.println("Location is not created");
		}
	}

	@When("^click edit on location$")
	public void click_edit_on_location() {
		driver.findElementByXPath("//a[@title='Show 5 more actions']").click();
		driver.findElementByXPath("//a[@title='Edit']").click();

	}

	@When("change the location type to Building as {string}")
	public void change_the_location_type_to_building(String Locationtype) {
		driver.findElementByXPath("//a[@class='select']").click();
		driver.findElementByXPath("//a[@title='" + Locationtype + "']").click();
		Locationtypebasecls = Locationtype;

	}

	@When("Get the text of last modified by and seperate the text from it")
	public void get_the_text_of_last_modified_by_and_seperate_the_text_from_it() {
		WebElement lastmodifiedbyele = driver.findElementByXPath(
				"(//span[@class='test-id__field-value slds-form-element__static slds-grow  is-read-only'])[5]");
		String lastmodified = lastmodifiedbyele.getText();
		System.out.println(lastmodified);
		String[] arrSplit = lastmodified.split(",");
		for (int i = 0; i < arrSplit.length; i++) {
			System.out.println(arrSplit[i]);
		}
	}

	@When("click on save")
	public void click_on_save1() {
		driver.findElementByXPath("//button[@title='Save']").click();

	}

	@Then("Verify the location type is updated")
	public void verify_the_location_type_is_updated() throws InterruptedException {
		Thread.sleep(2000);
		WebElement locationtypeele = driver
				.findElementByXPath("(//span[contains(@class,'test-id__field-value slds-form-element__static')])[3]");
		String locationtype = locationtypeele.getText();
		if (locationtype.equalsIgnoreCase(Locationtypebasecls)) {
			System.out.println("Location updated");
		} else {
			System.out.println("Location not updated");
		}

	}

	@When("Select Delete on location")
	public void select_delete_on_location() {
		driver.findElementByXPath("//a[@title='Show 5 more actions']").click();
		driver.findElementByXPath("//a[@title='Delete']").click();
		
	}

	@When("Click Delete on Upcoming popup")
	public void click_delete_on_upcoming_popup() {
		WebElement Popup=driver.findElementByXPath("//button[@title='Delete']");
		Popup.click();		
	}

	@Then("Verify the location is deleted")
	public void verify_the_location_is_deleted() {
		WebElement deletemsg=driver.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
		if(deletemsg.isDisplayed()) {
			System.out.println("Location successfully deleted");}
		else {
			System.out.println("Location successfully not deleted");
		}
		
	}
}
