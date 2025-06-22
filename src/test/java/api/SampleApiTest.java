package api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleApiTest extends ApiBase {
    @Test
    public void getUserTest() {
        Response response = getRequest()
                .get("/api/users/2");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
