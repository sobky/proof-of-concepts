package TestSteps;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import utils.utilities;

public class TestCase1 {
    private static final String baseUri = "https://jsonplaceholder.typicode.com/";
    private String _userId = null;
    private Response _response = null;
    private JSONArray _userPosts;
    private JSONArray _comments;
    private JsonPath jsonObject = null;
    private HelperTestSteps helper = new HelperTestSteps();

    @Before
    public void configure() {
        utilities.setBaseUri(baseUri);
        utilities.setAPIContentType(ContentType.JSON);
    }

    @Test
    public void run() {
        _userId = helper.getUserId("Samantha");
        utilities.resetBasePath();
        _userPosts = helper.getUserPosts(_userId);
        utilities.resetBasePath();
        helper.getPostsComments(_userPosts);

    }

}
