package cucumber.screens;

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

  public void trait() {}

  // todo: better exception handling
  public MobileElement getElement(String element) {
    MobileElement elem = null;

    try {
      Field field = getClass().getDeclaredField(element);
      field.setAccessible(true);
      elem = ((MobileElement) field.get(this));
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }

    Assert.assertNotNull(String.format("Element not found: %s", elem));

    return elem;
  }

  // todo: better exception handling
  public List<MobileElement> getElements(String elements) {
    List<MobileElement> elem = null;

    try {
      Field field = getClass().getDeclaredField(elements);
      field.setAccessible(true);
      elem = (List<MobileElement>) field.get(this);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }

    Assert.assertNotNull(String.format("Element not found: %s", elem));

    return elem;
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

  public void waitForListLoad(List<WebElement> elements, long timespan)
      throws InterruptedException {

    while (elements.isEmpty()) {
      Thread.sleep(timespan);
    }
  }
}
