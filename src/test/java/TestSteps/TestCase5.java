package TestSteps;

import org.junit.Test;
import utils.Utilities;

public class TestCase5 extends TestCaseBase{

    public TestCase5() {
        super("http://my-json-server.typicode.com/sobky/proof-of-concepts/");
    }

    @Test
    public void run() {
        _userDetails = _helper.getUserDetails("Nicola");
        _helper.assertObject(_userDetails, 1);
        _userId = _helper.getUserId(_userDetails);
        Utilities.resetBasePath();
        _userPosts = _helper.getUserPosts(_userId);
        _helper.assertObject(_userPosts, 1);
        Utilities.resetBasePath();
        _comments = _helper.getPostsComments(_userPosts);
        _helper.assertObject(_comments,2);
        _helper.assertEmailValidation(_comments,false);
    }



}
