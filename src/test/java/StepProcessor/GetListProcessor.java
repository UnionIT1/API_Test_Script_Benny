package StepProcessor;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class GetListProcessor extends StepData {



    public void getAPIEndpoint() throws Exception {
       baseurl ="https://jsonplaceholder.typicode.com/todos";
        System.out.println(" the value of url is " + baseurl);

    }

    public Response getResponse() {

        response = given().get(baseurl);
        System.out.println("response: " + response.prettyPrint());
        return response;
    }

    public void validateStatuscode(int statuscodeval){
       json = response.then().statusCode(statuscodeval);
        System.out.println("the response code is " + response.statusCode());
        Assert.assertEquals(statuscodeval, response.statusCode());

    }

    public boolean validateCorrectNumberofRecordsReturned(int expectedrecords){
        List<String> jsonResponse = response.jsonPath().getList("$");
        System.out.println("\n");
        System.out.println("The number of records returned is "+jsonResponse.size());
        if(expectedrecords==jsonResponse.size()){
            return true;
        }else{
            return false;
        }
    }





    public void checkGetResponseData() throws IOException, ParseException {
        JsonPath jsonPathEvaluator = response.jsonPath();

        response.then().assertThat().body("id", is(jsonPathEvaluator.get("id"))).and().
                body("title", is(jsonPathEvaluator.get("title"))).and().
                body("userId", is(jsonPathEvaluator.get("userId"))).and().
                body("completed", is(jsonPathEvaluator.get("completed")));

        System.out.println("the value for id is "+jsonPathEvaluator.get("id"));
        System.out.println("the value for title is "+jsonPathEvaluator.get("title"));


    }






    public Response getResponseForId(int id_val ){
        baseurl = baseurl+"/"+id_val;
        response = given().get(baseurl);
        System.out.println("response: " + response.prettyPrint());
        return response;



    }

    public void checkfornullGetResponseData() throws IOException, ParseException {
        JsonPath jsonPathEvaluator = response.jsonPath();

        response.then().assertThat().body("id", is(notNullValue())).and().
                body("title", is(notNullValue())).and().
                body("userId", is(notNullValue())).and().
                body("completed", is(notNullValue()));

        System.out.println("the value for id is "+jsonPathEvaluator.get("id"));
        System.out.println("the value for title is "+jsonPathEvaluator.get("title"));


    }


}
