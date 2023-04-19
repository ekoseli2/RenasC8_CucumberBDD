package stepDefinitions;

import Pages.OrangeHRMHome;
import Pages.OrangeHRMLogin;
import io.cucumber.java.en.*;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import java.util.List;
import java.util.Map;

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
    }

    @Then("the User wants to go to Add Employee Page")
    public void the_user_wants_to_go_to_add_employee_page() {
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

    @Then("the User wants to add employee's first name and last name")
    public void the_user_wants_to_add_employee_s_first_name_and_last_name(Map<String, String> dataTable) {
        homePage.setFirstName(dataTable.get("FirstName"));
        homePage.setLastName(dataTable.get("LastName"));
    }
    @Then("the User wants to add login details as follows")
    public void the_user_wants_to_add_login_details_as_follows(Map<String, String> dataTable) {
        homePage.setAddLoginDetails();
        homePage.setUserName(dataTable.get("UserName"));
        homePage.setPassword(dataTable.get("Password"));
        homePage.setConfirmPassword(dataTable.get("Password"));
        homePage.setStatusDropdown(dataTable.get("Status"));
    }

    @Then("the User wants to add employees' first name and last name using a List")
    public void the_user_wants_to_add_employees_first_name_and_last_name_using_a_list(List<List<String>> dataTable) {
        homePage.setAddLoginDetails();
                                                              // row       // column
        homePage.setFirstName(dataTable.get(2).get(0));
        homePage.setLastName(dataTable.get(2).get(1));
    }
    @Then("the User wants to add Login details using a List")
    public void the_user_wants_to_add_login_details_using_a_list(List<List<String>> dataTable) {
       homePage.setUserName(dataTable.get(1).get(0));
       homePage.setPassword(dataTable.get(1).get(1));
       homePage.setConfirmPassword(dataTable.get(1).get(1));
       homePage.setStatusDropdown(dataTable.get(1).get(2));
    }

}
