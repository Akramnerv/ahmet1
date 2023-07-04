package com.dev.cucumber.stepdefinitions;

import com.dev.cucumber.pages.CartPage;
import com.dev.cucumber.pages.MainPage;
import com.dev.cucumber.pages.PlaceOrderPage;
import com.dev.cucumber.pages.ProductPage;
import com.dev.katalon.utils.ConfigReader;
import com.dev.katalon.utils.DriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class OrderProcessStepDef {

    WebDriver driver = DriverHelper.getDriver();
    MainPage mainPage = new MainPage(driver);
    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);
    PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);

    @Given("User navigates to the Blaze website")
    public void user_navigates_to_the_blaze_website() {
        driver.get(ConfigReader.readProperty("QA_blaze_url"));

    }

    @When("User clicks the {string} and choose the item {string}")
    public void user_clicks_the_and_choose_the_item(String category, String item) throws InterruptedException {
        mainPage.chooseCategory(category);
        mainPage.chooseItem(item);


    }

    @When("User validates the {string} and {string} from alert pop-up after clicking Add to Cart button")
    public void user_validates_the_and_from_alert_pop_up_after_clicking_add_to_cart_button(String expectedHeader, String expectedMessage) throws InterruptedException {
        Assert.assertEquals(expectedHeader, productPage.actualHeader());
        productPage.validateAddingProduct(driver, expectedMessage);


    }

    @When("User clicks Cart button and validates the {string} and {string} then click Place Order Button")
    public void user_clicks_cart_button_and_validates_the_and_expected_price_then_click_place_order_button(String expectedTitle, String expectedPrice) throws InterruptedException {
        mainPage.clickCartButton();
        cartPage.validateInfo(expectedTitle, expectedPrice);
        cartPage.clickPlaceOrderButton();


    }

    @When("User proves the information {string}, {string}, {string}, {string}, {string}, {string} and click Purchase Button")
    public void user_proves_the_information_and_click_purchase_button(String name, String country, String city, String creditCard, String month, String year) throws InterruptedException {
        placeOrderPage.provideOrderInfo(name, country, city, creditCard, month, year);


    }

    @Then("User validates the message {string} and url {string}")
    public void user_validates_the_message_and_url(String expectedMSG, String expectedURL) {
        placeOrderPage.validateOrderMSG(expectedMSG);
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());


    }

    @When("User clicks the and choose the item")
    public void user_clicks_the_and_choose_the_item(DataTable dataTable) throws InterruptedException {
        Map<String, String> product = dataTable.asMap();
        mainPage.chooseCategory(product.get("category"));
        mainPage.chooseItem(product.get("item"));
    }

    @Then("User validates the message and url")
    public void user_validates_the_message_and_url(DataTable dataTable) {
        List<String> messageAndUrl = dataTable.asList();
        placeOrderPage.validateOrderMSG(messageAndUrl.get(0));
        Assert.assertEquals(messageAndUrl.get(1),driver.getCurrentUrl());

    }

}
