package cucumber.support;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import cucumber.config.Config;
import cucumber.data.TestData;
import cucumber.driver.DriverFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hooks {

    private static boolean setup = false;
    private static Config config;
    private static TestData testData;
    private static DriverFactory factory;

    private RemoteWebDriver driver;

    public RemoteWebDriver getDriver() {
        return driver;
    }
    public TestData getTestData() {
        return testData;
    }

    // todo: add appium server configuration - tie driver and server
    @Before(order = 1)
    public void beforeAll() {

        if (!setup) {
            Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
            config = new Config();
            testData = new TestData(config.username);
            factory = new DriverFactory(config.url, config.deviceMap);
            setup = true;
        }
    }

    @Before(order = 2)
    public void beforeScenario() {

        try {
            driver = factory.createDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void afterScenario(Scenario scenario) {

        if (driver != null && scenario.isFailed()) {
            try {
                byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");

            } catch (WebDriverException webdriverException) {
                webdriverException.printStackTrace();
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }
}