package cucumber.support;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import cucumber.config.Config;

import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.util.concurrent.TimeUnit;

public class Hooks {

    private WebDriver driver;
    private String nodejsPath;
    private String appiumMainPath;
    private AppiumDriverLocalService service;
    private AppiumDriver<WebElement> appiumDriver;

    public WebDriver getDriver() {
        return driver;
    }


    @Before
    public void beforeScenario(Scenario scenario) {

        Config config = new Config();

        try {
            System.setProperty(AppiumServiceBuilder.NODE_PATH,
            "usr/local/bin");

            System.setProperty(AppiumServiceBuilder.APPIUM_PATH,
            "the path to the desired appium.js or main.js");

            URL url = new URL(config.url);
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
            driver = new AndroidDriver<WebElement>(url, caps);

        } catch (MalformedURLException ex) {

            throw new RuntimeException(ex);

        }


        // TODO: Set paths


//        TODO: build and start appium server
//        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
//        service.start();
//        service.stop();

        // TODO: build out driver select method
//        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @After
    public void afterScenario(Scenario scenario) {
        driver.quit();
    }
}
