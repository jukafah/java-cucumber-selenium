package com.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.pages.Homepage;

public class HomepageSteps {

	private final WebDriver driver = new ChromeDriver();

	@Given("^I am on \"(.*?)\"$")
	public void i_am_on(String url) throws Throwable {
		driver.navigate().to(url);
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
}


