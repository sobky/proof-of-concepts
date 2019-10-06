package TestSteps;

import org.junit.Test;
import utils.Utilities;

public class TestCase2 extends TestCaseBase{

    public TestCase2() {
        super("https://jsonplaceholder.typicode.com/");
    }

    @Test
    public void run() {
        _userDetails = _helper.getUserDetails("Samantha");
        _helper.assertObject(_userDetails, 1);
        _userId = _helper.getUserId(_userDetails);
        Utilities.resetBasePath();
        _userPosts = _helper.getUserPosts(_userId);
        _helper.assertObject(_userPosts, 10);
        Utilities.resetBasePath();
        _comments = _helper.getPostsComments(_userPosts);
        _helper.assertEmailValidation(_comments, true);

    }





}
