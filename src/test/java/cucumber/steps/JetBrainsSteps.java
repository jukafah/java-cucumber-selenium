package cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.screens.JetBrainsScreen;
import cucumber.support.Hooks;

public class JetBrainsSteps {

    private JetBrainsScreen screen;

    public JetBrainsSteps(Hooks hooks) {
        this.screen = new JetBrainsScreen(hooks.getDriver());
    }

    @Then("^the User views the JetBrains screen \"([^\"]*)\"$")
    public void theUserViewsTheJetBrainsScreen(String url) throws Throwable {
        screen.checkUrl(url);
    }
}
