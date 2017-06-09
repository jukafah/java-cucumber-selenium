package cucumber.screens;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchScreen extends ScreenObject {

    private WebDriver driver;

    public SearchScreen(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    // todo: implement pattern
    @Override
    public void trait() {

    }

    public void searchFor(String searchText)
    {
        searchBox.clear();
        searchBox.sendKeys(searchText);
        searchBox.submit();
    }

    // todo: make better - avoid nullables
    public void selectResult(String expResult) {
        WebElement elem = findResult(expResult);
        Assert.assertNotNull(String.format("Link not found for %s", expResult), elem);
        elem.click();
    }

    // todo: make better - avoid nullables
    private WebElement findResult(String expResult) {
        for (WebElement elem : searchResults) {
            if (elem.getText().toUpperCase().contains(expResult.toUpperCase()))
            {
                return elem;
            }
        }
        return null;
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
