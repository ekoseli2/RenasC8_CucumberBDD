package studyHall.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ebayPage {
    public ebayPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        // this = current driver instance
    }

    @FindBy(xpath = "//ul[@class='hl-cat-nav__container']//li//a")
    public List<WebElement> dashboardTabs;


}
