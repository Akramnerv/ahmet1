package com.dev.katalon.tests;

import com.dev.katalon.pages.AppointmentPage;
import com.dev.katalon.pages.LoginPage;
import com.dev.katalon.pages.MainPage;
import com.dev.katalon.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppointmentTest extends TestBase {
    @Parameters({"expectedHeader", "backgroundColor", "facility", "healthcare", "date",
            "comment", "confirmationHeader", "readmission"})

    @Test
    public void validateMakingAppt(String expectedHeader, String backgroundColor, String facility,
                                   String healthcare, String date, String comment, String confirmationHeader,
                                   String readmission) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        mainPage.clickAppt();
        loginPage.login();
        Assert.assertEquals(appointmentPage.actualHeader(), expectedHeader);
        Assert.assertEquals(appointmentPage.actualBackgroundColor(), backgroundColor);
        appointmentPage.getAnAppointment(facility, healthcare,
                date, comment);

        appointmentPage.validateAllInfo(driver, ConfigReader.readProperty("QA_katalon_URL"), confirmationHeader,
                facility, readmission, healthcare, date, comment);




    }
}
