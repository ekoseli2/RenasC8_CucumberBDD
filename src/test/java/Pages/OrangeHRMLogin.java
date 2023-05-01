package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public class OrangeHRMLogin extends BrowserUtils {
    public OrangeHRMLogin() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final Logger logger = Logger.getLogger(OrangeHRMLogin.class);

    public void setUsernameInput(String username) {
        if (username.isEmpty()) {
            logger.error("Username is empty. Please check the value you provided");
            logger.warn("Username is necessary to login");
            logger.fatal("Not able to Log in due to empty username");
            logger.info("Please provide a valid Username");
        }
        staticWait(1);
        usernameInput.sendKeys(username);
    }

    public void setPasswordInput(String password) {
        staticWait(1);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        clickWithWait(loginButton);
    }

    @FindBy(id="txtUsername")
    private WebElement usernameInput;
    @FindBy(id="txtPassword")
    private WebElement passwordInput;
    @FindBy(id="btnLogin")
    private WebElement loginButton;

    public void setDataFromExcel(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        clickWithWait(loginButton);



    }

}
