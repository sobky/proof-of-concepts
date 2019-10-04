package TestSteps;

import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.utilities;

public class HelperTestSteps {
    Response _response;
    JSONObject jsonObject;
    JSONArray jsonArray;

    public String getUserId(String value ){
        utilities.setBasePath("users");
        utilities.addParameter("username", value);
        _response = utilities.getAPIResponse();
        jsonArray = utilities.parseJsonArray(_response.asString());
        return jsonArray.getJSONObject(0).get("id").toString();
    }

    public JSONArray getUserPosts(String userId){

        utilities.resetBasePath();
        utilities.setBasePath("posts");
        utilities.addParameter("userId",userId);
        _response = utilities.getAPIResponse();
        jsonArray = utilities.parseJsonArray(_response.asString());
        return jsonArray;
    }


}
