package Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public class OrangeHRMHome extends BrowserUtils {
    public OrangeHRMHome() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final Logger logger = Logger.getLogger(OrangeHRMHome.class);

    @FindBy(xpath = "//h1[.='Dashboard']")
    private WebElement dashboardHeader;
    @FindBy(id = "menu_pim_viewPimModule")
    private WebElement pim;
    public void clickPIM() {
        clickWithWait(pim);
    }

    @FindBy(id = "menu_pim_addEmployee")
    private WebElement addEmployee;
    public void clickAddEmployee() {
        clickWithWait(addEmployee);
    }

    @FindBy(id = "firstName")
    private WebElement firstName;

    public void setFirstName(String first) {
        staticWait(1);
        firstName.sendKeys(first);
        logger.info(first + " is successfully entered");
    }

    @FindBy(id = "lastName")
    private WebElement lastName;
    public void setLastName(String last) {
        staticWait(1);
        lastName.sendKeys(last);
        logger.info(last + " is successfully entered");
    }

    @FindBy(id = "btnSave")
    private WebElement saveButton;
    public void clickSaveButton() {
        clickWithWait(saveButton);
        logger.info("Save button was successfully clicked");
    }

    @FindBy(xpath = "//h1[.='Personal Details']")
    private WebElement personalDetailsHeader;
    public void verifyPersonalDetailsHeader(String expectedHeader) {
        staticWait(1);
        Assert.assertEquals(expectedHeader, personalDetailsHeader.getText());
        logger.info(expectedHeader + " is expected header and successfully provided");
    }

    public void verifyDashboard() {
        Assert.assertEquals("Dashboard", dashboardHeader.getText());
    }

    public void verifyDashboard(String expectedMessage) {
        Assert.assertEquals(expectedMessage, dashboardHeader.getText());
    }

    public void setAddLoginDetails() {
        clickWithWait(addLoginDetails);
        logger.info("Add login details button was successfully clicked");
    }

    public void setUserName(String _username) {
        userName.sendKeys(_username);
    }

    public void setPassword(String _password) {
        password.sendKeys(_password);
    }

    public void setConfirmPassword(String _confirmPassword) {
        confirmPassword.sendKeys(_confirmPassword);
    }

    public void setStatusDropdown(String _statusDropdown) {
        selectFromDropdown(statusDropdown, _statusDropdown);
    }

    @FindBy(id = "chkLogin")
    private WebElement addLoginDetails;
    @FindBy(id = "user_name")
    private WebElement userName;
    @FindBy(id = "user_password")
    private WebElement password;
    @FindBy(id = "re_password")
    private WebElement confirmPassword;
    @FindBy(id = "status")
    private WebElement statusDropdown;



}
