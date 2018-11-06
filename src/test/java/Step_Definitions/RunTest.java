package Step_Definitions;
import com.github.mkolisnyk.cucumber.runner.AfterSuite;
import com.github.mkolisnyk.cucumber.runner.BeforeSuite;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/site/cucumber.json",
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        //jsonUsageReport = "/Users/unionit/IdeaProjects/Rest_API_Testing_Benny/target/cucumber-usage.json",
        usageReport = true,
        toPDF = true,
        outputFolder = "target/site")
@CucumberOptions(strict = false, features = {"src/test/resources/Features"}, format = { "pretty",
        "html:target/site/cucumber-pretty",
        "json:target/site/cucumber.json",
        "rerun:target/rerun.txt" },monochrome = true, tags = { "@API" })


public class RunTest {
    @BeforeSuite
    public static void setUp() {
        System.out.println("The API tests are going to be executed ");
    }
    @AfterSuite
    public static void tearDown() {
        System.out.println("Finishing the API Test Execution");
    }
}


