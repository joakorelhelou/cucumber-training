package cucumber_core;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {

	WebDriver driver = null;

	@Before
	public void testSetUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}

	@Given("^I am on the zoo website$")
	public void navigateToZooWebsite() {
		driver.navigate().to("http://thetestroom.com/webapp/");
	}

	@When("^populate the contact form$")
	public void populateContactForm(DataTable table) {

		List<List<String>> data = table.raw();

		driver.findElement(By.name("name_field")).sendKeys(data.get(1).get(1));
		driver.findElement(By.name("address_field")).sendKeys(
				data.get(2).get(1));
		driver.findElement(By.name("postcode_field")).sendKeys(
				data.get(3).get(1));
		driver.findElement(By.name("email_field")).sendKeys(data.get(4).get(1));
		driver.findElement(By.id("submit_message")).click();

	}

	@When("^I navigate to \"([^\"]*)\"$")
	public void navigateTo(String link) {
		driver.findElement(By.id(link)).click();
	}

	@Then("^I check page title is \"([^\"]*)\"$")
	public void checkPageTitle(String pageTitle) {
		Assert.assertTrue("Failed : not in \"" + pageTitle
				+ "\" page. Page Name is " + driver.getTitle(), driver
				.getTitle().contains(pageTitle));
	}
	
	@After
	public void tearDown(){
		driver.close();
	}

}
