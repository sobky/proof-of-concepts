package TestSteps;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

public class UserDetails {
    private Response _response = null;
    private JsonPath _jsonPath = null;


    @Test
    public void GetAllEmails() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        RestAssured.basePath = "users";
        given().contentType(ContentType.JSON);
        String path = RestAssured.baseURI + RestAssured.basePath+"?username=Samantha";
        _response = get(path);
        _jsonPath = new JsonPath(_response.asString());
        System.out.println(_jsonPath.get().toString());
        System.out.println(_jsonPath.get("address").toString());
    }
}
