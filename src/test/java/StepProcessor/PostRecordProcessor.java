package StepProcessor;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PostRecordProcessor extends StepData {


    public void checkPostResponseData() throws IOException, ParseException {
        String filepath = "src/test/resources/Payloads/createrecord.json";
        FileReader reader = new FileReader(filepath);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

        String body_val = (String) jsonObject.get("body");
        System.out.println(" the post body value is " + body_val);

        String title_val = (String) jsonObject.get("title");
        System.out.println(" the post title value is "+ title_val);

        long id_val = (Long) jsonObject.get("id");
        System.out.println(" the post id value is "+ id_val);




        JsonPath jsonPathEvaluator = response.jsonPath();


        Assert.assertEquals(body_val, jsonPathEvaluator.get("body"));
        Assert.assertEquals(title_val, jsonPathEvaluator.get("title"));
        Assert.assertEquals((int)id_val, jsonPathEvaluator.get("id"));



    }

    public ResponseBody sendRequest() throws IOException, ParseException {
        String jsonbody = postRequest();

        response = given().when().contentType(ContentType.JSON).body(jsonbody).post("https://jsonplaceholder.typicode.com/todos");

        System.out.println("\n");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());

        return response;

    }

    public String postRequest() throws IOException, ParseException {
        JSONObject data = readJsonpayloadData();


        String json_string = data.toJSONString();
        System.out.println(" Read Json String "+ json_string);
        return json_string;

    }


    public JSONObject readJsonpayloadData() throws IOException, ParseException {

        String filepath = "src/test/resources/Payloads/createrecord.json";
        JSONParser parser = new JSONParser();
        JSONObject data = (JSONObject) parser.parse(new FileReader(filepath));

        return data;

    }

    public void validateStatuscode(int statuscodeval){
        json = response.then().statusCode(statuscodeval);
        System.out.println("the response code is " + response.statusCode());
        Assert.assertEquals(statuscodeval, response.statusCode());

    }


}
