package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import java.util.Map;

public class ApiUtils {
    private static Response response;
    public static void get(String url) {
        response = RestAssured.get(url);
    }
    public static void getWithParams(String url, Map<String, Object> data) {
        response = given().contentType(ContentType.JSON)
                .params(data)
                .get(url);
    }
    public static void post(String url, Map<String, Object> data) {
        JSONObject obj = new JSONObject(data);

        response = given()
                   .header("Content-type", Enums.ContentTypes.TYPE_JSON.get())
                   .and()
                   .body(obj.toJSONString())
                   .when()
                   .post(url)
                   .then()
                   .extract().response();
    }
    public static int getStatusCode() {
        return response.getStatusCode();
    }
    public static String getContentType() {
        return response.getContentType();
    }
    public static String getResponseBody() {
        return response.asString();
    }
}
