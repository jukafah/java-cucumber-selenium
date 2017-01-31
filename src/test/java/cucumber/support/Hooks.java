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

    @Before
    public void beforeScenario(Scenario scenario) {
//        System.out.println("beforeScenario");
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Steve\\Documents\\cucumber-selenium-master\\cucumber-selenium-master\\src\\main\\java\\helpers\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @After
    public void afterScenario(Scenario scenario) {
//        System.out.println("afterScenario");
        driver.quit();
    }
}
