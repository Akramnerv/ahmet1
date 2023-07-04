package com.dev.alertPractice.pages;

import com.dev.katalon.utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AlertDemoPage {
    public AlertDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@itemprop='name']")
    WebElement header;

    @FindBy(css = "#alertBox")
    WebElement alertBoxClick;

    @FindBy(css = "#confirmBox")
    WebElement confirmBoxClick;

    @FindBy(css = "#promptBox")
    WebElement promptBoxClick;

    @FindBy(xpath = "//div[@id='output']")
    WebElement outPutMSG;

    public void validateAllTheButtonsFunctionality(WebDriver driver, String title, String expectedHeader, String alertBoxText,
                                                   String alertBoxOutput, String confirmBoxOutput, String promptSendKeys, String promptOutPut) throws InterruptedException {
        BrowserUtils.switchByTitle(driver, title);
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        alertBoxClick.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert(); // when pop-up happens then you need to create this
        Assert.assertEquals(alert.getText(),alertBoxText);
        alert.accept();
        Thread.sleep(2000);
        BrowserUtils.scrollWithJS(driver, outPutMSG);
        Assert.assertEquals(BrowserUtils.getText(outPutMSG),alertBoxOutput);
        confirmBoxClick.click();
        alert.dismiss();
        Assert.assertEquals(BrowserUtils.getText(outPutMSG),confirmBoxOutput);
        promptBoxClick.click();
        alert.sendKeys(promptSendKeys);
        Thread.sleep(2000);
        alert.accept();
        Assert.assertEquals(BrowserUtils.getText(outPutMSG),promptOutPut);


    }

}
