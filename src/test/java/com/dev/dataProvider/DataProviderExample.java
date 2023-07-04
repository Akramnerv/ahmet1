package com.dev.dataProvider;

import com.dev.katalon.utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderExample {
    public WebDriver driver;

//    @DataProvider(name = "logintest")
//    public Object[][] loginData() {
//        return new Object[][]{
//                {"standard_user", "secret_sauce","Swag Labs"},
//                {"locked_out_user", "secret_sauce","Swag Labs"},
//                {"problem_user", "secret_sauce","Swag Labs"},
//                {"performance_glitch_user", "secret_sauce","Swag Labs"}
//        };
//    }

    @Test(dataProvider = "logintest", dataProviderClass = LoginDataForDataProvider.class)
    public void validateAllAccount(String username, String password, String title) {
        WebDriverManager.chromedriver().setup();
        driver = DriverHelper.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys(username);
        WebElement passWord = driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        Assert.assertEquals(driver.getTitle(),title);
        driver.quit();


    }
}
