package com.vytrack.utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SeleniumUtils {


    public static void verifyEquals(String expectedResult, String actualResult) {
        if (expectedResult.equals(actualResult)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
            System.out.println("Expected result: " + expectedResult);
            System.out.println("Actual result: " + actualResult);


        }

    }

    public static void waitPlease(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void verifyDiplayed(WebElement element) {

        if (element.isDisplayed()) {
            System.out.println("passed " + element.getAttribute("id"));
        } else {
            System.out.println("failed " + element.getAttribute("id"));
        }

    }

    public static void openPage(String page, WebDriver driver) {
        //we will find all examples on the home page
        List<WebElement> listOfExamples = driver.findElements(By.tagName("a"));
        for (WebElement example : listOfExamples) {
            if (example.getText().contains(page)) {
                example.click();
                break;
            }
        }

    }

    public static void clickWithWait(WebDriver driver, By by, int attempts) {
        int counter = 0;
        //click on element as many as you specified in attempts parameter
        while (counter < attempts) {
            try {
                //selenium must look for element again
                driver.findElement(by).click();
                //if click is successful - then break
                break;
            } catch (WebDriverException e) {
                //if click failed
                //print exception
                System.out.println(e);
                //print attempt
                System.out.println("Attempt :: " + ++counter);
                //wait for 1 second, and try to click again
                waitPlease(2);
            }
        }
    }
    public static String getScreenshot(String name)  {
        // name the screenshot with the current date time to avoid duplicate name
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_hh:mm:ss a"));
        // TakesScreenshot ---> interface from selenium which takes screenshots
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target;
    }
}