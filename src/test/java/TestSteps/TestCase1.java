package TestSteps;

import com.jayway.restassured.http.ContentType;
import org.json.JSONArray;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.Utilities;

public class TestCase1 {
    private static final String baseUri = "https://jsonplaceholder.typicode.com/";
    private JSONArray  _userDetails = null;;
    private HelperTestSteps helper = new HelperTestSteps();

    @Before
    public void configure() {
        Utilities.setBaseUri(baseUri);
        Utilities.setAPIContentType(ContentType.JSON);
    }

    @Test
    public void run() {
        _userDetails = helper.getUserDetails("Samanth");
        helper.assertObject(_userDetails, 0);
    }

    @After
    public void afterTest(){
        Utilities.resetBasePath();
    }

    private void print(int value)
    {
        System.out.println(value);
    }




}
