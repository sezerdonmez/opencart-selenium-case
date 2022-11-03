package us.abstracta.opencart.base;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import us.abstracta.opencart.driver.CoreDriver;
import us.abstracta.opencart.driver.Driver;
import us.abstracta.opencart.pages.*;

import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {

    protected Driver driver;
    private static final String URL = "https://opencart.abstracta.us/";
    private static final String TITLE = "Your Store";

    public static BasePage basePage;
    public static CartPage cartPage;
    public static HomePage homePage;
    public static CheckoutPage checkoutPage;
    public static OrderSuccessPage orderSuccessPage;

    @BeforeMethod
    public void testInit() {
        driver = new CoreDriver();
        driver.start(Browser.CHROME);
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderSuccessPage = new OrderSuccessPage(driver);
        navigateWebsite();
    }

    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
    public void navigateWebsite() {
        driver.goToUrl(URL);
        assertEquals(TITLE, driver.getTitle(), "Can't navigate to Open Cart homepage");
    }
}
