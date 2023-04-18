package Pages;

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

    @FindBy(xpath = "//h1[.='Dashboard']")
    private WebElement dashboardHeader;

    public void verifyDashboard() {
        Assert.assertEquals("Dashboard", dashboardHeader.getText());
    }

    public void verifyDashboard(String expectedMessage) {
        Assert.assertEquals(expectedMessage, dashboardHeader.getText());
    }

}
