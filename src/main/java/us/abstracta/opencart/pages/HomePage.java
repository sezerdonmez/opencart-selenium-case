package us.abstracta.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us.abstracta.opencart.driver.Driver;

import java.util.List;

public class HomePage extends BasePage {
    private final By addToCartButtons = By.cssSelector("[onclick*='cart.add']");
    private final By cartText = By.cssSelector("#cart-total");
    private final By successAlertBox = By.cssSelector("[class*='alert-success']");
    private final By cartDropdown = By.id("cart");
    private final By viewCartButton = By.cssSelector("[href*='checkout/cart'] strong");

    public HomePage(Driver driver) {
        super(driver);
    }

    public void addToCartFirstItem() {
        List<WebElement> addToCartButtonList = driver.findElements(addToCartButtons);
        addToCartButtonList.get(1).click();
    }

    public String checkIfProductAddedToCart () {
        return getElementText(cartText);
    }

    public String checkSuccessAlertBoxText () {
        return getElementText(successAlertBox);
    }

    public Boolean checkSuccessAlertBoxColor () {
        String greenRgbaColorCode = "rgba(60, 118, 61, 1)";
        return greenRgbaColorCode.equals(getCssValue(successAlertBox, "color"));
    }

    public void clickOnCartDropdown () {
        clickElementBy(cartDropdown, true, true);
    }

    public Boolean checkIfCartDropdownOpened () {
        return getElementAttribute(cartDropdown, "class").contains("open");
    }

    public void clickOnViewCartButton () {
        clickElementBy(viewCartButton, false, true);
    }
}
