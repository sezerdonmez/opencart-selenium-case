package us.abstracta.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage{


    private final By addToCartButtons = By.cssSelector("[onclick*='cart.add']");
    private final By cartText = By.cssSelector("#cart-total");
    private final By successAlertBox = By.cssSelector("[class*='alert-success']");
    private final By cartDropdown = By.id("cart");
    private final By viewCartButton = By.cssSelector("[href*='checkout/cart'] strong");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void addToCartRandomly() {
        List<WebElement> addToCartButtonList = driver.findElements(addToCartButtons);
        int cartIndex = generateRandomNumber(1);
        clickToElement(addToCartButtonList.get(cartIndex));
    }

    public String checkIfProductAddedToCart () {
        waitUntilElementLocated(cartText);
        WebElement cartSpan = driver.findElement(cartText);
        return cartSpan.getText();
    }

    public String checkSuccessAlertBoxText () {
        waitUntilElementLocated(successAlertBox);
        WebElement alertBoxSuccess = driver.findElement(successAlertBox);
        return alertBoxSuccess.getText();
    }

    public Boolean checkSuccessAlertBoxColor () {
        String greenRgbaColorCode = "rgba(60, 118, 61, 1)";
        WebElement alertBoxSuccess = driver.findElement(successAlertBox);
        return greenRgbaColorCode.equals(alertBoxSuccess.getCssValue("color"));
    }

    public void clickOnCartDropdown () {
        WebElement cart = driver.findElement(cartDropdown);
        clickToElement(cart);
    }

    public Boolean checkIfCartDropdownOpened () {
        WebElement cart = driver.findElement(cartDropdown);
        return cart.getAttribute("class").contains("open");
    }

    public void clickOnViewCartButton () {
        waitUntilElementLocated(viewCartButton);
        WebElement viewCart = driver.findElement(viewCartButton);
        clickToElement(viewCart);
    }
}
