package cucumber.screens;

import cucumber.client.ScreenObject;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class AppiumScreen extends ScreenObject {

  public AppiumScreen(RemoteWebDriver driver) {
    super(driver);
    trait();
  }

  public void trait() {
    Assert.assertTrue("Screen was not displayed!", trait.isDisplayed());
  }

  @FindBy(css = ".navbar .container-fluid .navbar-header .navbar-brand")
  private WebElement trait;
}