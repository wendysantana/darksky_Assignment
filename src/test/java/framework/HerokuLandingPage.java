package framework;

import com.github.javafaker.Faker;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import stepdefinition.SharedSD;
import sun.jvm.hotspot.debugger.posix.elf.ELFException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;


public class HerokuLandingPage extends BasePage {

    private By searchBar = By.xpath("//input[@id='aa-search-input']");
    private By searchArea = By.cssSelector("#option-24838991");

    private By allPosts = By.xpath("//body/div[@class='container section']/div[@class='row']/div[//descendant::a]");
    private By postImages = By.xpath("//div[@class='container section']//img");
    private By postPrice = By.xpath("//div[@class='gig-card']//h3[1]");
    private By postTitle = By.xpath("//div[@class='container section']//h4");

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
    public void verifyNumberOfPosts(int posts) {
        int count = 0;
        List<WebElement> boxPosts = SharedSD.getDriver().findElements(allPosts);
        for (WebElement boxPost : boxPosts) {
            if (boxPost.isDisplayed())
                count++;
        }
        System.out.println("Number of posts displayed: " + count);
        Assert.assertTrue(count == posts);
    }

    @Step
    public void verifyPriceTag(int tagPricesPosted) {

            List<WebElement> priceTags = getListOfWebElements(postPrice);
            int tagsWithPrice = 0;
            int tagsWithoutPrice = 0;

            for (WebElement price : priceTags) {

                if (price.getText().length() > 2){
                    tagsWithPrice++;
                } else {
                    if (price.getText().length() <= 2)
                        tagsWithoutPrice++;
                }
            }
                System.out.println("Tags with price: " + tagsWithPrice);
                System.out.println("Tags without price: " + tagsWithoutPrice);
                System.out.println("Total tags: " + priceTags.size());

           //     Assert.assertTrue(tagsWithPrice+tagsWithoutPrice==priceTags.size());
                Assert.assertTrue(tagsWithPrice == tagPricesPosted);
        }

    @Step
    public void verifyTitles(int titlesPosted){
        int postWithoutTitles=0;
        int postWithTitles =0;

        List <WebElement> titles = getListOfWebElements(postTitle);
        for (WebElement title : titles){
            if (title.getText().isEmpty())
            postWithoutTitles++;
             else if (title.getText().length() >=1)
                postWithTitles++; }

        System.out.println("Post without titles: " + postWithoutTitles);
        System.out.println("Post with titles: " + postWithTitles);
        System.out.println("Total posts: " + titles.size());

    //    Assert.assertTrue(postWithoutTitles + postWithTitles == titles.size());
        Assert.assertTrue(postWithTitles == titlesPosted);

    }

    @Step
    public void verifyImageDisplayed(int imagesPosted){
        int imagesDisplayed = 0;
        int imagesNotDisplayed = 0;

        List<WebElement> images = getListOfWebElements(postImages);
        for (WebElement image:images){
            if (image.isDisplayed())
                imagesDisplayed++;
            else if (image.getText().isEmpty())
                imagesNotDisplayed++;
        }
        System.out.println("Tags with images: " + imagesDisplayed);
        System.out.println("Tags without images: " + imagesNotDisplayed);
        System.out.println("Total of images: " + images.size());
    //    Assert.assertTrue(imagesDisplayed + imagesNotDisplayed == images.size());
        Assert.assertTrue(imagesDisplayed == imagesPosted);

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
    public void clickSubmitRegistration() { clickOn(submitregistrationButton); }

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

        assertEquals(textLogout, "Logout");
    }


    //Scenario @heroku-search-5 below
    @Step
    public void clickSignInButton() { clickOn(signInButton); }

    @Step
    public void enterUsername(String username, String password) {
        clickOn(usernameTab);
        sendText(usernameTab, username);
        clickOn(passwordTab);
        sendText(passwordTab, password);
    }

    @Step
    public void enterSubmit() { clickOn(submitButton); }

    @Step
    public void verifyLogoutDisplayed() {
        clickOn(iconButton);

        String textLogout = getTextFromElement(logoutButton);
        System.out.println("Text: " + textLogout);

        assertEquals(textLogout, "Logout");

    }
}
