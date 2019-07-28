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

public class PageAccessTest {
    WebDriver driver;


    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");




    }
    @Test(description = "Vehicle\tcontracts\ttest\tstore\tmanager")
  public void test1(){

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager87");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.xpath("//button[@id='_submit']")).click();
        SeleniumUtils.waitPlease(6);
      WebElement dropdown=  driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]"));
      dropdown.click();
        SeleniumUtils.waitPlease(6);
        driver.findElement(By.xpath("//span[contains(text(),'Vehicle Contracts')]")).click();
        SeleniumUtils.waitPlease(6);
        System.out.println(driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).isDisplayed());
        SeleniumUtils.waitPlease(6);

    }
@Test(description = "Vehicle\tcontracts\ttest\tsales\tmanager")
    public void test2(){

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager253");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.xpath("//button[@id='_submit']")).click();
    SeleniumUtils.waitPlease(6);
        WebElement dropdown=  driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]"));
        dropdown.click();
        SeleniumUtils.waitPlease(6);
    driver.findElement(By.xpath("//span[contains(text(),'Vehicle Contracts')]")).click();
    SeleniumUtils.waitPlease(6);
    System.out.println(driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).isDisplayed());

    }
@Test(description = "Vehicle\tcontracts\ttest\tdriver")
    public void test3(){

        driver.findElement(By.id("prependedInput")).sendKeys("user154");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.xpath("//button[@id='_submit']")).click();
        SeleniumUtils.waitPlease(3);

        WebElement dropdown=  driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]"));
        dropdown.click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[contains(text(),'Vehicle Contracts')]")).click();
        SeleniumUtils.waitPlease(3);

        WebElement dsply= driver.findElement(By.xpath("//div[contains(text(),'You do not have permission to perform this action.')]"));

        SeleniumUtils.waitPlease(3);
    System.out.println(dsply.isDisplayed());




    }


    @AfterMethod
    public void teardown(){
        SeleniumUtils.waitPlease(2);
        driver.quit();
    }
}