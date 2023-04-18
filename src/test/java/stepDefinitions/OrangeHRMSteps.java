package stepDefinitions;

import Pages.OrangeHRMHome;
import Pages.OrangeHRMLogin;
import io.cucumber.java.en.*;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class OrangeHRMSteps extends BrowserUtils {

    OrangeHRMLogin loginPage = new OrangeHRMLogin();
    OrangeHRMHome homePage = new OrangeHRMHome();

    @Given("the User wants to go to OrangeHRM Website")
    public void the_user_wants_to_go_to_orange_hrm_website() {
        Driver.getDriver().get(PropertiesReader.getProperties("OrangeHRMTestURL"));
        setWaitTime();
    }
    @When("the User wants to enter username and password")
    public void the_user_wants_to_enter_username_and_password() {
        loginPage.setUsernameInput(PropertiesReader.getProperties("username"));
        loginPage.setPasswordInput(PropertiesReader.getProperties("password"));
    }
    @Then("the User wants to click on the Login Button")
    public void the_user_wants_to_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }
    @Then("the User wants to verify that the browser landed on Dashboard")
    public void the_user_wants_to_verify_that_the_browser_landed_on_dashboard() {
        homePage.verifyDashboard();
    }

    @Then("the User wants to verify that the browser landed on {string}")
    public void the_user_wants_to_verify_that_the_browser_landed_on(String string) {
        homePage.verifyDashboard(string);
    }

    @Then("the User wants to click on PIM Module")
    public void the_user_wants_to_click_on_pim_module() {
        homePage.clickPIM();
        homePage.clickAddEmployee();
    }

    @Then("the User wants to add first name as {string}")
    public void the_user_wants_to_add_first_name_as(String string) {
        homePage.setFirstName("George");
    }
    @Then("the User wants to add last name as {string}")
    public void the_user_wants_to_add_last_name_as(String string) {
        homePage.setLastName("Washington");
    }
    @Then("the User wants to save personal information")
    public void the_user_wants_to_save_personal_information() {
        homePage.clickSaveButton();
    }
    @Then("the User should be able to see {string} Header")
    public void the_user_should_be_able_to_see_header(String string) {
        homePage.verifyPersonalDetailsHeader(string);
    }

}
