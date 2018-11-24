package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DarkSkyLandingPage;

public class DarkskySD {

    private DarkSkyLandingPage landingPage = new DarkSkyLandingPage();

    @Given("^I am on Darksky home page$")

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyTemp(){landingPage.getCurrentTime();}

    @When("^I expand todays timeline$")
    public void expandTimeline(){}

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyRange (){landingPage.verifyTempRange();}

    }


