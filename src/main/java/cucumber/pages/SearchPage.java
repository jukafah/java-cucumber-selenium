package cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void searchFor(String searchText)
    {
        searchBox.clear();
        searchBox.sendKeys(searchText);
        searchBox.submit();
    }

    public void selectResult(String expResult) {
        WebElement elem = findResult(expResult);
        Assert.assertNotNull(String.format("Link not found for %s", expResult), elem);
        elem.click();
    }

    private WebElement findResult(String expResult) {
        for (WebElement elem : searchResults) {
            if (elem.getText().toUpperCase().contains(expResult.toUpperCase()))
            {
                return elem;
            }
        }
        return null;
    }

    @FindBy(css = "#lst-ib")
    private WebElement searchBox;

    @FindBy(css = "#ires .g .r a")
    private List<WebElement> searchResults;
}
