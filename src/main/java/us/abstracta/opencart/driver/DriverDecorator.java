package us.abstracta.opencart.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;

import java.util.List;

public class DriverDecorator extends Driver {
    protected final Driver driver;

    public DriverDecorator(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void start(Browser browser) {
        driver.start(browser);
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public void goToUrl(String url) {
        driver.goToUrl(url);
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    @Override
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    @Override
    public void waitForAjax() {
        driver.waitForAjax();
    }

    @Override
    public void hoverToElement(WebElement element) {
        driver.hoverToElement(element);
    }

    @Override
    public void highlightElement(WebElement element) {
        driver.highlightElement(element);
    }

    @Override
    public void waitUntilElementVisible(By locator) {
        driver.waitUntilElementVisible(locator);
    }

    @Override
    public void wait(int sec) throws InterruptedException {
        driver.wait(sec);
    }
}
