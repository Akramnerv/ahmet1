package com.dev.katalon.tests;

import com.dev.katalon.pages.LoginPage;
import com.dev.katalon.pages.MainPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test


    public void validateSuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAppt();
        loginPage.login();
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");



    }
}
