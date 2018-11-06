package Step_Definitions;

import StepProcessor.GetListProcessor;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class GetListStep {

    public GetListProcessor getListProcessor = new GetListProcessor();



    @Given("^I am able to access the API Endpoint$")
    public void iAmAbleToAccessTheAPIEndpoint() throws Throwable {
        getListProcessor.getAPIEndpoint();
    }

    @When("^I call to get the list of all todos$")
    public void iCallToGetTheListOfAllTodos() throws Throwable {
        getListProcessor.getResponse();
    }

    @Then("^I get the status code of value (.*) and the number of records returned as (.*)$")
    public void iGetTheStatusCodeOfValueTest_Status_CodeAndTheNumberOfRecordsReturnedAsNumber_of_Records_Returned(int statuscodeval, int record_returned) throws Throwable {
        getListProcessor.validateStatuscode(statuscodeval);
        Assert.assertTrue(getListProcessor.validateCorrectNumberofRecordsReturned(record_returned));
        getListProcessor.checkGetResponseData();
    }

    @Then("^I get the status code of value (.*) and validates the body of the response data for any null values$")
    public void iGetTheStatusCodeOfValueAndValidatesTheBodyOfTheResponseDataForAnyNullValues(int arg0) throws Throwable {
        getListProcessor.validateStatuscode(arg0);
        getListProcessor.checkfornullGetResponseData();
    }

    @When("^I call to get a particular todo list for id (.*)$")
    public void iCallToGetAParticularTodoListForId(int arg0) throws Throwable {
        getListProcessor.getResponseForId(arg0);
    }

    @Then("^I get the response code of value (.*) and one record of todo list$")
    public void iGetTheResponseCodeOfValueAndOneRecordOfTodoList(int arg0) throws Throwable {
        getListProcessor.validateStatuscode(arg0);
        getListProcessor.checkGetResponseData();
    }


}
