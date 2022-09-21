package us.abstracta.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import us.abstracta.opencart.driver.Driver;

public class OrderSuccessPage extends BasePage {

    private final By successContent = By.id("content");

    public OrderSuccessPage(Driver driver) {
        super(driver);
    }

    public void waitUntilContentVisible() {
        waitUntilElementVisible(successContent);
    }
}
