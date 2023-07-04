package com.dev.katalon.tests;

import com.dev.katalon.utils.BrowserUtils;
import com.dev.katalon.utils.ConfigReader;
import com.dev.katalon.utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("QA_katalon_URL"));
    }

@AfterMethod
    public void tearDown(){
        BrowserUtils.getScreenShot(driver, "katalon");
        driver.quit();
}














//    @AfterMethod
//    public void tearDown(){
//        BrowserUtils.getScreenShot(driver,"katalon");
//        //driver.quit();
//    }
}
