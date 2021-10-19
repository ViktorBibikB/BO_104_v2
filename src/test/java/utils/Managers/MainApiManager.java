package utils.Managers;

import io.restassured.specification.RequestSpecification;
import requestsApi.ContractsApi;
import requestsApi.LoginApi;

public class MainApiManager {
    private RequestSpecification baseSpec;
    private LoginApi loginApi;
    private ContractsApi contractsApi;

    public MainApiManager(RequestSpecification spec) {

        this.baseSpec = spec;
    }

    public LoginApi loginApi() {
        if (loginApi == null) {
            loginApi = new LoginApi(baseSpec);
        }
        return loginApi;
    }
    public ContractsApi contractsApi() {
        if (contractsApi == null) {
            contractsApi = new ContractsApi(baseSpec);
        }
        return contractsApi;
    }

}
