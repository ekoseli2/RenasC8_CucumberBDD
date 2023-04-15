package stepDefinitions;

import Pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class guru99Steps extends BrowserUtils {
    guru99Home homePage = new guru99Home();
    guru99Payment paymentPage = new guru99Payment();
    guru99OrderSuccess successPage = new guru99OrderSuccess();

    @Given("the User wants to go to the Payment Gateway website")
    public void the_user_wants_to_go_to_the_payment_gateway_website() {
       Driver.getDriver().get(PropertiesReader.getProperties("demoguru99"));
       setWaitTime();
    }

    @When("the User wants to buy an elephant toy")
    public void the_user_wants_to_buy_an_elephant_toy() {
       homePage.selectQuantity("1");
       homePage.clickBuyNow();
    }

    @Then("the User wants to provide requested payment information")
    public void the_user_wants_to_provide_requested_payment_information() {
        paymentPage.setCardNumberInput("5555555555555555");
        paymentPage.setMonthDropdown("11");
        paymentPage.setYearDropdown("2026");
        paymentPage.setCvvCodeInput("123");
    }

    @Then("the User wants to click on pay now")
    public void the_user_wants_to_click_on_pay_now() {
        paymentPage.clickPayButton();
    }

    @Then("the User wants to verify the order is successful")
    public void the_user_wants_to_verify_the_order_is_successful() {
        successPage.verifyText("Payment successfull!");
    }

    // Parametrized steps for scenario 2
    @When("the User wants to buy an elephant toy as {string}")
    public void the_user_wants_to_buy_an_elephant_toy_as(String string) {
        homePage.selectQuantity(string);
        homePage.clickBuyNow();
    }

    @Then("the User wants to provide their credit card number as {string}")
    public void the_user_wants_to_provide_their_credit_card_number_as(String string) {
        paymentPage.setCardNumberInput(string);
    }

    @Then("the User wants to provide their expiration month as {string}")
    public void the_user_wants_to_provide_their_expiration_month_as(String string) {
        paymentPage.setMonthDropdown(string);
    }

    @Then("the User wants to provide their expiration year as {string}")
    public void the_user_wants_to_provide_their_expiration_year_as(String string) {
        paymentPage.setYearDropdown(string);
    }

    @Then("the User wants to provide their CVV Code as {string}")
    public void the_user_wants_to_provide_their_cvv_code_as(String string) {
        paymentPage.setCvvCodeInput(string);
    }

    @Then("the User wants to verify a message as {string}")
    public void the_user_wants_to_verify_a_message_as(String string) {
        successPage.verifyText(string);
    }

}
