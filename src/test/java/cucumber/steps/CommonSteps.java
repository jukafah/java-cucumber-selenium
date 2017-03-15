package cucumber.steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.pages.CommonPage;
import cucumber.support.Hooks;

public class CommonSteps {

    private CommonPage page;

    public CommonSteps(Hooks hooks)
    {
        this.page = new CommonPage(hooks.getDriver());
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
