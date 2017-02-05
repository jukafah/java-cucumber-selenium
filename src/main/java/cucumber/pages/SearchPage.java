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
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String target)
    {
        searchBox.clear();
        searchBox.sendKeys(target);
        searchBox.submit();
    }

    @FindBy(css = "#lst-ib")
    private WebElement searchBox;

    @FindBy(css = "#ires .g .r a")
    private List<WebElement> searchResults;
}
