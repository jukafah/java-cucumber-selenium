package cucumber.driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Factory {

  private final URL url;
  private final DesiredCapabilities desiredCapabilities;
  private final String platform;

  public Factory(String url, Map<String, Object> deviceMap) throws MalformedURLException {
    this.url = new URL(url);
    this.desiredCapabilities = new DesiredCapabilities(deviceMap);
    this.platform = desiredCapabilities.getCapability("platformName").toString();
  }

  public RemoteWebDriver createDriver() throws MalformedURLException {

    switch (platform.toUpperCase()) {
      case "ANDROID":
        return new AndroidDriver<MobileElement>(url, desiredCapabilities);
      case "IOS":
        return new IOSDriver<MobileElement>(url, desiredCapabilities);
      case "DESKTOP":
        return new RemoteWebDriver(url, desiredCapabilities);
      default:
        throw new IllegalArgumentException(
                String.format("Driver type not implemented: %s", platform));
    }
  }
}