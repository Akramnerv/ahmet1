package com.dev.alertPractice.tests;

import com.dev.alertPractice.pages.GetWindowHandlesPage;
import org.testng.annotations.Test;

public class GetWindowHandleTest extends TutorialTestBase{
    @Test
    public void validateHeader(){
        GetWindowHandlesPage getWindowHandlesPage = new GetWindowHandlesPage(driver);
        getWindowHandlesPage.clickButton4(driver);

    }

}
