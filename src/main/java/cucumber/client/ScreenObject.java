package cucumber.client;

import cucumber.utility.Utility;
import io.appium.java_client.MobileElement;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class ScreenObject {

  private RemoteWebDriver driver;

  public ScreenObject(RemoteWebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(this.driver, this);
  }

  public MobileElement getElement(String element) {

    String target = Utility.toCamelCase(element);

    try {
      Field field = getClass().getDeclaredField(target);
      field.setAccessible(true);
      return ((MobileElement) field.get(this));
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new IllegalArgumentException(String.format("Element not found: %s", target));
    }
  }

  public void goTo(String destinationUrl) {
    driver.navigate().to(destinationUrl);
  }

  public void checkUrl(String expectedUrl) {
    Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
  }

  public void enterText(String element, String text) {
    getElement(element).sendKeys(text);
  }

  public void tapOn(String target) {
    getElement(target).click();
  }

  public void waitForListLoad(List<WebElement> elements) {
    long currentTime = System.currentTimeMillis();
    long endTime = currentTime + 10000;

    while (currentTime < endTime) {
      if (!elements.isEmpty()) break;
    }
  }
}
