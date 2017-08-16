package cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.support.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CommonSteps {

  private WebDriver driver;

  public CommonSteps(Hooks hooks) {
    this.driver = hooks.getDriver();
  }

  @Given("^I am on \"(.*?)\"$")
  public void iAmOn(String url) throws Throwable {
    driver.get(url);
  }


}
