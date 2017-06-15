package cucumber.screens;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleScreen extends ScreenObject {

    private WebDriver driver;

    public GoogleScreen(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

        trait();
    }

    @Override
    public void trait() {
        Assert.assertEquals("https://www.google.com", driver.getCurrentUrl().substring(0, 22));
    }

    public void searchFor(String searchText)
    {
        searchBox.clear();
        searchBox.sendKeys(searchText);
        searchBox.submit();
    }

    public void selectResult(String expResult) throws InterruptedException {

        boolean isFound = false;
        waitForListLoad(searchResults, 10000);

        for (WebElement elem : searchResults) {

            if (elem.getText().contains(expResult)) {
                elem.click();
                isFound = true;
                break;
            }
        }

        Assert.assertTrue(String.format("Did not find expected result: %s", expResult), isFound);
    }

    @Override
    public WebElement getElement(String element) {

        switch(element.toUpperCase()) {
            case "SEARCH BOX":
                return searchBox;
            default:
                throw new IllegalArgumentException(String.format("Element not implemented: %s", element));
        }
    }

    @FindBy(css = "#lst-ib")
    private WebElement searchBox;

    @FindBy(css = "#ires .g .r a")
    private List<WebElement> searchResults;
}
