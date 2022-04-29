package us.abstracta.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private final By goCheckoutButton = By.cssSelector("[class='pull-right']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCheckoutButton () {
        WebElement checkoutButton = driver.findElement(goCheckoutButton);
        clickToElement(checkoutButton);
    }
}
