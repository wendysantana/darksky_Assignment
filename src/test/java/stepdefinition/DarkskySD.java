package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DarkSkyLandingPage;
import org.junit.Assert;

public class DarkskySD {

    private DarkSkyLandingPage landingPage = new DarkSkyLandingPage();

    @Given("^I am on Darksky home page$")

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyTemp() {
        landingPage.verifyHours();
    }

    @When("^I expand todays timeline$")
    public void expandTimelines() {
        landingPage.expandTimeline();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyTemps() {landingPage.verifyTempsAreEqual();
    }
}

