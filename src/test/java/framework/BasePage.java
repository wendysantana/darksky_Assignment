package framework;

import cucumber.api.java.ca.I;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import stepdefinition.SharedSD;

import java.util.List;

/**
 * Created by mohammadmuntakim on 6/9/17.
 */
public class BasePage {

	public void clickOn(By locator) {
		try {
			SharedSD.getDriver().findElement(locator).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public void sendText(By locator, String text) {
		try {
			SharedSD.getDriver().findElement(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public List<WebElement> getListOfWebElements(By locator) {
		return SharedSD.getDriver().findElements(locator);
	}

	public String getTextFromElement(By locator) {
		String text = null;
		try {
			text = SharedSD.getDriver().findElement(locator).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}

		return text;
	}

	public void selectDropDown(By locator, int index) {
		WebElement mySelectElement = SharedSD.getDriver().findElement(locator);
		Select dropdown = new Select(mySelectElement);
		dropdown.selectByIndex(index); }

	public String selectDropDownGetText(By locator, int index) {
		WebElement mySelectElement = SharedSD.getDriver().findElement(locator);
		Select dropdown = new Select(mySelectElement);
		dropdown.selectByIndex(index);
		return null; }

    public boolean isDisplayed (By locator) {
        WebElement mySelectElement = SharedSD.getDriver().findElement(locator);
        mySelectElement.isDisplayed();
        return false; //THIS DISPLAY MAY NOT WORK-CHECK METHOD
    }

    public void hoverOver (By locator)throws InterruptedException {
	    WebElement mySelectElement = SharedSD.getDriver().findElement(locator);
        Actions action = new Actions(SharedSD.getDriver());
		Thread.sleep(1000);
        action.moveToElement(mySelectElement).build().perform();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait((WebDriver) mySelectElement, 15);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.alertIsPresent());}


    public String getAlert ()throws InterruptedException {
       Alert alert = SharedSD.getDriver().switchTo().alert();
       Thread.sleep(1000);
        String alertMessage = SharedSD.getDriver().switchTo().alert().getText();
        Thread.sleep(1000);
        System.out.println(alertMessage);
        Thread.sleep(1000);
        alert.accept();
		return alertMessage;

//  Alerts(alert messages and pop up messages)-https://www.guru99.com/alert-popup-handling-selenium.html
    }

	public void scroll() {
		JavascriptExecutor jse = (JavascriptExecutor)SharedSD.getDriver();
		jse.executeScript("window.scrollBy(0,600");}
		//  Thread.sleep(10000);


	public void clearText(By locator) {
		SharedSD.getDriver().findElement(locator).clear();
	}

	public void clickOnBrowserBackArrow() {
		SharedSD.getDriver().navigate().back();
	}

	public void clickOnBrowserForwardArrow() {
		SharedSD.getDriver().navigate().forward();
	}

	public void refreshBrowser() {
		SharedSD.getDriver().navigate().refresh();
	}
}
