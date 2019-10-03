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
    private String _userId = null;


    @Test
    public void GetUserId() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        RestAssured.basePath = "users";
        given().contentType(ContentType.JSON);
        String path = RestAssured.baseURI + RestAssured.basePath+"?username=Samantha";
        _response = get(path);
        _jsonPath = new JsonPath(_response.asString());
        _userId = _jsonPath.get("id").toString();
    }

    @Test
    public void GetAllRelatedPosts(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        RestAssured.basePath = "posts";
        given().contentType(ContentType.JSON);
        String path = RestAssured.baseURI + RestAssured.basePath+"?userId="+_userId;
        _response = get(path);
        _jsonPath = new JsonPath(_response.asString());
        _userId = _jsonPath.get("id").toString();
    }
}
