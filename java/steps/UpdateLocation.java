package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateLocation extends Baseclass {

	/*
	 * @When("click App Launcher") public void click_app_launcher() {
	 * driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	 * 
	 * }
	 * 
	 * @When("click viewAll") public void click_view_all() { WebDriverWait wait =
	 * new WebDriverWait(driver, 30); WebElement ViewAllbutton =
	 * driver.findElement(By.xpath("(//button[text()='View All'])[2]"));
	 * wait.until(ExpectedConditions.elementToBeClickable(ViewAllbutton));
	 * ViewAllbutton.click(); }
	 * 
	 * @When("click locations") public void click_locations() {
	 * driver.findElementByXPath("//input[@class='slds-input']").sendKeys(
	 * "Locations");
	 * driver.findElementByXPath("//mark[text()='Locations']").click(); }
	 * 
	 * @When("search location created in Tc001") public void
	 * search_location_created_in_tc001() {
	 * //driver.findElementByXPath("//input[@name='Location-search-input']").
	 * sendKeys(Location);
	 * driver.findElementByXPath("//input[@name='Location-search-input']").click();
	 * 
	 * }
	 * 
	 * @When("click edit on location") public void click_edit_on_location() {
	 * driver.findElementByXPath("//table//tbody//tr[1]//td[4]//span//div//a").click
	 * (); driver.findElementByXPath("//a[@title='Edit']").click();
	 * 
	 * }
	 * 
	 * @When("change the location type to Building as {string}") public void
	 * change_the_location_type_to_building(String Locationtype) {
	 * driver.findElementByXPath("//a[@class='select']").click();
	 * driver.findElementByXPath("//a[@title='" + Locationtype + "']").click(); //
	 * Locationtypebasecls = Locationtype;
	 */
	//}
/*
	@When("Get the text of last modified by and seperate the text from it")
	public void get_the_text_of_last_modified_by_and_seperate_the_text_from_it() {
		WebElement lastmodifiedbyele = driver.findElementByXPath("(//span[@class='uiOutputDateTime'])[2]");
		String lastmodified = lastmodifiedbyele.getText();
		String[] arrSplit = lastmodified.split(", ");
		for (int i = 0; i < arrSplit.length; i++) {
			System.out.println(arrSplit[i]);
		}
	}

	@When("click on save")
	public void click_on_save() {
		driver.findElementByXPath("//button[@title='Save']").click();

	}

	@Then("Verify the location type is updated")
	public void verify_the_location_type_is_updated() {

		WebElement locationtypeele = driver.findElementByXPath("(//table//tbody//tr[1]//td[3]//span//span)[1]");
		String locationtype = locationtypeele.getText();
		if (locationtype.equalsIgnoreCase("Locationtypebasecls")) {
			System.out.println("Location updated");
		} else {
			System.out.println("Location not updated");
		}

	}*/
}