package com.vytrack.tests.components.activites;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VYTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DateTimeAutoAdjust extends TestBase {
    String createEventLocator="//a[@title='Create Calendar event']";

    String currentTimeBox="[id^=time_selector_oro_calendar_event_form_start-uid]";
    String endTimeBox="[id^=time_selector_oro_calendar_event_form_end]";


    @Test
    public void autoAdjust(){

        String username= ConfigurationReader.getProperty("username");
        String password=ConfigurationReader.getProperty("password");
        SeleniumUtils.waitPlease(5);
        VYTrackUtils.login(driver,username,password);
        SeleniumUtils.waitPlease(5);
        VYTrackUtils.navigateToModule(driver,"Activities","Calendar Events");
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        SeleniumUtils.waitPlease(3);
    WebElement timeBox=driver.findElement(By.cssSelector(currentTimeBox));
    WebElement endTimeBox1=driver.findElement(By.cssSelector(endTimeBox));
    SeleniumUtils.waitPlease(5);
    timeBox.clear();
    SeleniumUtils.waitPlease(5);
    timeBox.sendKeys("1:00 PM");

    SeleniumUtils.waitPlease(3);
      // timeBox.sendKeys(Keys.ENTER);
//        SeleniumUtils.waitPlease(3);

        Actions action= new Actions(driver);
       SeleniumUtils.clickWithWait(driver,By.cssSelector(currentTimeBox),4);



        String comparestart=endTimeBox1.getText();
        Assert.assertTrue(comparestart.equals("2:00 PM"));







    }
}
