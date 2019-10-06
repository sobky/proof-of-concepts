package TestSteps;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.Utilities;

public class TestCase4 {
    private static final String baseUri = "http://my-json-server.typicode.com/sobky/proof-of-concepts/";
    private String _userId = null;
    private JSONArray  _userDetails = null;
    private Response _response = null;
    private JSONArray _userPosts;
    private JSONArray _comments;
    private HelperTestSteps helper = new HelperTestSteps();

    @Before
    public void configure() {
        Utilities.setBaseUri(baseUri);
        Utilities.setAPIContentType(ContentType.JSON);
    }

    @Test
    public void run() {
        _userDetails = helper.getUserDetails("Sarah");
        helper.assertObject(_userDetails, 1);
        _userId = helper.getUserId(_userDetails);
        Utilities.resetBasePath();
        _userPosts = helper.getUserPosts(_userId);
        helper.assertObject(_userPosts, 2);
        Utilities.resetBasePath();
        _comments = helper.getPostsComments(_userPosts);
        helper.assertObject(_comments,0);



    }

    @After
    public void afterTest(){
        //Utilities.resetBasePath();
    }

    private void print(int value)
    {
        System.out.println(value);
    }




}
