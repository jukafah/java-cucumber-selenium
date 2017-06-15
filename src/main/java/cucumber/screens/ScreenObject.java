package cucumber.screens;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

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

//    public void enterText(WebElement elem, String text) {
//        elem.sendKeys(text);
//    }
//
//    public void tapOn(List<WebElement> elems, String target) {
//
//        for (WebElement elem : elems) {
//            if (elem.getText().contains(target)) {
//                elem.click();
//            }
//        }
//    }
//
//    public void tapOn(String target) {
//        WebElement element = getElement(target);
//        element.click();
//    }

    public void waitForListLoad(List<WebElement> elements, long timespan) throws InterruptedException {

        while (elements.isEmpty()) {
            Thread.sleep(1000);
        }

    }
}
