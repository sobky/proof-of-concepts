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

        utilities.setBasePath("posts");
        utilities.addParameter("userId",userId);
        _response = utilities.getAPIResponse();
        jsonArray = utilities.parseJsonArray(_response.asString());
        return jsonArray;
    }

    public JSONArray getPostsComments(JSONArray posts){
        utilities.setBasePath("comments");
        JSONArray comments = new JSONArray();
        for (int i = 0; i < posts.length(); i++) {
            utilities.addParameter("postId",posts.getJSONObject(i).get("id").toString());
            _response = utilities.getAPIResponse();
            JSONArray commentsJson = utilities.parseJsonArray(_response.asString());
            for (int j = 0; j < commentsJson.length(); j++) {
                comments.put(commentsJson.getJSONObject(j));
            }
        }
        return comments;
    }



    public boolean isValidEmail(String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }


}
