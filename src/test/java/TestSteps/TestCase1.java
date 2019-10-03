package TestSteps;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import utils.utilities;

public class TestCase1 {
    private static final String baseUri = "https://jsonplaceholder.typicode.com/";
    private String _userId = null;
    private Response _response = null;
    private JsonPath jsonObject = null;
    private JsonObjectDeserializer _jsonDeserialier = null;
    @Before
    public void configure(){
        utilities.setBaseUri(baseUri);
        utilities.setAPIContentType(ContentType.JSON);
    }

    @Test
    public void getUserId(){
        utilities.setBasePath("users");
        utilities.addParameter("username", "Samantha");
        _response = utilities.getAPIResponse();
        jsonObject = utilities.getJsonObject(_response);
        _userId = utilities.deserializeObject(jsonObject,"id");
        System.out.println(_userId);
    }
}
