package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public class guru99Home extends BrowserUtils {
    // Constructor to load page WebElements onto the driver
    public guru99Home() {
        PageFactory.initElements(Driver.getDriver(), this);
        // this = current driver instance
    }

    @FindBy(xpath = "//select[@name='quantity']")
    private WebElement quantityDropdown;

    @FindBy(xpath = "//input[@class='button special']")
    private WebElement buyNowButton;

    // methods to perform relevant WebElement actions
    public void selectQuantity(String quantity) {
        selectFromDropdown(quantityDropdown, quantity);
    }

    public void clickBuyNow() {
        clickWithWait(buyNowButton);
    }

}
