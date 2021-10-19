package utils.executors;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import utils.Managers.MainApiManager;
import utils.SpecBuilder;

public abstract class MainApiTestExecutor {

    static {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
    protected RequestSpecification baseSpec;
    protected MainApiManager mainApiManager;


    @BeforeMethod(alwaysRun = true)
    public void configureRestAssured() {
        baseSpec = SpecBuilder.newBuilder().addApiKey().build();
        mainApiManager = new MainApiManager(baseSpec);
    }

}
