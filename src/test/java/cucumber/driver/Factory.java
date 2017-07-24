package cucumber.driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Factory {

  private final DesiredCapabilities desiredCapabilities;
  private final URL remoteAddress;
  private RemoteWebDriver driver;

  public Factory(String url, Map<String, Object> deviceMap) throws Throwable {
    this.remoteAddress = new URL(url);
    this.desiredCapabilities = new DesiredCapabilities(deviceMap);
  }

  public RemoteWebDriver createDriver() throws Throwable {

    String platformName =
        desiredCapabilities.getCapability("platformName").toString().toLowerCase();

    try {
      Method method = getClass().getMethod(platformName);
      return (RemoteWebDriver)method.invoke(this);

    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
      throw e;
    }

  }

  private AndroidDriver<MobileElement> android() {
    return new AndroidDriver<MobileElement>(remoteAddress, desiredCapabilities);
  }

  public IOSDriver<MobileElement> ios() {
    return new IOSDriver<MobileElement>(remoteAddress, desiredCapabilities);
  }

  private RemoteWebDriver desktop() {
    return new RemoteWebDriver(remoteAddress, desiredCapabilities);
  }
}
