package cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.screens.AppiumScreen;
import cucumber.support.Hooks;

public class AppiumSteps {

	private AppiumScreen screen;

	public AppiumSteps(Hooks hooks) {
		screen = new AppiumScreen(hooks.getDriver());
	}

	@Then("^the User views the Appium homepage \"([^\"]*)\"$")
	public void theUserViewsTheAppiumHomepage(String expectedUrl) throws Throwable {
		screen.checkUrl(expectedUrl);
	}

}