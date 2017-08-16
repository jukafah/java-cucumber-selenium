package cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.screens.SeleniumScreen;
import cucumber.support.Hooks;

public class SeleniumSteps {

  private SeleniumScreen screen;

  public SeleniumSteps(Hooks hooks) {
    this.screen = new SeleniumScreen(hooks.getDriver());
  }

  @Then("^the User views the Selenium screen \"([^\"]*)\"$")
  public void theUserViewsTheSeleniumScreen(String url) throws Throwable {
    screen.checkUrl(url);
  }
}
