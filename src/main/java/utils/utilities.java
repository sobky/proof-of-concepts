package utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;


public class utilities {
    public static String queryParameter;
    public static String path;

    public static void setBaseUri(String baseUri){
        RestAssured.baseURI = baseUri;
    }

    public static void setBasePath(String basePath){
        RestAssured.basePath = basePath;
    }

    public static void addParameter(String parameterKey, String parameterValue){
        path = RestAssured.baseURI + RestAssured.basePath + "?" + parameterKey + "=" + parameterValue;
    }

    public static Response getAPIResponse(){
        return get(path);
    }

    public static void setAPIContentType(ContentType type){
        given().contentType(type);
    }

    public static JsonPath getJsonObject(Response response){
        return new JsonPath(response.asString());
    }

    public static String deserializeObject(JsonPath jsonObject, String key){
        return jsonObject.get(key).toString();
    }
}
