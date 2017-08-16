package cucumber.screens;

import java.util.List;

import cucumber.client.ScreenObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class GoogleScreen extends ScreenObject {

  public GoogleScreen(RemoteWebDriver driver) {
    super(driver);
    trait();
  }

  public void trait() {
    Assert.assertTrue("Screen was not displayed!", trait.isDisplayed());
  }

  public void searchFor(String searchText) {
    searchBox.sendKeys(searchText);
    searchBox.submit();
  }

  public void selectResult(String expResult) throws InterruptedException {
    waitForListLoad(searchResults);

    searchResults
        .stream()
        .filter(item -> item.getText().contains(expResult))
        .findFirst()
        .orElse(null)
        .click();
  }

  @FindBy(id = "hplogo")
  private WebElement trait;

  @FindBy(css = "#lst-ib")
  private WebElement searchBox;

  @FindBy(css = "#ires .g .r a")
  private List<WebElement> searchResults;
}
