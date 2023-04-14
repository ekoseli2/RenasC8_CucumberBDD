package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public class guru99Payment extends BrowserUtils {
    public guru99Payment() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "card_nmuber")
    private WebElement cardNumberInput;

    @FindBy(id = "month")
    private WebElement monthDropdown;

    @FindBy(id = "year")
    private WebElement yearDropdown;

    @FindBy(id = "cvv_code")
    private WebElement cvvCodeInput;

    @FindBy(xpath = "//input[@name='submit']")
    private WebElement payButton;

    // setters to handle input("set" values)
    public void setCardNumberInput(String cardNumber) {
        cardNumberInput.sendKeys(cardNumber);
        staticWait(1);
    }

    public void setMonthDropdown(String month) {
        selectFromDropdown(monthDropdown, month);
    }

    public void setYearDropdown(String year) {
        selectFromDropdown(yearDropdown, year);
    }

    public void setCvvCodeInput(String cvvCode) {
        cardNumberInput.sendKeys(cvvCode);
        staticWait(1);
    }

    public void clickPayButton() {
        clickWithWait(payButton);
    }

}
