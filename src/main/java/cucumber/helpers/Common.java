package cucumber.helpers;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Common {

    private WebDriver driver;

    public Common(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    public void goTo(String url) {
        driver.navigate().to(url);
    }


    public void checkUrl(String expUrl) {
        Assert.assertEquals(expUrl, driver.getCurrentUrl());
    }
}
