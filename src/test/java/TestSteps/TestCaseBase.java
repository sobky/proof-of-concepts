package TestSteps;

import com.jayway.restassured.http.ContentType;
import org.json.JSONArray;
import org.junit.After;
import org.junit.Before;
import utils.Utilities;

public class TestCaseBase {

    public String _baseUri;
    public JSONArray _userDetails;
    public HelperTestSteps _helper;
    public String _userId;
    public JSONArray _userPosts;
    public JSONArray _comments;

    public TestCaseBase(String baseUri){
        this._baseUri = baseUri;
        this._helper = new HelperTestSteps();
    }

    @Before
    public void configure() {
        Utilities.setBaseUri(this._baseUri);
        Utilities.setAPIContentType(ContentType.JSON);
    }

    @After
    public void afterTest(){
    }

}
