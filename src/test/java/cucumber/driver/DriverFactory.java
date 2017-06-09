package cucumber.driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class DriverFactory {

    private final String url;
    private final HashMap<String, Object> deviceMap;

    public DriverFactory(String url, HashMap<String, Object> deviceMap) {
        this.url = url;
        this.deviceMap = deviceMap;
    }


    public RemoteWebDriver createDriver() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(deviceMap);

        String platformName = desiredCapabilities
                .getCapability("platformName")
                .toString()
                .toUpperCase();

        switch (platformName) {
            case "ANDROID":
                return new AndroidDriver<MobileElement>(new URL(url), desiredCapabilities);
            case "IOS":
                return new IOSDriver<MobileElement>(new URL(url), desiredCapabilities);
            case "DESKTOP":
                return new RemoteWebDriver(new URL(url), desiredCapabilities);
            default:
                throw new IllegalArgumentException(String.format("Driver type note implemented: %s", platformName));
        }
    }
}