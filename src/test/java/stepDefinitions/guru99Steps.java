package stepDefinitions;

import Pages.guru99Home;
import io.cucumber.java.en.*;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class guru99Steps extends BrowserUtils {
    guru99Home homePage = new guru99Home();
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
    }

    @Then("the User wants to click on pay now")
    public void the_user_wants_to_click_on_pay_now() {
    }

    @Then("the User wants to verify the order is successful")
    public void the_user_wants_to_verify_the_order_is_successful() {
    }

}
