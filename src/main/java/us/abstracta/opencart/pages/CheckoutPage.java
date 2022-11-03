package us.abstracta.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import us.abstracta.opencart.driver.Driver;

import java.util.List;

public class CheckoutPage extends BasePage {

    private final By guestRadioButton = By.cssSelector("input[value='guest']");
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
    private final By paymentMethodRadio = By.name("payment_method");
    private final By termsConditionAccept = By.cssSelector("[name='agree']");
    private final By paymentContinueButton = By.cssSelector("#button-payment-method");
    private final By orderInfoTable = By.cssSelector(".table-responsive");
    private final By confirmOrderButton = By.cssSelector("#button-confirm");


    public CheckoutPage(Driver driver) {
        super(driver);
    }

    public void clickOnRadioButton () {
        clickElementBy(guestRadioButton, false, false);
    }

    public Boolean checkGuestRadioButtonSelected () {
        return isSelected(guestRadioButton);
    }

    public void clickOnContinueButton () {
        clickElementBy(continueButton, false, false);
    }

    public Boolean checkBillingDetailsMenuOpened () {
        return isDisplayed(firstNameInput);
    }

    public Boolean checkPaymentMethodMenuOpened () {
        return isDisplayed(paymentMethodRadio);
    }

    public Boolean checkConfirmOrderMenuOpened () {
        return isDisplayed(orderInfoTable);
    }

    public void fillOutInputsWithRandomKeywords () {
        typeTextToElement(firstNameInput, generateRandomString(5, false, true));
        typeTextToElement(lastnameInput, generateRandomString(5, false, true));
        typeTextToElement(telephoneInput, generateRandomString(5, false, true));
        typeTextToElement(companyInput, generateRandomString(5, false, true));
        typeTextToElement(addressOneInput, generateRandomString(5, false, true));
        typeTextToElement(addressOneInput, generateRandomString(5, false, true));
        typeTextToElement(addressTwoInput, generateRandomString(5, false, true));
        typeTextToElement(cityInput, generateRandomString(5, false, true));
        typeTextToElement(postCodeInput, generateRandomString(5, false, true));
    }

    public void typeValidEmailAddress () {
        typeTextToElement(emailInput, generateRandomEmail(5, false, true));
    }

    public void chooseOnCountrySelectBox (String countryName) throws InterruptedException {
        selectWithTextOnSelectBox(countrySelectBox, countryName);
        driver.waitForAjax();
    }

    public String getFirstValidRegionNameOnSelectBox () {
        List<WebElement> regionOptions = driver.findElements(regionSelectBoxOptions);
        return regionOptions.get(1).getText();
    }

    public void chooseOnRegionSelectBox (String regionName) throws InterruptedException {
        selectWithTextOnSelectBox(regionSelectBox, regionName);
        driver.waitForAjax();
    }

    public void clickOnBillingContinueButton () {
        clickElementBy(billingContinueButton, false, true);
    }

    public void clickOnTermsAndConditionInput () {
        clickElementBy(termsConditionAccept, false, true);
    }

    public void clickOnPaymentContinueButton () {
        clickElementBy(paymentContinueButton, false, true);
    }

    public void clickConfirmOrderButton () {
        clickElementBy(confirmOrderButton, false, false);
        driver.waitForAjax();
    }
  }
