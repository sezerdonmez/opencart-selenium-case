package us.abstracta.opencart.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import us.abstracta.opencart.driver.Driver;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.List;
import java.util.UUID;

public class BasePage {
    protected final Driver driver;

    public BasePage(Driver driver) {
        this.driver = driver;
    }

    public Boolean isDisplayed (By by) {
        return (driver.findElement(by).isDisplayed());
    }

    public Boolean isSelected (By by) {
       return driver.findElement(by).isSelected();
    }

    public void clickElementBy (By by, boolean isWithHover, boolean isWithHighlight) {
        WebElement elementToClick = driver.findElement(by);
        if (isWithHover)
            driver.hoverToElement(elementToClick);
        if (isWithHighlight)
            driver.highlightElement(elementToClick);
        elementToClick.click();
    }

    public int generateRandomNumber (int size) {
        Random random = new Random();
        return random.nextInt(size);
    }

    public WebElement getElementWithTextInList (List<WebElement> elementList, final String text) {
        boolean isElementHere = false;
        int indexOfElement = 0;
        for (int i = 0; i <= elementList.size(); i++) {
            if (elementList.get(i).getText().equals(text)) {
                indexOfElement = i;
                isElementHere = true;
                break;
            }
        }
        assertTrue(isElementHere, "Element not found with text: " + text);
        return elementList.get(indexOfElement);
    }

    public String generateRandomString (int length, boolean isIncludeNumbers, boolean isIncludeLetters) {
        return RandomStringUtils.random(length, isIncludeLetters, isIncludeNumbers);
    }

    public String generateRandomEmail () {
        UUID uuid = UUID.randomUUID();
        return uuid + "@opencartrandommail.com";
    }

    public void typeTextToElement (By by, String text) {
        WebElement elementToTypeText = driver.findElement(by);
        elementToTypeText.clear();
        assertEquals("", elementToTypeText.getText(), "Element should not have any text.");
        elementToTypeText.sendKeys(text);
        assertEquals(text, elementToTypeText.getAttribute("value"), "Element should have text: " + text);
    }
    public void selectWithTextOnSelectBox (By by, String text) {
        WebElement selectBox = driver.findElement(by);
        Select select = new Select(selectBox);
        select.selectByVisibleText(text);
        WebElement selectedOption = select.getFirstSelectedOption();
        assertEquals(text, selectedOption.getText(), "Selected option should be " + text);
    }

    public String getElementText (By by) {
        WebElement element = driver.findElement(by);
        return element.getText();
    }

    public String getCssValue (By by, String cssProp) {
        WebElement element = driver.findElement(by);
        return element.getCssValue(cssProp);
    }

    public String getElementAttribute (By by, String attributeName) {
        WebElement element = driver.findElement(by);
        return element.getAttribute(attributeName);
    }

    public String getCurrentPageTitle () {
        return driver.getTitle();
    }
}
