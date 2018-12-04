package framework;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.List;


public class HerokuLandingPage extends BasePage {

    private By searchBar = By.xpath("//input[@id='aa-search-input']");
    private By searchArea = By.cssSelector("#option-24838991");

    private By allPosts = By.xpath("//div[@class='container section']//parent::div");
    private By postImages = By.xpath("//div[@class='row']//div[1]//descendant::a");
    private By postPrice = By.xpath("//div[@class='row']//div[//div[@class='row']//div[1]//descendant::a]//div[1]//h3[1]");

    private By joinButton = By.xpath("//a[@class='btn btn-success']");
    private By registrationName = By.xpath("//input[@name='username']");
    private By registrationEmail = By.xpath("//input[@name='email']");
    private By registrationPassword = By.xpath("//input[@name='password']");
    private By submitregistrationButton = By.xpath("//button[@type='submit']");
    private By registrationSubmitBox = By.xpath("//form[@role='form']");

    private By signInButton = By.cssSelector("nav.navbar.navbar-default.navbar-static-top:nth-child(1) div.container div.collapse.navbar-collapse ul.nav.navbar-nav.navbar-right li:nth-child(1) > a:nth-child(1)");
    private By usernameTab = By.xpath("//input[@id='email']");
    private By passwordTab = By.xpath("//input[@id='password']");
    private By submitButton = By.cssSelector("div.container:nth-child(2) div.row div.col-md-6.col-md-offset-3 form:nth-child(3) > button.btn.btn-success:nth-child(3)");
    private By iconButton = By.cssSelector("nav.navbar.navbar-default.navbar-static-top:nth-child(1) div.container div.collapse.navbar-collapse ul.nav.navbar-nav.navbar-right li.dropdown:nth-child(3) > a.dropdown-toggle");
    private By logoutButton = By.cssSelector("nav.navbar.navbar-default.navbar-static-top:nth-child(1) div.container div.collapse.navbar-collapse ul.nav.navbar-nav.navbar-right li.dropdown.open:nth-child(3) ul.dropdown-menu li:nth-child(3) > a:nth-child(1)");


    Faker fake = new Faker();

    //Scenario @heroku-search-1 below- just click title and verify title
    @Step
    public void enterSearchText(String enterSearch) {
        clickOn(searchBar);
        sendText(searchBar, enterSearch);
    }

    @Step
    public void verifyTitleSearch(String title) {
        Actions action = new Actions(SharedSD.getDriver());
        action.click((SharedSD.getDriver().findElement(searchArea)));
        String searchText = getTextFromElement(searchArea);
        System.out.println("Searched text:" + searchText);
    }

    //Scenario @heroku-search-2 below
    @Step
   public void verifyNumberOfPosts(int posts){
        int boxes = allPosts.toString().length();
        System.out.println("Textboxes: " + boxes);
        Assert.assertEquals(boxes,posts); }

    @Step
    public void verifyPriceTag() {
        int count =0;
        List<WebElement> images = SharedSD.getDriver().findElements(postPrice);
        for (WebElement image:images){
            if (image.isDisplayed())
                count++;
        }
        System.out.println("Price displayed: " + count);
    }


    @Step
    public void verifyImageDisplayed(){
        int count =0;
        List<WebElement> images = SharedSD.getDriver().findElements(postImages);
        for (WebElement image:images){
            if (image.isDisplayed())
                count++;
        }
        System.out.println("Images displayed: " + count);

    }


    //Scenario @heroku-search-3 below
    @Step
    public void registrationPage() { clickOn(joinButton); }

    @Step
    public void enterRegistrationInfo(String registerName, String registerEmail, String registerPassword) {
        clickOn(registrationName);
        sendText(registrationName, registerName);
        clickOn(registrationEmail);
        sendText(registrationEmail, registerEmail);
        clickOn(registrationPassword);
        sendText(registrationPassword, registerPassword);
    }

    @Step
    public void clickSubmitRegistration() {
        clickOn(submitregistrationButton); }

    @Step
    public void verifyInvalidEmail()throws InterruptedException{
        clickOn(submitregistrationButton);
        Thread.sleep(1000);
        hoverOver(registrationSubmitBox);
        Thread.sleep(1000);
        String alertText = getAlert();
        Assert.assertFalse(alertText.isEmpty()); }


    //Scenario @heroku-search-4 below
    @Step
    public void enterCredentials(String registerName, String registerPassword) {
        String email =fake.internet().emailAddress();
        System.out.println("Email: " + email);

        clickOn(registrationName);
        sendText(registrationName, registerName);
        clickOn(registrationEmail);
        sendText(registrationEmail,email);
        clickOn(registrationPassword);
        sendText(registrationPassword, registerPassword); }

    @Step
    public void verifyNewUserRegister(){
        clickOn(iconButton);

        String textLogout = getTextFromElement(logoutButton);
        System.out.println("Text: " + textLogout);

        Assert.assertEquals(textLogout, "Logout");
    }


    //Scenario @heroku-search-5 below
    @Step
    public void clickSignInButton() {
        clickOn(signInButton);
    }

    @Step
    public void enterUsername(String username, String password) {
        clickOn(usernameTab);
        sendText(usernameTab, username);
        clickOn(passwordTab);
        sendText(passwordTab, password);
    }

    @Step
    public void enterSubmit() {
        clickOn(submitButton);
    }

    @Step
    public void verifyLogoutDisplayed() {
        clickOn(iconButton);

        String textLogout = getTextFromElement(logoutButton);
        System.out.println("Text: " + textLogout);

        Assert.assertEquals(textLogout, "Logout");

    }

}

