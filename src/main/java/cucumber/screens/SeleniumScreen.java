package cucumber.screens;

import cucumber.client.ScreenObject;

import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumScreen extends ScreenObject {

    public SeleniumScreen(RemoteWebDriver driver) {
        super(driver);
        trait();
    }

    public void trait() {
        // todo: add trait
    }


}
