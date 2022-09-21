package us.abstracta.opencart.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import us.abstracta.opencart.driver.Driver;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.List;

public class BasePage {
    private final Driver driver;

    public BasePage(Driver driver) {
        this.driver = driver;
    }

    public Boolean isDisplayed(By by) {
        return (driver.findElement(by).isDisplayed());
    }

    public int generateRandomNumber (int size) {
        Random random = new Random();
        return random.nextInt(size);
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

    public String generateRandomString (int length, boolean isIncludeNumbers, boolean isIncludeLetters) {
        return RandomStringUtils.random(length, isIncludeLetters, isIncludeNumbers);
    }

    public String generateRandomEmail (int length, boolean isIncludeNumbers, boolean isIncludeLetters) {
        String randomKeyword = RandomStringUtils.random(length, isIncludeLetters, isIncludeNumbers);
        return randomKeyword + "@sezermail.com";
    }

   /* public void waitAjaxRequest() throws InterruptedException {
        while (true) {
            Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
            if (ajaxIsComplete){
                break;
            }
            Thread.sleep(100);
        }
    }*/
}
