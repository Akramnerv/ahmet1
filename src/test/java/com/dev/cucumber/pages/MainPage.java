package com.dev.cucumber.pages;

import com.dev.katalon.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//a[@id='itemc']")
    List<WebElement> allCategories;

    @FindBy(xpath = "//a[@class='hrefch']")
    List<WebElement> allCardTitle;

    @FindBy(linkText = "Cart")
    WebElement cartButton;

    public void clickCartButton() throws InterruptedException {
        Thread.sleep(2000);

        cartButton.click();
        
    }

    public void chooseCategory(String categoryType) throws InterruptedException {
        Thread.sleep(2000);
        for(WebElement category:allCategories){
            if(BrowserUtils.getText(category).equals(categoryType)){
                category.click();
                break;
            }
        }
    }
    public void chooseItem(String item) throws InterruptedException {
        Thread.sleep(2000);
        for (WebElement title: allCardTitle){
            if(BrowserUtils.getText(title).equals(item)){
                title.click();
                break;
            }
        }
    }
}
