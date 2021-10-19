package requestsApi;

import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.HttpDelete;
import utils.Managers.PropertiesManager;
import utils.SpecBuilder;

import static io.restassured.RestAssured.*;
import static java.lang.String.format;

public class ContractsApi {
    protected RequestSpecification baseSpec;

    protected static final String LOGON_NAME = PropertiesManager.getProperty("user.logon_name");

    public ContractsApi(RequestSpecification baseSpec) {

        this.baseSpec = baseSpec;
    }

    public String getContracts() {
        /*
        RequestSpecification customSpec = SpecBuilder.newBuilder(baseSpec)
                .addSessionId(sessionId)
                .build();


         */
        return given()
                .spec(baseSpec)
                .header("X-Session-Id", )
                .expect().statusCode(200)
                .when().post(format("/v2/legal/users/%s/contracts", LOGON_NAME))
                .then().extract().jsonPath().getString("data.id");
    }

    public String getContractsList(){
        String a = getContracts();
        System.out.println(getContracts());
        return a;
    }
}
