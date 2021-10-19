package ApiTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.executors.MainApiTestExecutor;

public class LoginTests extends MainApiTestExecutor {

    @Test
    public void login(){
        mainApiManager.loginApi().setSessionId();
        String sessionId = mainApiManager.loginApi().getSession();
        Assert.assertTrue(sessionId != null);
    }
    @Test
    public void receiveContracts(){
        mainApiManager.contractsApi().getContractsList();
    }
}
