package cucumber.steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.helpers.Common;
import cucumber.support.Hooks;

public class CommonSteps {

    private Common page;

    public CommonSteps(Hooks hooks)
    {
        page = new Common(hooks.getDriver());
    }


    @Given("^I am on \"(.*?)\"$")
    public void i_am_on(String url) throws Throwable {
        page.goTo(url);
    }


    @Then("^I am presented with the \"([^\"]*)\" homepage$")
    public void i_am_presented_with_the_homepage(String expUrl) throws Throwable {
        page.checkUrl(expUrl);
    }

}
