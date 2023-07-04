package com.dev.katalon.tests;

import com.dev.katalon.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends TestBase{


    @Test

    public void validateUrlAndHeader(){
        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");
        Assert.assertEquals(mainPage.actualHeader(),"CURA Healthcare Service");
    }

}
