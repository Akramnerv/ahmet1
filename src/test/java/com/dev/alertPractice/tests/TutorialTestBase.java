package com.dev.alertPractice.tests;

import com.dev.katalon.utils.BrowserUtils;
import com.dev.katalon.utils.ConfigReader;
import com.dev.katalon.utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TutorialTestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.readProperty("QA_tutorial_url"));

    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.getScreenShot(driver,"tutorial");
        //driver.quit();
    }
}
