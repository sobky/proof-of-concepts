package TestSteps;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.Utilities;

public class TestCase3 {
    private static final String baseUri = "https://jsonplaceholder.typicode.com/";
    private String _userId = null;
    private JSONArray  _userDetails = null;
    private Response _response = null;
    private JSONArray _userPosts ;
    private JSONArray _comments;
    private HelperTestSteps helper = new HelperTestSteps();

    @Before
    public void configure() {
        Utilities.setBaseUri(baseUri);
        Utilities.setAPIContentType(ContentType.JSON);
    }

    @Test
    public void run() {
        _userDetails = helper.getUserDetails("Samantha");
        helper.assertObject(_userDetails, 1);
        _userId = helper.getUserId(_userDetails);
        Utilities.resetBasePath();
        _userPosts = helper.getUserPosts("11");
        helper.assertObject(_userPosts, 0);
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
