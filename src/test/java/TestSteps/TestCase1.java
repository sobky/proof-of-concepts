package TestSteps;

import org.junit.Test;

public class TestCase1 extends TestCaseBase {


    public TestCase1() {
        super("https://jsonplaceholder.typicode.com/");
    }



    @Test
    public void run() {
        _userDetails = this._helper.getUserDetails("Samanth");
        this._helper.assertObject(_userDetails, 0);
    }



}
