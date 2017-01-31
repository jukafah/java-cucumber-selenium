package cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.pages.Homepage;
import cucumber.support.Hooks;

public class HomepageSteps {

	private Homepage page;

	public HomepageSteps(Hooks hooks) {
		page = new Homepage(hooks.getDriver());
	}

	@Given("^I am on \"(.*?)\"$")
	public void i_am_on(String url) throws Throwable {
		page.goTo(url);
	}

	@Then("^I see the header$")
	public void i_see_the_header(String content) throws Throwable {
		page.checkHeader(content);
	}
}


