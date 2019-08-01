package com.vytrack.tests.components.activites;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VYTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class DailyRepeatTests extends TestBase {

  static    String username = ConfigurationReader.getProperty("username");
   static String password = ConfigurationReader.getProperty("password");
    static String createEventLocator = "//a[@title='Create Calendar event']";
  static String repeatCheckBox = "[id^=recurrence-repeat-]";
    String dailyselection = "[id^=recurrence-repeats-]";
    String daysCheckBox = "//input[@type='radio'][@checked='checked']";
   String numberLocator = "//input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']";



    @Test
     void DailyRepeatOption() {

       startup();

        String expectedDailyBox = "Daily";
        WebElement dropdown = driver.findElement(By.cssSelector(dailyselection));
        Select dropdownSelect = new Select(dropdown);
        SeleniumUtils.verifyDiplayed(dropdown);
        String actual = dropdownSelect.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expectedDailyBox);
        System.out.println("actual = " + actual);
        System.out.println("expectedDailyBox = " + expectedDailyBox);
        SeleniumUtils.waitPlease(6);


    }

    @Test(description = "verify check box selected")
    public void chekBoxSelected() {
       startup();

        Assert.assertTrue(driver.findElement(By.xpath(daysCheckBox)).isSelected());
        SeleniumUtils.waitPlease(6);
    }

    @Test(description = "verify default value is 1")
    public void defaultValue() {

startup();
extentLogger= report.createTest("default value is 1");
        List<WebElement> repeatDaysButton = driver.findElements(By.cssSelector("input[class='recurrence-subview-control__number']"));
        Assert.assertEquals(repeatDaysButton.get(0).getAttribute("value"), "1");
        extentLogger.pass("Verified default value is 1");

    }
    @Test(description = "summary= Daily every 1 day")
    public void summary(){
        startup();
        String actualtext=driver.findElement(By.xpath("//span[contains(text(),'Daily every 1 day')]")).getText();
        String Expected="Daily every 1 day";
        Assert.assertEquals(actualtext,actualtext);

    }
    @Test(description = "check weekday chck bx")
    public void weekdaycheckBox(){
        startup();
        driver.findElement(By.xpath("//span[contains(text(),'Weekday')]")).click();
        SeleniumUtils.waitPlease(3);

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='controls recurrence-subview-control__items']//div[2]//label[1]//input[1]")).isSelected());

    }
    @Test(description = "Verify that days input disable")
    public void daysInput(){
       startup();
        driver.findElement(By.xpath("//span[contains(text(),'Weekday')]")).click();
        SeleniumUtils.waitPlease(3);
        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']")).isEnabled());
        }
    @Test(description = " verify summary says Daily every weekday")
    public void summaryVerify(){
        startup();
        driver.findElement(By.xpath("//span[contains(text(),'Weekday')]")).click();
        SeleniumUtils.waitPlease(5);
        String expected="Daily every weekday";
        String actual=driver.findElement(By.xpath("//span[contains(text(),'Daily, every weekday')]")).getText();
        Assert.assertEquals(expected,actual);



    }
@Test(description = "verify error message")
    public void errorMessage(){
    startup();
    Random random= new Random();
    int rdm=random.nextInt(100);



String expectedError99="The value have not to be more than 99.";
String expectedError01="The value have not to be less than 1.";



    SeleniumUtils.waitPlease(3);
    String keytoSend=""+rdm;
  driver.findElement(By.xpath("//input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']")).clear();
  SeleniumUtils.waitPlease(1);
    driver.findElement(By.xpath("//input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']")).sendKeys(keytoSend);
    SeleniumUtils.waitPlease(3);




        if(rdm>99){

    String actualError99=driver.findElement(By.xpath("//span[contains(text(),'The value have not to be more than 99.')]")).getText();
        Assert.assertEquals(expectedError99,actualError99);
        SeleniumUtils.waitPlease(3);}
        else if(rdm<1){

            String actualError01=driver.findElement(By.xpath("//span[contains(text(),'The value have not to be less than 1.')]")).getText();
            Assert.assertEquals(expectedError01,actualError01);

        }
        else {
            SeleniumUtils.waitPlease(3);
           try{ WebElement errorMessageBox=driver.findElement(By.xpath("//span[@style='top: 239.333px; left: 182px;']"));

            Assert.assertFalse(errorMessageBox.isDisplayed());
               SeleniumUtils.waitPlease(3);
            throw new NoSuchElementException();}
           catch (Exception e){
               System.out.println("e = " + e.getMessage());
           }


        }




    }
    @Test(description = "Verify that Summary updated with daily every <random number>")
    public void repeatEveryDaysFunction(){
        startup();
        Random random= new Random();
        int rdm=random.nextInt(100);
        SeleniumUtils.waitPlease(3);
        String keytoSend=""+rdm;

        driver.findElement(By.xpath("//input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']")).clear();
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath("//input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']")).sendKeys(keytoSend);
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']")).sendKeys(Keys.ENTER);
        SeleniumUtils.waitPlease(2);
        String expectedLine="Daily every "+rdm+" days";

        WebElement summaryline= driver.findElement(By.xpath("//span[contains(text(),'Daily every "+rdm+" days')]"));

        Assert.assertEquals(summaryline.getText(),expectedLine);
        System.out.println("summaryline = " + summaryline);
        System.out.println("expectedLine = " + expectedLine);

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
