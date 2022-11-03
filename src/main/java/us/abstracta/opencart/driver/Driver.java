package us.abstracta.opencart.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;

import java.util.List;

public abstract class Driver {

    public abstract void start(Browser browser);
    public abstract void quit();
    public abstract void goToUrl(String url);
    public abstract String getTitle();
    public abstract WebElement findElement(By locator);
    public abstract List<WebElement> findElements(By locator);
    public abstract void waitForAjax();
    public abstract void hoverToElement(WebElement element);
    public abstract void highlightElement(WebElement element);

    public abstract void waitUntilElementVisible (By locator);
    public abstract void wait(int sec) throws InterruptedException;
}
