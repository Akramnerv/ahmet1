package com.dev.alertPractice.pages;

import com.dev.katalon.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetWindowHandlesPage {
    public GetWindowHandlesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[@id='newTabsBtn']")
    WebElement button4;

    public void clickButton4(WebDriver driver){
        BrowserUtils.scrollWithJS(driver,button4);
        button4.click();
    }

}
