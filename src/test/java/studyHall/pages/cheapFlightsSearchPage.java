package studyHall.pages;

import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public class cheapFlightsSearchPage extends BrowserUtils {

    public cheapFlightsSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        // this = current driver instance
    }



}
