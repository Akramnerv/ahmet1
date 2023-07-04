package com.dev.katalon.pages;

import com.dev.katalon.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//input[@name='username']")
    WebElement username;
    @FindBy (xpath = "//input[@type='password']")
    WebElement password;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement loginButton;

    public void login (){
        username.sendKeys(ConfigReader.readProperty("QA_username"));
        password.sendKeys(ConfigReader.readProperty("QA_password"));
        loginButton.click();

    }
}
