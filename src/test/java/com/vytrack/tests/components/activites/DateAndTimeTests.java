package com.vytrack.tests.components.activites;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VYTrackUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public  class DateAndTimeTests extends TestBase {
    int date=24;
    String createEventLocator="Create Calendar event";
    String startDate="date_selector_oro_calendar_event_form_start-uid-5d376e0570d65";
    String futureDate="//a[@class='ui-state-default'][contains(text(),"+date+")]";
    String endDate="date_selector_oro_calendar_event_form_end-uid-5d376e0570e58";


    String newDate="//a[@class='ui-state-default'][contains(text(),'23')]";



@Test
    public  void dateTimeEndDateAutoAdjust (){

        String username= ConfigurationReader.getProperty("username");
        String password=ConfigurationReader.getProperty("password");
    String getNewDate=driver.findElement(By.xpath(newDate)).getText();
    String getEndDate=driver.findElement(By.id(endDate)).getText();
    String newEndDate=driver.findElement(By.id("date_selector_oro_calendar_event_form_end-uid-5d376e0570e58")).getText();
    String getFutureDate=driver.findElement(By.id("date_selector_oro_calendar_event_form_start-uid-5d376e0570d65")).getText();
        VYTrackUtils.login(driver,username,password);
        SeleniumUtils.waitPlease(5);
        VYTrackUtils.navigateToModule(driver,"Activities","Calendar Events");
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.linkText("Create Calendar event")).click();
        SeleniumUtils.waitPlease(4);
        driver.findElement(By.id(startDate)).click();
        SeleniumUtils.waitPlease(4);
        driver.findElement(By.xpath(futureDate)).click();
        SeleniumUtils.waitPlease(1);
        Assert.assertEquals(getFutureDate,getEndDate);
        SeleniumUtils.waitPlease(6);
        driver.findElement(By.id(startDate)).click();
        driver.findElement(By.xpath(newDate)).click();
        SeleniumUtils.waitPlease(5);
        Assert.assertEquals(newDate,newEndDate);





    }

}