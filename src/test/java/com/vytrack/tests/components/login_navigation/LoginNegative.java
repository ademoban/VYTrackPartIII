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

public class LoginNegative {
    WebDriver driver;


    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");



    }




    @Test(description = "Login Negative case")
    public void test1(){
        driver.findElement(By.id("prependedInput")).sendKeys("user154");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser1234");
        driver.findElement(By.xpath("//button[@id='_submit']")).click();
      WebElement invalid=  driver.findElement(By.xpath("//*[contains(text(),'Invalid user name or password.')]"));

      if(driver.getCurrentUrl().equals("http://qa2.vytrack.com/user/login")&&driver.getTitle().equals("Login")) {
          System.out.println(invalid.isDisplayed());
      }




    }



    @AfterMethod
    public void teardown(){
        SeleniumUtils.waitPlease(2);
        driver.quit();
    }
}