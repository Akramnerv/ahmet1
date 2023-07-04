package com.dev.cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr//td")
    List<WebElement> productInfo;

    @FindBy(xpath = "//button[@data-toggle='modal']")
    WebElement placeOrderButton;

    public void validateInfo(String titleOfProd, String price) throws InterruptedException {
        Thread.sleep(2000);
        List<String> expectedInfo = Arrays.asList("", titleOfProd, price, "");
        for (int i = 1; i < productInfo.size() - 1; i++) {
            Assert.assertEquals(expectedInfo.get(i), productInfo.get(i).getText());

        }
    }
    public void clickPlaceOrderButton(){
        placeOrderButton.click();
    }
}
