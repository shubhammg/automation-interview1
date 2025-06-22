package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleWebTest extends BaseTest {
    @Test
    public void validateTitle() {
        driver.get("https://google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }
}
