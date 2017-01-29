package com.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.openqa.selenium.WebDriver;

import com.cucumber.pages.Homepage;

public class HomepageSteps {

	private Homepage page;
	private final WebDriver driver;
	
	public HomepageSteps(WebDriver driver)
	{
//		super(page.class);
//		super(Homepage.class);
		this.driver = driver;
		System.out.println("public Steps");
		page = new Homepage(this.driver);
	}
	
	@Given("^I am on \"(.*?)\"$")
	public void i_am_on(String url) throws Throwable {
	    page.goTo(url);
	}
	
	@Given("^I am on the tapQA homepage$")
	public void i_am_on_the_tapQA_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//		page.
	}

	@Then("^I see the header$")
	public void i_see_the_header(String header) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
	}
	
}


