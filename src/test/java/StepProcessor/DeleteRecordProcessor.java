package StepProcessor;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class DeleteRecordProcessor extends StepData {



    public Response deleteRecord(){

        response = given().when().delete("https://jsonplaceholder.typicode.com/todos/25");
        return response;
    }

    public void getStatusCode(int statucodeval){

        // json = response.then().statusCode(200);
        Assert.assertEquals(statucodeval, response.statusCode());
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(null, jsonPathEvaluator.get("id"));

    }


}
