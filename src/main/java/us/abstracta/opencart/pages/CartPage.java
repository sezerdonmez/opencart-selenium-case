package us.abstracta.opencart.pages;

import org.openqa.selenium.By;
import us.abstracta.opencart.driver.Driver;

public class CartPage extends BasePage {

    private final By goCheckoutButton = By.cssSelector("[class='pull-right']");

    public CartPage(Driver driver) {
        super(driver);
    }

    public void clickOnCheckoutButton () {
        clickElementBy(goCheckoutButton, true, false);
    }
}
