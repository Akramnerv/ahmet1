package com.dev.iframePractice;

import com.dev.katalon.utils.BrowserUtils;
import com.dev.katalon.utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class iframePractice {
    @Test
    public void validateHeader() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = DriverHelper.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://skpatro.github.io/demo/iframes/");
        Thread.sleep(3000);
        driver.switchTo().frame("Frame1");
        WebElement category1 = driver.findElement(By.xpath("//a[contains(text(),'Category1')]"));
        category1.click();
        BrowserUtils.switchByTitle(driver,"Archives");
        WebElement header = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(BrowserUtils.getText(header).contains("Category Archives"));
        //driver.switchTo().defaultContent(); -- back to main page withouth iframes // switch to top html




    }
}

