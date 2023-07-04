package com.dev.katalon.pages;

import com.dev.katalon.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1")
    WebElement header;

    @FindBy(partialLinkText = "Make")
    WebElement makeAppt;

    public String actualHeader() {
        return BrowserUtils.getText(header);
    }

    public void clickAppt() {
        makeAppt.click();

    }

}
