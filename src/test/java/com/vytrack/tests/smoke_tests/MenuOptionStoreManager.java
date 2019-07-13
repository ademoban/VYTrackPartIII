package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MenuOptionStoreManager {

    WebDriver driver;
    String actualtitle;
    String expectedtitle;
    String actualname;
    String expectedname;
    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager87");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.xpath("//button[@id='_submit']")).click();

    }

    @Test(description = "verifying dashboard")
    public void test(){
        driver.navigate().to("http://qa2.vytrack.com/dashboard/view/1?change_dashboard=1");
        actualtitle=driver.getTitle();
        System.out.println("actualtitle = " + actualtitle);
        expectedtitle="Dashboard - Dashboards";
        System.out.println("expectedtitle = " + expectedtitle);
        actualname=driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        expectedname="Dashboard";
        Assert.assertEquals(expectedtitle,actualtitle);
        Assert.assertEquals(expectedname,actualname);
        System.out.println("actualname = " + actualname);
        System.out.println("expectedname = " + expectedname);
SeleniumUtils.waitPlease(3);

    }
    @Test(description = "verify fleet vehicle")
    public void test2(){

        driver.navigate().to("http://qa2.vytrack.com/entity/Extend_Entity_Carreservation");
        SeleniumUtils.waitPlease(2);
        expectedtitle="Car - Entities - System - Car - Entities - System";
        actualtitle=driver.getTitle();
        expectedname="Cars";
        actualname=driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();



    }
    @Test(description = "costumer account")
    public void test3(){
        driver.navigate().to("http://qa2.vytrack.com/account");
        SeleniumUtils.waitPlease(2);
        expectedtitle="Accounts - Customers";
        actualtitle=driver.getTitle();
        expectedname="Accounts";
        actualname=driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();

    }
    @Test(description = "contact Account")
    public void test4() {
        driver.navigate().to("http://qa2.vytrack.com/contact");
        SeleniumUtils.waitPlease(2);
        expectedtitle = "Contacts - Customers";
        actualtitle = driver.getTitle();
        expectedname = "Contacts";
        actualname = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();


    }
    @Test(description = "sales opportunities")
    public void test5() {
        driver.navigate().to("http://qa2.vytrack.com/opportunity?grid%5Bsales-opportunity-grid%5D=i%3D1%26p%3D25%26s%255BcreatedAt%255D%3D1%26f%255Bstatus%255D%255Btype%255D%3D2%26f%255Bstatus%255D%255Bvalue%255D%255B%255D%3Dlost%26f%255Bstatus%255D%255Bvalue%255D%255B%255D%3Dwon%26c%3Did0.name1.createdAt1.updatedAt0.contactName1.closeRevenue0.closeReasonLabel0.closeDate1.budgetAmount1.probability1.status1.primaryEmail1.ownerName1.accountName0.timesContacted0.timesContactedIn0.timesContactedOut0.lastContactedDate0.lastContactedDateIn0.lastContactedDateOut0.daysSinceLastContact0%26v%3Dopportunity.open%26a%3Dgrid");
        SeleniumUtils.waitPlease(2);
        expectedtitle = "Open Opportunities - Opportunities - " +
                "Sales";
        actualtitle = driver.getTitle();
        expectedname = "Open\tOpportunities";
        actualname = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();


    }
    @Test(description = "Activities call")
    public void test6() {
        driver.navigate().to("http://qa2.vytrack.com/call/");
        SeleniumUtils.waitPlease(2);
        expectedtitle = "Calendar Events - Activities";
        actualtitle = driver.getTitle();
        expectedname = "All " +
                "Calls";
        actualname = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();


    }
    @Test(description = "Calender")
    public void test7() {
        driver.navigate().to("http://qa2.vytrack.com/calendar/event");
        SeleniumUtils.waitPlease(2);
        expectedtitle = "Calendar Events - Activities";
        actualtitle = driver.getTitle();
        expectedname = "Calendar Events";
        actualname = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();


    }

        @AfterMethod
    public void teardown(){


        Assert.assertEquals(actualname,expectedname);
        Assert.assertEquals(actualtitle,expectedtitle);
        System.out.println("actualtitle = "+actualtitle);
        System.out.println("expectedtitle = "+expectedtitle);
        System.out.println("actualname = "+actualname);
        System.out.println("expectedname = "+expectedname);


        driver.quit();
    }
}
