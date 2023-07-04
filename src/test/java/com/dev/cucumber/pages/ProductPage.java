package com.dev.cucumber.pages;

import com.dev.katalon.utils.BrowserUtils;
import io.cucumber.java.cs.Ale;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    WebElement header;

    @FindBy(xpath = "//a[@onclick='addToCart(11)']")
    WebElement addToCartButton;

    public String actualHeader(){
        return BrowserUtils.getText(header);
    }
    public void validateAddingProduct(WebDriver driver, String expectedText) throws InterruptedException {

        addToCartButton.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(expectedText, alert.getText().trim()); //junit assert
        alert.accept();
    }
}
