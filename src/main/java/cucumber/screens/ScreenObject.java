package cucumber.screens;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

abstract class ScreenObject {

    private WebDriver driver;

    public ScreenObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public abstract void trait();
    public abstract WebElement getElement(String element);

    public void goTo(String destinationUrl) {
        driver.navigate().to(destinationUrl);
    }
    public void checkUrl(String expectedUrl) {
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
