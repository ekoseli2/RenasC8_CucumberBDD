package studyHall.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;

public class Lab1Page extends BrowserUtils {
    public Lab1Page() {
        PageFactory.initElements(Driver.getDriver(), this);
        // this = current driver instance
    }

    @FindBy(xpath = "//span[.='Get a Quote']")
    private WebElement getAQuote;
    @FindBy(xpath = "//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c60-36 ng-star-inserted']")
    private WebElement vehicleYearDropdown;
    @FindBy(xpath = "//span[@class='mat-option-text']")
    private List<WebElement> years;
    @FindBy(id = "mat-select-value-19']")
    private WebElement vehicleMakeDropdown;
    @FindBy(xpath = "//span[@class='mat-option-text']")
    private List<WebElement> makes;
    @FindBy(id = "mat-select-value-23']")
    private WebElement vehicleModelDropdown;
    @FindBy(xpath = "//span[@class='mat-option-text']")
    private List<WebElement> models;
    @FindBy(xpath = "//button[@id='next-step']")
    private WebElement nextButton;
    @FindBy(xpath = "(//div[@class='mat-step-text-label ng-star-inserted'])[7]")
    private WebElement driverHistory;




}
