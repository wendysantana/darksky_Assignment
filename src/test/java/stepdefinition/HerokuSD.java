package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HerokuLandingPage;

public class HerokuSD {
    private HerokuLandingPage landingPage = new HerokuLandingPage();


    //Scenario @heroku-search-1 below
    @When("^I search on top search bar with text (.+)$")
    public void enterSearch (String enterSearch)
    { landingPage.enterSearchText(enterSearch); }

    @Then("^I verify (.+) as displayed result$")
    public void verifyResult (String title){ landingPage.verifyTitleSearch(title);}
//  (String text)throws InterruptedException{landingPage.verifyTitle(text);}
    

    //Scenario @heroku-search-3 below
    @Given("^I am on Registration page$")
    public void registerPage (){landingPage.registrationPage();}

    @When("^I enter name as (.+), email as (.+) and password as (.+)$")
    public void enterRegistration (String registerName, String registerEmail, String registerPassword)
    {landingPage.enterRegistrationInfo(registerName, registerEmail, registerPassword);}

    @And("^I click submit button$")
    public void registerSubmit (){landingPage.clickSubmitRegistration();}

    @Then("^I verify invalid email address$")
    public void verifyEmail(String text)throws InterruptedException{landingPage.verifyInvalidEmail(text);}



    //Scenario @heroku-search-5 below
    @Given("^I am on Heroku home page$")
    public void homePage (){}

    @Given("^User is on the Threely login page$")
    public void clickSignIn(){landingPage.clickSignInButton();}

    @When("^I enter username as (.+) and password as (.+)$")
    public void enterUser(String username, String password){landingPage.enterUsername(username, password);}

    @And("^I click on submit button$")
    public void clickSubmitButton (){landingPage.enterSubmit();}

    @Then("^I verify logout button is displayed$")
    public void verifyDisplay(){landingPage.verifyLogoutDisplayed();}

}
