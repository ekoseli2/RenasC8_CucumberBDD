package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // We are integrating JUnit to run with Cucumber's feature files
// Integrate the JUnit Assertions and scenarios of Cucumber
@CucumberOptions(
        features = "@target/rerun.txt",                         // This will help us to read Failed Scenarios from rerun.txt so that we can run them
        glue = "stepDefinitions",                                  // location of your step definitions (copy source root)
        dryRun = false,                                                   // we will not run undefined steps
        plugin = {
                "pretty",                                                               // This will help us to have a more understandable console output
                "html:target/default-cucumber-reports.html",    // We use this to generate HTML reports after each run
                "json:target/cucumber.json",                             //We use this to generate JSON reports after each run
                "rerun:target/rerun.txt"
        /*
        This will help us to store failed scenarios from different feature files at each run so
        that we can run only failed scenarios. We will be reading failed scenarios from rerun.txt
         file located under target folder
         */
        }
)
public class FailedRunner {
}
