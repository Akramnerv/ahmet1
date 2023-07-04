package com.dev.alertPractice.tests;

import com.dev.alertPractice.pages.AlertDemoPage;
import com.dev.alertPractice.pages.GetWindowHandlesPage;
import org.testng.annotations.Test;

public class AlertDemoTest extends TutorialTestBase {
    @Test
    public void validateButtons() throws InterruptedException {
        GetWindowHandlesPage getWindowHandlesPage = new GetWindowHandlesPage(driver);
        AlertDemoPage alertDemoPage = new AlertDemoPage(driver);
        getWindowHandlesPage.clickButton4(driver);
        alertDemoPage.validateAllTheButtonsFunctionality(driver, "AlertsDemo", "AlertsDemo",
                "I am an alert box!","You selected alert popup", "You pressed Cancel in confirmation popup",
                "Testing","You entered text Testing in propmt popup");


    }

}
