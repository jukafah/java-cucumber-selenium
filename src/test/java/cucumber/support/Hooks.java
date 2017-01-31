package cucumber.support;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    //  TODO: driver configuration for appium and selenium
    @Before
    public void beforeScenario(Scenario scenario) {
        driver = new ChromeDriver();
    }


    @After
    public void afterScenario(Scenario scenario) {
        driver.quit();
    }
}
