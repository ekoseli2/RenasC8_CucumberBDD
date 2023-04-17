package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public class OrangeHRMLogin extends BrowserUtils {
    public OrangeHRMLogin() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void setUsernameInput(String username) {
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

}
