package com.dev.katalon.pages;

import com.dev.katalon.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class AppointmentPage {

    public AppointmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2")
    WebElement header;

    @FindBy(id = "combo_facility")
    WebElement facility;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement readmission;

    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> allRadioButtons;

    @FindBy(xpath = "//input[@id='txt_visit_date']")
    WebElement date;

    @FindBy(xpath = "//textarea[@id='txt_comment']")
    WebElement comment;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement bookApptButton;

    @FindBy(xpath = "//section[@class='section bg-primary']")
    WebElement section;

    @FindBy(tagName = "h2")
    WebElement confirmationHeader;

    @FindBy(xpath = "//div[@class='col-xs-8']//p")// 5 elements
    List<WebElement> allConfirmationInfo;

    @FindBy(linkText = "Go to Homepage") // to be able to use linktext --> a tag and actual text
    WebElement homePageButton;



    public String actualHeader() {
        return BrowserUtils.getText(header);
    }
    public String actualBackgroundColor(){
        return section.getCssValue("background-color");
    }

    public void getAnAppointment(String facilityText, String healthCareProgram,String date, String comment) throws InterruptedException {
        Thread.sleep(2000);
        Select newFacility = new Select(facility);
        Thread.sleep(3000);
        newFacility.selectByVisibleText(facilityText);
        Thread.sleep(2000);
        readmission.click();
        Assert.assertTrue(readmission.isSelected());
        Thread.sleep(2000);
        for (WebElement radiobutton : allRadioButtons) {
            if (radiobutton.getAttribute("value").equals(healthCareProgram)) {
            radiobutton.click();
            break;
        }}
        Thread.sleep(2000);
        this.date.sendKeys(date);
        Thread.sleep(2000);
        this.comment.sendKeys(comment);
        Thread.sleep(2000);
        bookApptButton.click();




    }
    public void validateAllInfo(WebDriver driver,String expectedUrl, String expectedHeader, String facility, String readmission, String healthCare,
                                String date, String comment){
        Assert.assertEquals(BrowserUtils.getText(confirmationHeader),expectedHeader);
        List<String> expectedInfo = Arrays.asList(facility,readmission,healthCare,date,comment);
        for (int i=0; i<allConfirmationInfo.size();i++){
            Assert.assertEquals(allConfirmationInfo.get(i).getText().trim(),expectedInfo.get(i));
        }
       homePageButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);

    }

}
