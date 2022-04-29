package us.abstracta.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage extends BasePage {

    private final By guestRadioButton = By.cssSelector("input[value='guest']");
    private final By registerRadioButton = By.cssSelector("input[value='register']");
    private final By continueButton = By.cssSelector("#button-account");
    private final By firstNameInput = By.name("firstname");
    private final By lastnameInput = By.name("lastname");
    private final By emailInput = By.cssSelector("#input-payment-email");
    private final By telephoneInput = By.name("telephone");
    private final By companyInput = By.name("company");
    private final By addressOneInput = By.name("address_1");
    private final By addressTwoInput = By.name("address_2");
    private final By cityInput = By.name("city");
    private final By postCodeInput = By.name("postcode");
    private final By countrySelectBox = By.name("country_id");
    private final By regionSelectBox = By.name("zone_id");
    private final By regionSelectBoxOptions = By.cssSelector("[name='zone_id'] option");
    private final By billingContinueButton = By.cssSelector("#button-guest");
    private final By paymentMethodContainer = By.cssSelector("[id='collapse-payment-method']");
    private final By paymentMethodRadio = By.name("payment_method");
    private final By termsConditionAccept = By.cssSelector("[name='agree']");
    private final By paymentContinueButton = By.cssSelector("#button-payment-method");
    private final By orderInfoTable = By.cssSelector(".table-responsive");
    private final By confirmOrderButton = By.cssSelector("#button-confirm");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRadioButton () {
        waitUntilElementLocated(guestRadioButton);
        WebElement guestRadio = driver.findElement(guestRadioButton);
        clickToElement(guestRadio);
    }

    public Boolean checkGuestRadioButtonSelected () {
        WebElement guestRadio = driver.findElement(guestRadioButton);
        return guestRadio.isSelected();
    }

    public void clickOnContinueButton () {
        waitUntilElementLocated(continueButton);
        WebElement continueCheckout = driver.findElement(continueButton);
        clickToElement(continueCheckout);
    }

    public Boolean checkBillingDetailsMenuOpened () {
        waitUntilElementLocated(firstNameInput);
        WebElement firstName = driver.findElement(firstNameInput);
        return firstName.isDisplayed();
    }

    public Boolean checkPaymentMethodMenuOpened () {
        waitUntilElementLocated(paymentMethodRadio);
        WebElement paymentMethod = driver.findElement(paymentMethodRadio);
        return paymentMethod.isDisplayed();
    }

    public Boolean checkConfirmOrderMenuOpened () {
        waitUntilElementLocated(orderInfoTable);
        WebElement orderInfo = driver.findElement(orderInfoTable);
        return orderInfo.isDisplayed();
    }

    public void fillOutInputsWithRandomKeywords () {
        driver.findElement(firstNameInput)
                .sendKeys(generateRandomString(5, false, true));
        driver.findElement(lastnameInput)
                .sendKeys(generateRandomString(5, false, true));
        driver.findElement(telephoneInput)
                .sendKeys(generateRandomString(5, false, true));
        driver.findElement(companyInput)
                .sendKeys(generateRandomString(5, false, true));
        driver.findElement(addressOneInput)
                .sendKeys(generateRandomString(5, false, true));
        driver.findElement(addressTwoInput)
                .sendKeys(generateRandomString(5, false, true));
        driver.findElement(cityInput)
                .sendKeys(generateRandomString(5, false, true));
        driver.findElement(postCodeInput)
                .sendKeys(generateRandomString(5, false, true));
    }

    public void typeValidEmailAddress () {
        waitUntilElementLocated(emailInput);
        WebElement emailInputField = driver.findElement(emailInput);
        emailInputField.sendKeys(generateRandomEmail(5, false, true));
    }

    public void chooseOnCountrySelectBox (String countryName) throws InterruptedException {
        WebElement countryChooseSelectBox = driver.findElement(countrySelectBox);
        Select country = new Select(countryChooseSelectBox);
        country.selectByVisibleText(countryName);
        waitAjaxRequest();
    }

    public String getFirstValidRegionNameOnSelectBox () {
        List<WebElement> regionOptions = driver.findElements(regionSelectBoxOptions);
        return regionOptions.get(1).getText();
    }

    public void chooseOnRegionSelectBox (String regionName) throws InterruptedException {
        WebElement regionChooseSelectBox = driver.findElement(regionSelectBox);
        Select region = new Select(regionChooseSelectBox);
        region.selectByVisibleText(regionName);
        waitAjaxRequest();
    }

    public void clickOnBillingContinueButton () {
        WebElement billingContinue = driver.findElement(billingContinueButton);
        clickToElement(billingContinue);
    }

    public void clickOnTermsAndConditionInput () {
        waitUntilElementVisible(termsConditionAccept);
        WebElement termsAndConditionInput = driver.findElement(termsConditionAccept);
        clickToElement(termsAndConditionInput);
    }

    public void clickOnPaymentContinueButton () {
        WebElement paymentContinue = driver.findElement(paymentContinueButton);
        clickToElement(paymentContinue);
    }

    public void clickConfirmOrderButton () throws InterruptedException {
        waitUntilElementVisible(confirmOrderButton);
        WebElement confirmOrder = driver.findElement(confirmOrderButton);
        clickToElement(confirmOrder);
        waitAjaxRequest();
    }
  }
