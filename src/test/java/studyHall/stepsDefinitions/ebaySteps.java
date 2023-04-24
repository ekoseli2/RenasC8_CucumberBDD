package studyHall.stepsDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import studyHall.pages.ebayPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class ebaySteps extends BrowserUtils {

    ebayPage ebayPage= new ebayPage();
    @Given("That user wants to navigate to website as {string}")
    public void that_user_wants_to_navigate_to_website_as(String url) {
        Driver.getDriver().get(url);
        staticWait(2);
    }

    @Then("The user wants to verify all the dasboard headers as following")
    public void the_user_wants_to_verify_all_the_dasboard_headers_as_following(io.cucumber.datatable.DataTable dataTable) throws Exception {

        System.out.println(dataTable);

        List<String> expectedTabs = dataTable.asList(String.class);

        System.out.println(expectedTabs);
        boolean isValuePresent= false;
        List<String> actualTabs=new ArrayList<>();

        for (String each1: expectedTabs){
            isValuePresent=false;
            for (WebElement each: ebayPage.dashboardTabs){
                actualTabs.add(each.getText());
                if (each1.equals(each.getText())){
                    Assert.assertTrue(each1.equals(each.getText()));
                    isValuePresent=true;
                    break;
                }

            }
            if (isValuePresent=true){

                System.out.println(each1+" is present in actualtabs");
            } else if (isValuePresent=false){

                throw new Exception(each1+" is not present in actual tabs");
            }
        }


    }


}
