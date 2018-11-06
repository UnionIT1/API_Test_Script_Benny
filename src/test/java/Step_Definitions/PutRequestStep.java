package Step_Definitions;

import StepProcessor.PutRequestProcessor;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PutRequestStep {

    public PutRequestProcessor putRequestProcessor = new PutRequestProcessor();

    @When("^I make a call to update a todo list$")
    public void iMakeACallToUpdateATodoList() throws Throwable {
        putRequestProcessor.updateRerquest();
    }

    @Then("^I am able to successfully update the record and get a response code of (.*)$")
    public void iAmAbleToSuccessfullyUpdateTheRecordAndGetAResponseCodeOf(int arg0) throws Throwable {
        putRequestProcessor.validatePutRequest();
    }
}
