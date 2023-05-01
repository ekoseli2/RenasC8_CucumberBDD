package stepDefinitions;

import Pages.OrangeHRMHome;
import Pages.OrangeHRMLogin;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class OrangeHRMSteps extends BrowserUtils {

    OrangeHRMLogin loginPage = new OrangeHRMLogin();
    OrangeHRMHome homePage = new OrangeHRMHome();

    private static final Logger logger = Logger.getLogger(OrangeHRMSteps.class);

    @Given("the User wants to go to OrangeHRM Website")
    public void the_user_wants_to_go_to_orange_hrm_website() {
        Driver.getDriver().get(PropertiesReader.getProperties("OrangeHRMTestURL"));
        setWaitTime();
    }
    @When("the User wants to enter username and password")
    public void the_user_wants_to_enter_username_and_password() {
        loginPage.setUsernameInput(PropertiesReader.getProperties("username"));
        loginPage.setPasswordInput(PropertiesReader.getProperties("password"));
        logger.info("Username and password provided succesfully");
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
        logger.info("All necessary information to Login details are provided");
    }

    @Then("the User wants to add employees' first name and last name using a List")
    public void the_user_wants_to_add_employees_first_name_and_last_name_using_a_list(List<List<String>> dataTable) {
                                                              // row       // column
        homePage.setFirstName(dataTable.get(2).get(0));
        homePage.setLastName(dataTable.get(2).get(1));
    }
    @Then("the User wants to add Login details using a List")
    public void the_user_wants_to_add_login_details_using_a_list(List<List<String>> dataTable) {
        homePage.setAddLoginDetails();
        logger.info("Add login details button is clicked successfully");
       homePage.setUserName(dataTable.get(1).get(0));
       homePage.setPassword(dataTable.get(1).get(1));
       homePage.setConfirmPassword(dataTable.get(1).get(1));
       homePage.setStatusDropdown(dataTable.get(1).get(2));
       logger.info("Status was successfully provided");
    }

    @Then("the User wants to add login information {string} {string} {string}")
    public void the_user_wants_to_add_login_information(String username, String password, String status) {
        homePage.setAddLoginDetails();
        logger.info("Add Login Details button is clicked successfully");

        homePage.setUserName(username);
        logger.info(username + " is provided as a username");

        homePage.setPassword(password);
        logger.info(password + " is provided as a password");

        homePage.setConfirmPassword(password);
        logger.info(password + " is provided as the confirm password");

        homePage.setStatusDropdown(status);
        logger.info(status + " is provided as the status");
    }

    @Then("the User wants to add employee first name as {string} and the last name as {string}")
    public void the_user_wants_to_add_employee_first_name_as_and_the_last_name_as(String firstname, String lastname) {
         homePage.setFirstName(firstname);
         homePage.setLastName(lastname);
         logger.info(firstname+" is provided as firstname and "+lastname+" is provided as lastname");
    }



    @Given("The user wants to login to OrangeHRM using Excel File")
    public void the_user_wants_to_login_to_orange_hrm_using_excel_file() throws IOException {
        Driver.getDriver().get(PropertiesReader.getProperties("OrangeHRMTestURL"));

        //Give the path of external file
        //File path is absolute path
        String filePath= "C:\\Users\\oralr\\IdeaProjects\\RenasC8_CucumberBDD\\src\\test\\resources\\externalFileC8.xlsx";
        //We are loading the file
        FileInputStream fileInputStream= new FileInputStream(filePath);
        //Lets open the excel file
        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
        //Lets open the Sheet1
        XSSFSheet sheet= workbook.getSheet("Sheet1");


        System.out.println(sheet.getRow(0).getCell(0).toString());
        System.out.println(sheet.getRow(0).getCell(1).toString());
        System.out.println(sheet.getRow(1).getCell(0).toString());
        System.out.println(sheet.getRow(1).getCell(1).toString());

        int rows= sheet.getLastRowNum();
        int columns=sheet.getRow(0).getLastCellNum();

        System.out.println(rows);
        System.out.println(columns);

        String username= sheet.getRow(1).getCell(0).toString();
        String password= sheet.getRow(1).getCell(1).toString();

        loginPage.setDataFromExcel(username,password);

        for (int i=0; i<rows+1; i++){
            for(int j=0; j<columns; j++){
                System.out.println(sheet.getRow(i).getCell(j).toString());
            }
        }


    }


}
