package stepdefinition;

import cucumber.api.java.cs.A;
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

    //Scenario @heroku-search-2 below
    @Then("^I verify (.+) total post is displayed$")public void verifyPosts(int posts){landingPage.verifyNumberOfPosts(posts);}

    @And("^I verify (.+) post has price tag$") public void verifyPrice(int tagPricesPosted){landingPage.verifyPriceTag(tagPricesPosted);}

    @And("^I verify (.+) post has title$") public void verifyTitle(int titlesPosted){landingPage.verifyTitles(titlesPosted);}

    @And("^I verify (.+) post has displayed image$") public void verifyImage(int imagesPosted){landingPage.verifyImageDisplayed(imagesPosted);}



    //Scenario @heroku-search-3 below
    @Given("^I am on Registration page$")
    public void registerPage (){landingPage.registrationPage();}

    @When("^I enter name as (.+) email as (.+) and password as (.+)$")
    public void enterRegistration (String registerName, String registerEmail, String registerPassword)
    {landingPage.enterRegistrationInfo(registerName, registerEmail, registerPassword);}

    @And("^I click submit button$")
    public void registerSubmit (){landingPage.clickSubmitRegistration();}

    @Then("^I verify invalid email address$")
    public void verifyEmail()throws InterruptedException{landingPage.verifyInvalidEmail();}


    //Scenario @heroku-search-4 below
    @When("^I enter name as (.+) email as random email password as (.+) for new user$")
    public void enterInformation(String registerName, String registerPassword){landingPage.enterCredentials(registerName,registerPassword);}

    @Then("^I am signed-in as a new user$") public void verifyNewUser(){landingPage.verifyNewUserRegister();}


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
