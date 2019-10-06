package TestSteps;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.Utilities;

public class TestCase1 {
    private static final String baseUri = "https://jsonplaceholder.typicode.com/";
    private String _userId = null;
    private JSONArray  _userDetails = null;
    private Response _response = null;
    private JSONArray _userPosts;
    private JSONArray _comments;
    private JsonPath jsonObject = null;
    private HelperTestSteps helper = new HelperTestSteps();

    @Before
    public void configure() {
        Utilities.setBaseUri(baseUri);
        Utilities.setAPIContentType(ContentType.JSON);
    }

    @Test
    public void run() {
        _userDetails = helper.getUserDetails("Samanth");
        helper.assertUserDetails(_userDetails, 0);
        /*Utilities.resetBasePath();
        _userPosts = helper.getUserPosts(_userId);
        Utilities.resetBasePath();
        _comments = helper.getPostsComments(_userPosts);

        for (int i = 0; i<_comments.length(); i++){
            System.out.println(_comments.getJSONObject(i).get("email").toString());
            Assert.assertEquals("Email is not valid", true,helper.isValidEmail(_comments.getJSONObject(i).get("email").toString()));
        }*/

    }

    @After
    public void afterTest(){

    }

    private void print(int value)
    {
        System.out.println(value);
    }




}
