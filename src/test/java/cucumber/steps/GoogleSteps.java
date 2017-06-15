package cucumber.steps;

import cucumber.api.java.en.When;

import cucumber.screens.GoogleScreen;
import cucumber.support.Hooks;

public class GoogleSteps {

	private GoogleScreen screen;

	public GoogleSteps(Hooks hooks) {
		screen = new GoogleScreen(hooks.getDriver());
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String target) throws Throwable {
		screen.searchFor(target);
	}

	@When("^select \"([^\"]*)\" in the search results$")
	public void select_in_the_search_results(String expResult) throws Throwable {
		screen.selectResult(expResult);
	}

}


