package cucumber.support;

import cucumber.config.Config;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {

    private WebDriver driver;
    private String nodejsPath = "user/local/bin";
    private String appiumPath = "SET_ME";
    private AppiumDriverLocalService server;
    private AppiumDriver<WebElement> appiumDriver;

    public WebDriver getDriver() {
        return driver;
    }


    @Before
    public void beforeScenario(Scenario scenario) {

        Config config = new Config();

        try {

            System.setProperty(AppiumServiceBuilder.NODE_PATH,
                    this.nodejsPath);

            System.setProperty(AppiumServiceBuilder.APPIUM_PATH,
                    this.appiumPath);

            server = AppiumDriverLocalService.buildDefaultService();
            server.start();

            URL url = new URL(config.url);
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "GalaxyS7");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);

            driver = new AndroidDriver<WebElement>(url, caps);

        } catch (MalformedURLException ex) {

            throw new RuntimeException(ex);

        }

//        @TODO: Add in web implementation
//        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @After
    public void afterScenario(Scenario scenario) {
        if (driver != null)
        {
            driver.quit();
        }

        if (server != null) {
            server.stop();
        }
    }
}
