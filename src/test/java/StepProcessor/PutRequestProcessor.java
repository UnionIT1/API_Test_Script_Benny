package StepProcessor;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PutRequestProcessor extends StepData {


    public Map<String, String> map = new HashMap<String, String>();

    public Response updateRerquest(){

        map.put("id", "25");
        map.put("title", "foo");
        map.put("body", "bar");
        response = given().when().contentType("application/JSON").body(map).put("https://jsonplaceholder.typicode.com/todos/25");
        return response;

    }

    public void validatePutRequest(){

        response.then().statusCode(200);
        Assert.assertEquals(200, response.statusCode());
        JsonPath jsonPathEvaluator = response.jsonPath();
        System.out.println(" the value is "+ map.get("title"));
        System.out.println(" the value for jasonpath is "+ jsonPathEvaluator.get("title"));
        System.out.println("response: " + response.prettyPrint());

        Assert.assertEquals(map.get("title"), jsonPathEvaluator.get("title"));
        Assert.assertEquals(map.get("body"), jsonPathEvaluator.get("body"));
        Assert.assertEquals(map.get("id"), jsonPathEvaluator.get("id").toString());





    }

}
