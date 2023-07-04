package com.dev.alertPractice.pages;

import com.dev.katalon.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BasicControlPage {
    public BasicControlPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@itemprop='name']")
    WebElement header;

    @FindBy(css = "#firstName")
    WebElement firstName;

    @FindBy(css = "#lastName")
    WebElement lastName;

    @FindBy(xpath = "//input[@name='gender']")
    List<WebElement> gender;

    @FindBy(xpath = "//input[@class='bcCheckBox']")
    List<WebElement> language;

    @FindBy(css = "#email")
    WebElement email;

    @FindBy(css = "#password")
    WebElement password;

    @FindBy(css = "#registerbtn")
    WebElement registerButton;

    @FindBy(css = "#msg")
    WebElement message;

    public void validateRegistration(WebDriver driver, String title, String expectedHeader, String firstName, String lastName,
    String sex, String lnguage, String email, String password, String expectedMessage) throws InterruptedException {
        BrowserUtils.switchByTitle(driver, title);
        Thread.sleep(1000);
        BrowserUtils.scrollWithPoint(driver, message);
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        for(WebElement gendr:gender){
            if(gendr.getAttribute("id").substring(0,gendr.getAttribute("id").length()-2).equals(sex)){
                System.out.println(gendr.getAttribute("id").substring(0,gendr.getAttribute("id").length()-2).equals(sex));
                gendr.click();
                break;
            }
        }
        for(WebElement languageBox:language){
            if(languageBox.getAttribute("id").substring(0,languageBox.getAttribute("id").length()-4).equals(lnguage)){
                languageBox.click();
                break;
            }
        }

        this.email.sendKeys(email);
        this.password.sendKeys(password);
        Thread.sleep(2000);
        BrowserUtils.scrollWithPoint(driver, message);
        BrowserUtils.clickWithJS(driver,registerButton);

        Assert.assertEquals(BrowserUtils.getText(message), expectedMessage);

    }

}
