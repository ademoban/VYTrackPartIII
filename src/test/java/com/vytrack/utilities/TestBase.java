package com.vytrack.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public  static WebDriver driver;

    Actions action;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;
    @BeforeTest
    public  void testSetUp(){
        report =new ExtentReports();
        String pathToReport=System.getProperty("user.dir")+"/test-output/report.html";
        htmlReporter=new ExtentHtmlReporter(pathToReport);

        report.attachReporter(htmlReporter);
        report.setSystemInfo("Windows",("windows.name"));
        htmlReporter.config().setDocumentTitle("VYTrack Test Automation");
    }

    @BeforeMethod
    public void setup(){




        driver = Driver.getDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Long.valueOf(ConfigurationReader.getProperty("implicitwait")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));
    }
    @AfterMethod
    public void teardown(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()) {
//            if test failed

            String pathToTheScreenshot=SeleniumUtils.getScreenshot(result.getName());

//            capture the name of a test method
            extentLogger.fail(result.getName());

            try {
//                to add screenshot into report
                extentLogger.addScreenCaptureFromPath(pathToTheScreenshot);
            } catch (IOException e) {
                e.printStackTrace();
            }

            extentLogger.fail(result.getThrowable());
        }else if(result.getStatus()==ITestResult.SKIP){
            extentLogger.skip("Test case skipped"+result.getName());
        }
        Driver.closeDriver();


    }

    @AfterTest
    public void tearDownTest(){
        report.flush();
    }
}