package cucumber.screens;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AppiumScreen extends ScreenObject {

    private WebDriver driver;

    public AppiumScreen(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    
    @Override
    public void trait() {

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
