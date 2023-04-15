package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BrowserUtils;
import utilities.Driver;

public class Hooks extends BrowserUtils {
    @Before // Method to execute before every scenario
    public void setup() {
        // makes the window full
        Driver.getDriver().manage().window().maximize();
        System.out.println("Driver is successfully started");
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            // create screenshot of the failure
            byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // save it as an image
            scenario.attach(data, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

}
