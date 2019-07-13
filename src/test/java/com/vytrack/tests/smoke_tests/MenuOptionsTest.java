package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MenuOptionsTest {
    WebDriver driver;



    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.cssSelector("#prependedInput")).sendKeys("user153");
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("UserUser123");
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector("#_submit")).click();

    }
    @Test(description = "verify fleet vhicle title")
    public void test1()throws Exception{


      driver.navigate().to("http://qa2.vytrack.com/entity/Extend_Entity_Carreservation");
      SeleniumUtils.waitPlease(3);

      String expectedtitle="Car - Entities - System - Car - Entities - System";
      String actualtitle=driver.getTitle();

        Assert.assertEquals(expectedtitle,actualtitle);
        System.out.println("actualtitle = " + actualtitle);
        System.out.println("expectedtitle = " + expectedtitle);
    }
    @Test(description = "verify costumer account page title")
    public void test2(){

        driver.navigate().to("http://qa2.vytrack.com/account");
        String expected="Accounts - Customers";
        String actual=driver.getTitle();
        String expectedname="Accounts";
        String actualname=driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        SeleniumUtils.waitPlease(3);
        Assert.assertEquals(expectedname,actualname);
        Assert.assertEquals(expected,actual);

        System.out.println("actualname = " + actualname);
        System.out.println("expectedname = " + expectedname);

    }
    @Test(description = "contacts")
    public void test3(){

        driver.navigate().to("http://qa2.vytrack.com/contact");
        String expected="Contacts - Customers";
        String actual=driver.getTitle();
        String expectedname="Contacts";
        String actualname=driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        SeleniumUtils.waitPlease(3);
        Assert.assertEquals(expectedname,actualname);
        Assert.assertEquals(expected,actual);
        System.out.println("actualname = " + actualname);
        System.out.println("expectedname = " + expectedname);

    }
    @Test(description = "activities")
    public void test4(){
        driver.navigate().to("http://qa2.vytrack.com/calendar/event");
        String expected="Calendar Events - Activities";
        String actual=driver.getTitle();
        String expectedname="Calendar Events";
        String actualname=driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        SeleniumUtils.waitPlease(3);
        Assert.assertEquals(expectedname,actualname);
        Assert.assertEquals(expected,actual);
        System.out.println("actualname = " + actualname);
        System.out.println("expectedname = " + expectedname);


    }
    @AfterMethod
    public void teardown(){
        SeleniumUtils.waitPlease(5);
        driver.close();
    }
}
