package cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.screens.AppiumScreen;
import cucumber.support.Hooks;

public class AppiumSteps {

  private AppiumScreen screen;

  public AppiumSteps(Hooks hooks) {
    this.screen = new AppiumScreen(hooks.getDriver());
  }

  @Then("^the User views the Appium screen \"([^\"]*)\"$")
  public void theUserViewsTheAppiumScreen(String url) throws Throwable {
    screen.checkUrl(url);
  }
}