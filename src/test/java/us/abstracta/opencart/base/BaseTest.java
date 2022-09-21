package us.abstracta.opencart.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import us.abstracta.opencart.driver.CoreDriver;
import us.abstracta.opencart.driver.Driver;

import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {

    private Driver driver;
    private static final String url = "https://opencart.abstracta.us/";
    private static final String title = "Your Store";

    @BeforeAll
    public void testInit() {
        driver = new CoreDriver();
        driver.start(Browser.CHROME);
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

    public void navigateWebsite() {
        driver.goToUrl(url);
        assertEquals(title, driver.getTitle(), "Can't navigate to Open Cart homepage");
    }
}
