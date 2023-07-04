package com.dev.alertPractice.tests;

import com.dev.alertPractice.pages.BasicControlPage;
import com.dev.alertPractice.pages.GetWindowHandlesPage;
import org.testng.annotations.Test;

public class BasicControlTest extends TutorialTestBase{
    @Test
    public void validateRegistration() throws InterruptedException {
        GetWindowHandlesPage getWindowHandlesPage = new GetWindowHandlesPage(driver);
        BasicControlPage basicControlPage = new BasicControlPage(driver);
        getWindowHandlesPage.clickButton4(driver);
        basicControlPage.validateRegistration(driver, "Basic Controls", "Basic Controls","Akram",
                "Yakhyaev", "male","chinese","akram@gmail.com","12345","Registration is Successful");
    }
}
