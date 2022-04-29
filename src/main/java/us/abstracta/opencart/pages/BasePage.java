package us.abstracta.opencart.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.List;

public class BasePage {

    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public Boolean isDisplayed(By by) {
        return (driver.findElement(by).isDisplayed());
    }

    public int generateRandomNumber (int size) {
        Random random = new Random();
        return random.nextInt(size);
    }

    public void clickToElement (WebElement element) {
        hoverToElement(element);
        highlightElement(element);
        element.click();
    }

    public void highlightElement (WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.background='yellow'",element);
    }

    public void waitUntilElementLocated (By by) {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitUntilElementVisible (By by) {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilPageLoaded() {

        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void wait (int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
        System.out.println("Waited " + seconds + " seconds.");
    }

    public int getElementWithTextInList (List<WebElement> elementList, final String text) {

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
        return indexOfElement;
    }

    public void hoverToElement (WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }

    public String getCurrentPageTitle () {
        return driver.getTitle();
    }

    public String generateRandomString (int length, boolean isIncludeNumbers, boolean isIncludeLetters) {
        return RandomStringUtils.random(length, isIncludeLetters, isIncludeNumbers);
    }

    public String generateRandomEmail (int length, boolean isIncludeNumbers, boolean isIncludeLetters) {
        String randomKeyword = RandomStringUtils.random(length, isIncludeLetters, isIncludeNumbers);
        return randomKeyword + "@sezermail.com";
    }

    public void waitAjaxRequest() throws InterruptedException {
        while (true) {
            Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
            if (ajaxIsComplete){
                break;
            }
            Thread.sleep(100);
        }
    }
}
