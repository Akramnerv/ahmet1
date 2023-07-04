package com.dev.cucumber.pages;

import com.dev.katalon.utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage {
    public PlaceOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement name;

    @FindBy(xpath = "//input[@id='country']")
    WebElement country;
    @FindBy(xpath = "//input[@id='city']")
    WebElement city;
    @FindBy(xpath = "//input[@id='card']")
    WebElement creditCard;
    @FindBy(xpath = "//input[@id='month']")
    WebElement month;
    @FindBy(xpath = "//input[@id='year']")
    WebElement year;
    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;
    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
    WebElement successfulMSG;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void provideOrderInfo(String name, String country, String city, String creditCard, String month, String year) throws InterruptedException {
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.creditCard.sendKeys(creditCard);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        Thread.sleep(3000);
        purchaseButton.click();

    }
    public void validateOrderMSG(String message){
        Assert.assertEquals(BrowserUtils.getText(successfulMSG),message);
        okButton.click();

    }
}
