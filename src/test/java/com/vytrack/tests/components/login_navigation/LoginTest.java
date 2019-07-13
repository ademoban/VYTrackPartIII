package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;


    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager87");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.xpath("//button[@id='_submit']")).click();


    }

    @Test(description = "Verify\tname\tof\tthe\tstore\tmanager is\tdisplayed\ton\ttop\tright")
    public void test1() {

        WebElement names= driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Alena Hagenes')]"));

        System.out.println(names.isDisplayed());


    }

    @Test(description = "Verify\tDashboad\tpage\tis\topen")
    public void test2(){

        String dashboard=driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();

        System.out.println(dashboard.equals("Dashboard"));
    }
    @Test(description = "Logout")
    public void test3(){

//       driver.findElement(By.xpath("//div[@loader-mask shown']")).click();
//
//     SeleniumUtils.waitPlease(3);
//    driver.findElement(By.xpath("//*[@href='/user/logout']")).sendKeys(Keys.ENTER);
//    SeleniumUtils.waitPlease(3);


    }
    @Test(description = "Login\tto\tVytrack\tas\ta\tsales manager")
    public void test4(){

    }



    @AfterMethod
    public void teardown(){
        SeleniumUtils.waitPlease(2);
        driver.quit();
    }
}