package requestsApi;

import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import utils.Managers.PropertiesManager;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static utils.helpers.Helper.receiveDecodedJWTAsString;

public class LoginApi {
    protected RequestSpecification baseSpec;
    protected JSONObject jsonResponse;

    protected static final String DEVICE_ID = PropertiesManager.getProperty("user.device_id");
    protected static final String LOGON_NAME = PropertiesManager.getProperty("user.logon_name");
    protected static final String ACCESS_MODE = PropertiesManager.getProperty("user.access_mode");

    protected String session_id;

    public LoginApi(RequestSpecification baseSpec) {

        this.baseSpec = baseSpec;
    }

    public String getSession(){

        return session_id;
    }

    public String setSessionId(){
        jsonResponse = new JSONObject(receiveDecodedJWTAsString(startSession()));
        session_id = jsonResponse.getString("session_id");
        return session_id;
    }

    public String startSession() {
        return given()
                .spec(baseSpec)
                .formParam("device_id", DEVICE_ID)
                .formParam("access_mode", ACCESS_MODE)
                .expect().statusCode(200)
                .when().post(format("/v2/legal/users/%s/sessions/by/appkey", LOGON_NAME))
                .then().extract().jsonPath().getString("data");
    }
}
