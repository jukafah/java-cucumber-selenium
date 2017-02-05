package cucumber.support;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }


    @Before
    public void beforeScenario(Scenario scenario) {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @After
    public void afterScenario(Scenario scenario) {
        driver.quit();
    }
}
