package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	WebDriver driver;

	public WebDriver init(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			return new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			return new FirefoxDriver();
		} else {
			return new EdgeDriver();
		}
	}

	@Given("User is opening the {string} in {string} browser")
	public void user_is_opening_the_in_browser(String url, String browserName) {
		System.out.println("1");

		driver = init(browserName);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Then("User will enter the {string} into {string}")
	public void user_will_enter_the_into(String string, String string2) {
		driver.findElement(By.xpath(string)).sendKeys(string2);
	}

	@When("User will click on {string}")
	public void user_will_click_on(String string) {
		System.out.println("2");
	}

	@And("User will verify the current page title is equal to {string}")
	public void user_will_verify_the_current_page_title_is_equal_to(String string) {
		System.out.println("4");
	}

	@Then("User will close the browser")
	public void user_will_close_the_browser() {
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
