package framework;

import org.junit.Assert;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DarkSkyLandingPage extends BasePage {

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

    private By expandTimeline = By.xpath("");
    private By currentTemp = By.xpath("//span[@class='summary swap']");
    private By lowTemp = By.xpath("//span[@class='currently']//span[2]//span[2]//span[2]");
    private By highTemp = By.xpath("//span[@class='summary-high-low']//span[3]");


//https://dzone.com/articles/getting-current-date-time-in-java
//https://stackoverflow.com/questio

    @Step
    public void getCurrentTime() {
        Date date = new Date();
        String stDateFormat = "hha";
        DateFormat dateFormat = new SimpleDateFormat(stDateFormat);
        String formattedDate = dateFormat.format(date);
        System.out.println("Current time: " + formattedDate);


        List<String> list = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        for (int i = 0; i <= 10; i++) {
            c.add(Calendar.HOUR, 2);
            date = c.getTime();
            String sDateFormat = "ha";
            DateFormat dFormat = new SimpleDateFormat(sDateFormat);
            String formatDate = dFormat.format(date);

            list.add(formatDate);

        }

        System.out.println("List of times:" + list);

//loop with array above
//https://stackoverflow.com/questions/11363969/array-of-calendar-objects


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


//https://stackoverflow.com/questions/16532025/increment-time-by-one-second-in-a-loop
//Increments for time above. For loop created within the code to get hours after current time. Without the for loop we simply get 2 hours after the current time
//Method above: https://stackoverflow.com/questions/16441069/increment-time-in-date-variable
//https://stackoverflow.com/questions/2220400/how-do-i-make-my-string-comparison-case-insensitive


        Assert.assertTrue(list == hours);

    }

    @Step
    public void verifyTempRange() {

        String cTemp = getTextFromElement(currentTemp);
        String currTempInt = cTemp.replaceAll("[^0-9]", "");
        int ct = Integer.parseInt(currTempInt);

        String lTemp = getTextFromElement(lowTemp);
        String loTempInt = lTemp.replaceAll("[^0-9]", "");
        int lt = Integer.parseInt(loTempInt);

        String hTemp = getTextFromElement(highTemp);
        String hiTempInt = hTemp.replaceAll("[^0-9]", "");
        int ht = Integer.parseInt(hiTempInt);

        System.out.println("Current temp: " + ct + " Low temp: " + lt + " High temp: " + ht);

        Assert.assertTrue("Current temp is between low and high temps", lt <= ct && ct <= ht);

    }
}





