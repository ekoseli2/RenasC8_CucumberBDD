package studyHall.stepsDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;

public class ebaySteps extends BrowserUtils {

    @Given("That user wants to navigate to website as {string}")
    public void that_user_wants_to_navigate_to_website_as(String url) {
        Driver.getDriver().get(url);
        staticWait(2);
    }
    @Then("The user wants to verify all the dasboard headers as following")
    public void the_user_wants_to_verify_all_the_dasboard_headers_as_following(DataTable dataTable) {
        List<String> expectedTabs=dataTable.asList(String.class);



    }
}
