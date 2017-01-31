package cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    private WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void goTo(String url) {
    	driver.navigate().to(url);
    }

    public void checkHeader(String content) {
        Assert.assertEquals(content, header.getText());
    }

    @FindBy(css = ".fusion-column-wrapper i")
    private WebElement header;
}
