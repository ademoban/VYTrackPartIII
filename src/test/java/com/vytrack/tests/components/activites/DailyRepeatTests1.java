package com.vytrack.tests.components.activites;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VYTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DailyRepeatTests1 extends TestBase {

    static String username = ConfigurationReader.getProperty("username");
    static String password = ConfigurationReader.getProperty("password");
    static String createEventLocator = "//a[@title='Create Calendar event']";
    static String repeatCheckBox = "[id^=recurrence-repeat-]";
    String dailyselection = "[id^=recurrence-repeats-]";
    String daysCheckBox = "//input[@type='radio'][@checked='checked']";
    String numberLocator = "[name^='temp-validation-name-']";
    WebElement daysInputBox = driver.findElement(By.xpath("//input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']"));


    @Test(description = "verify Error Msg, Value not be <1 not tobe >99")
    public void EndErroMessage(){
    startup();

}

    public static void startup() {
        VYTrackUtils.login(driver, username, password);
        SeleniumUtils.waitPlease(3);
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(6);
        driver.findElement(By.xpath(createEventLocator)).click();
        SeleniumUtils.waitPlease(6);
        driver.findElement(By.cssSelector(repeatCheckBox)).click();
        SeleniumUtils.waitPlease(6);
    }
}