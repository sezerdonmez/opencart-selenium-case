package us.abstracta.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSuccessPage extends BasePage {

    private final By successContent = By.id("content");

    public OrderSuccessPage(WebDriver driver) {
        super(driver);
    }

    public void waitUntilContentVisible() {
        waitUntilElementVisible(successContent);
    }
}
