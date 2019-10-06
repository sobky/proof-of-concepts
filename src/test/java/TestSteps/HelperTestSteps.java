package TestSteps;

import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import utils.Utilities;

import static org.junit.Assert.assertEquals;

public class HelperTestSteps {
    Response _response;
    JSONObject jsonObject;
    JSONArray jsonArray;

    public JSONArray getUserDetails(String value ){
        Utilities.setBasePath("users");
        Utilities.addParameter("username", value);
        _response = Utilities.getAPIResponse();
        return Utilities.parseJsonArray(_response.asString());

    }

    public void assertObject(JSONArray _object, int expected){
        assertEquals("An error has occurred while getting your response!",expected,_object.length());
    }

    public String getUserId(JSONArray userDetails){
        return userDetails.getJSONObject(0).get("id").toString();
    }

    public JSONArray getUserPosts(String userId){

        Utilities.setBasePath("posts");
        Utilities.addParameter("userId",userId);
        _response = Utilities.getAPIResponse();
        jsonArray = Utilities.parseJsonArray(_response.asString());
        return jsonArray;
    }

    public JSONArray getPostsComments(JSONArray posts){
        Utilities.setBasePath("comments");
        JSONArray comments = new JSONArray();
        for (int i = 0; i < posts.length(); i++) {
            Utilities.addParameter("postId",posts.getJSONObject(i).get("id").toString());
            _response = Utilities.getAPIResponse();
            JSONArray commentsJson = Utilities.parseJsonArray(_response.asString());
            for (int j = 0; j < commentsJson.length(); j++) {
                comments.put(commentsJson.getJSONObject(j));
            }
        }
        return comments;
    }

    public void assertEmailValidation(JSONArray comments, boolean expected){
        for (int i = 0; i<comments.length(); i++){
            Assert.assertEquals("Email "+ comments.getJSONObject(i).get("email").toString()  +" is not valid", expected,isValidEmail(comments.getJSONObject(i).get("email").toString()));
        }
    }



    private boolean isValidEmail(String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }


}
