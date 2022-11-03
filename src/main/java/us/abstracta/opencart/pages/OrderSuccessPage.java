package us.abstracta.opencart.pages;

import com.sun.security.auth.NTSidUserPrincipal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import us.abstracta.opencart.driver.Driver;

public class OrderSuccessPage extends BasePage {

    private final By successContent = By.id("content");
    private final By breadcrumbSuccess = By.cssSelector("[href*='/success']");

    public OrderSuccessPage(Driver driver) {
        super(driver);
    }

    public void waitUntilSuccessBreadcrumbVisible() {
        driver.waitUntilElementVisible(breadcrumbSuccess);
    }
}
