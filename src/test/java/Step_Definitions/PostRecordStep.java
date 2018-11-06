package Step_Definitions;

import StepProcessor.PostRecordProcessor;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PostRecordStep {
    public PostRecordProcessor postRecordProcessor = new PostRecordProcessor();
    @When("^I make a call to post new todo list$")
    public void iMakeACallToPostNewTodoList() throws Throwable {
        postRecordProcessor.sendRequest();
    }

    @Then("^I am able to successfully create a record and get a response code of (.*)$")
    public void iAmAbleToSuccessfullyCreateARecordAndGetAResponseCodeOf(int arg0) throws Throwable {
        postRecordProcessor.checkPostResponseData();
        postRecordProcessor.validateStatuscode(arg0);
    }
}
