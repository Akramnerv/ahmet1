package com.dev.katalon.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class DriverHelper {

    // singleton pattern design --> private constructor
    // it is a way to centralize your driver
    private static WebDriver driver;
    //private constructor
    private DriverHelper(){}//you can make the constructor private since you do not want to
    //create an object from this class.One of the great ways of ENCAPSULATION.

    public static WebDriver getDriver(){

        if(driver==null||((RemoteWebDriver)driver).getSessionId()==null){
            //  String browser="chrome";
            switch (ConfigReader.readProperty("browser")){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;

                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

}
