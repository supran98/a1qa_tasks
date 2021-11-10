package Utils;

import Utils.Enums.StatusCodes;
import io.restassured.http.ContentType;
import java.io.File;
import static io.restassured.RestAssured.given;

public class ApiUtils {
    public static String get(String uri) {
        return given().contentType(ContentType.JSON)
                .when().get(uri)
                .then().statusCode(StatusCodes.OK.get())
                .extract().response().asString();
    }
    public static String post(String uri) {
        return given().contentType(ContentType.JSON)
                .when().post(uri)
                .then().extract().response().asString();
    }
    public static String uploadPhoto(String upload_url, File photo) {
        return given().multiPart("photo", photo)
                .when()
                .post(upload_url)
                .then().extract().response().asString();
    }
    public static String postAttachments(String uri, String attachments) {
        return given().multiPart("attachments", attachments)
                .when().post(uri)
                .then().extract().response().asString();
    }
    public static String postPhoto(String uri, String photo, String server, String hash) {
        return given().multiPart("photo", photo).multiPart("server", server).multiPart("hash", hash)
                .when().post(uri)
                .then().extract().response().asString();
    }
}
