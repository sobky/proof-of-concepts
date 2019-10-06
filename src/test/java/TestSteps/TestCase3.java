package TestSteps;

import org.junit.Test;
import utils.Utilities;

public class TestCase3 extends TestCaseBase{

    public TestCase3() {
        super("http://my-json-server.typicode.com/sobky/proof-of-concepts/");
    }




    @Test
    public void run() {
        _userDetails = _helper.getUserDetails("Jane");
        _helper.assertObject(_userDetails, 1);
        _userId = _helper.getUserId(_userDetails);
        Utilities.resetBasePath();
        _userPosts = _helper.getUserPosts(_userId);
        _helper.assertObject(_userPosts, 0);
    }




}
