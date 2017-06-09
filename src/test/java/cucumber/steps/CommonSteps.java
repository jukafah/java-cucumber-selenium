package cucumber.steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.support.Hooks;
import org.openqa.selenium.WebDriver;

public class CommonSteps {

    private WebDriver driver;

    public CommonSteps(Hooks hooks)
    {
        this.driver = hooks.getDriver();
    }

    @Given("^I am on \"(.*?)\"$")
    public void i_am_on(String url) throws Throwable {
//        screen.goTo(url);
        driver.get(url);
    }


    @Then("^I am presented with the \"([^\"]*)\" homepage$")
    public void i_am_presented_with_the_homepage(String expUrl) throws Throwable {
//        screen.checkUrl(expUrl);
    }

}
