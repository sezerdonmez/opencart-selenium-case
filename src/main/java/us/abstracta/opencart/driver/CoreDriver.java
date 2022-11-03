package us.abstracta.opencart.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CoreDriver extends Driver {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @Override
    public void start(Browser browser) {
        if (Browser.CHROME.equals(browser)) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if (Browser.FIREFOX.equals(browser)) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if (Browser.EDGE.equals(browser)) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        } else if (Browser.OPERA.equals(browser)) {
            WebDriverManager.operadriver().setup();
            webDriver = new OperaDriver();
        } else if (Browser.SAFARI.equals(browser)) {
            webDriver = new SafariDriver();
        } else {
            throw new IllegalArgumentException();
        }
        webDriverWait = new WebDriverWait(webDriver, 30);
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public void goToUrl(String url) {
        webDriver.navigate().to(url);
    }

    @Override
    public String getTitle() {
        return webDriver.getTitle();
    }

    @Override
    public WebElement findElement(By locator) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webDriver.findElement(locator);
    }

    @Override
    public List<WebElement> findElements(By locator) {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return webDriver.findElements(locator);
    }

    @Override
    public void waitForAjax() {
        webDriverWait.until(
                driver -> ((JavascriptExecutor) driver).executeScript("return jQuery.active").equals(0));
    }

    @Override
    public void hoverToElement(WebElement element) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element);
        Assert.isTrue(element.isDisplayed(), "Hovered element is not displayed");
    }

    @Override
    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].style.background='yellow'", element);
    }

    @Override
    public void waitUntilElementVisible(By locator) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Override
    public void waitUntilTextVisibleElement(By locator, String text) {
        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    @Override
    public void wait(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000L);
        System.out.println("Waited " + sec + " seconds.");
    }
}
