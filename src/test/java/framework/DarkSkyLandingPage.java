package framework;

import org.junit.Assert;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DarkSkyLandingPage extends BasePage {

//   private String twoIncrement = "//div[@id='timeline']//div[@class='hours']//span[3]";
    private By twoHourIncrement = By.xpath("//div[@id='timeline']//div[@class='hours']//span[3]");
    private By fourHourIncrement = By.xpath("//div[@id='timeline']//div[@class='hours']//span[5]");
    private By sixHourIncrement = By.xpath("//div[@id='timeline']//div[@class='hours']//span[7]");
    private By eightHourIncrement = By.xpath("//div[@id='timeline']//div[@class='hours']//span[9]");
    private By tenHourIncrement = By.xpath("//div[@id='timeline']//div[@class='hours']//span[11]");
    private By twelveHourIncrement = By.xpath("//div[@id='timeline']//div[@class='hours']//span[13]");
    private By fourteenHourIncrement = By.xpath("//div[@id='timeline']//div[@class='hours']//span[15]");
    private By sixteenHourIncrement = By.xpath("//div[@id='timeline']//div[@class='hours']//span[17]");
    private By eighteenHourIncrement = By.xpath("//div[@id='timeline']//div[@class='hours']//span[19]");
    private By twentyHourIncrement = By.xpath("//div[@id='timeline']//div[@class='hours']//span[21]");
    private By twentytwoHourIncrement = By.xpath("//div[@id='timeline']//div[@class='hours']//span[23]");

    private By expandTimelineButton = By.xpath("//div[@id='week']//a[1]//span[2]//span[2]");
    private By lowTemp = By.cssSelector("body.forecast:nth-child(2) div.center:nth-child(7) a.day.revealed:nth-child(2) span.tempRange:nth-child(2) > span.minTemp");
    private By highTemp = By.cssSelector("body.forecast:nth-child(2) div.center:nth-child(7) a.day.revealed:nth-child(2) span.tempRange:nth-child(2) > span.maxTemp");
    private By lowExpandTemp = By.cssSelector("body.forecast:nth-child(2) div.center:nth-child(7) div.dayDetails.revealed:nth-child(3) div.summary_container div.dayExtras div.highLowTemp.swip span.highTemp.swip > span.temp");
    private By highExpandTemp = By.cssSelector("body.forecast:nth-child(2) div.center:nth-child(7) div.dayDetails.revealed:nth-child(3) div.summary_container div.dayExtras div.highLowTemp.swip span.lowTemp.swap > span.temp");


//https://dzone.com/articles/getting-current-date-time-in-java
//https://stackoverflow.com/questio


    @Step
    public ArrayList<String> getFutureTimes() {
        ArrayList<String> list = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        Date time = new Date();
        c.setTime(time);
        for (int i = 0; i <= 10; i++) {
            c.add(Calendar.HOUR, 2);
            time = c.getTime();
            String sDateFormat = "ha";
            DateFormat dFormat = new SimpleDateFormat(sDateFormat);
            String formatDate = dFormat.format(time).toLowerCase();

            list.add(formatDate);
        }
        System.out.println("List of times:" + list);
        return list;
    }
//    @Step
//    public ArrayList<String> getHoursFromWebsite() {
//
//        ArrayList<String> hours = new ArrayList<>();
//        int increase =  twoHourIncrement.toString().indexOf(49);
//       System.out.println(increase);
//       hours.add(twoIncrement);
//       int increase =twoIncrement.indexOf(49);
//       System.out.println("Index of: " + increase);
//      for (int i=3; i<=10; i+2){


//loop with array above
//https://stackoverflow.com/questions/11363969/array-of-calendar-objects
    @Step
    public ArrayList<String> getHoursFromWebsite() {

        ArrayList<String> hours = new ArrayList<>();
        hours.add(getTextFromElement(twoHourIncrement));
        hours.add(getTextFromElement(fourHourIncrement));
        hours.add(getTextFromElement(sixHourIncrement));
        hours.add(getTextFromElement(eightHourIncrement));
        hours.add(getTextFromElement(tenHourIncrement));
        hours.add(getTextFromElement(twelveHourIncrement));
        hours.add(getTextFromElement(fourteenHourIncrement));
        hours.add(getTextFromElement(sixteenHourIncrement));
        hours.add(getTextFromElement(eighteenHourIncrement));
        hours.add(getTextFromElement(twentyHourIncrement));
        hours.add(getTextFromElement(twentytwoHourIncrement));


        System.out.println("Darksky locator hours: " + hours);
        return hours;

//https://stackoverflow.com/questions/16532025/increment-time-by-one-second-in-a-loop
//Increments for time above. For loop created within the code to get hours after current time. Without the for loop we simply get 2 hours after the current time
//Method above: https://stackoverflow.com/questions/16441069/increment-time-in-date-variable
//https://stackoverflow.com/questions/2220400/how-do-i-make-my-string-comparison-case-insensitive

    }

    @Step
    public void verifyHours() {
        Assert.assertEquals(getFutureTimes(), getHoursFromWebsite());
    }

    @Step
    public void expandTimeline() {
        clickOn(expandTimelineButton);

    }

    @Step
    public int getLowTemp() {

        String lTemp = getTextFromElement(lowTemp);
        String loTempInt = lTemp.replaceAll("[^0-9]", "");
        int lt = Integer.parseInt(loTempInt);
        System.out.println("Low temp: " + lt);
        return lt;
    }

    @Step
    public int getExpandedLowTemp() {

        String lExpandTemp = getTextFromElement(lowExpandTemp);
        String lExpandTempInt = lExpandTemp.replaceAll("[^0-9]", "");
        int leT = Integer.parseInt(lExpandTempInt);
        System.out.println("Low expanded temp: " + leT);
        return leT;
    }

    @Step
    public int getHighTemp() {

        String hTemp = getTextFromElement(highTemp);
        String hiTempInt = hTemp.replaceAll("[^0-9]", "");
        int ht = Integer.parseInt(hiTempInt);
        System.out.println("High temp: " + ht);
        return ht;
    }

    @Step
    public int getExpandedHighTemp() {

        String hExpandTemp = getTextFromElement(highExpandTemp);
        String hExpandTempInt = hExpandTemp.replaceAll("[^0-9]", "");
        int heT = Integer.parseInt(hExpandTempInt);
        System.out.println("High expanded temp: " + heT);
        return heT;
    }

    @Step
    public void verifyTempsAreEqual() {
        Assert.assertEquals(getLowTemp(), getExpandedLowTemp());
        Assert.assertEquals(getHighTemp(), getExpandedHighTemp());

    }

}








