package cucumber.screens;

import io.appium.java_client.pagefactory.WithTimeout;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class AppiumScreen extends ScreenObject {

  public AppiumScreen(RemoteWebDriver driver) {
    super(driver);
    trait();
  }

  @Override
  public void trait() {
    Assert.assertTrue("Screen was not displayed!", trait.isDisplayed());
  }

//  @WithTimeout(time = 15, unit = TimeUnit.SECONDS)
  @FindBy(css = ".navbar .container-fluid .navbar-header .navbar-brand")
  private WebElement trait;
}