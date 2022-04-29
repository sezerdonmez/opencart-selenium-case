package us.abstracta.opencart.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {

    protected static WebDriver driver;
    private static final String url = "https://opencart.abstracta.us/";
    private static final String title = "Your Store";

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = getChromeOptions();
        driver = new ChromeDriver(options);
        navigateWebsite();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    public static void navigateWebsite() {
        driver.get(url);
        assertEquals(title, driver.getTitle(), "Can't navigate to Open Cart homepage");
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-fullscreen");
        return options;
    }
}
