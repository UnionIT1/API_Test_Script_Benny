package Step_Definitions;

import StepProcessor.DeleteRecordProcessor;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteRecordStep {
    public DeleteRecordProcessor deleteRecordProcessor = new DeleteRecordProcessor();

    @When("^I make a API call to delete a record$")
    public void iMakeAAPICallToDeleteARecord() throws Throwable {
        deleteRecordProcessor.deleteRecord();
    }

    @Then("^I am able to successfully delete the record and get a response code of (.*)$")
    public void iAmAbleToSuccessfullyDeleteTheRecordAndGetAResponseCodeOf(int arg0) throws Throwable {
        deleteRecordProcessor.getStatusCode(arg0);
    }
}
