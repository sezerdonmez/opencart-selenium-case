package us.abstracta.opencart.e2e;

import org.testng.annotations.Test;
import us.abstracta.opencart.base.BaseTest;

import static org.junit.jupiter.api.Assertions.*;

public class CompleteCheckout extends BaseTest {

    @Test
    public void checkoutWithGuestUser() throws InterruptedException {
        homePage.addToCartFirstItem();
        assertTrue(homePage.checkIfProductAddedToCart().contains("1 item(s)"),
                "Should add 1 item to cart");
        assertTrue(homePage.checkSuccessAlertBoxText().contains("Success: You have added"),
                "Should be valid success alert box text");
        assertTrue(homePage.checkSuccessAlertBoxColor(),
                "Should be green success alert box color");
        homePage.clickOnCartDropdown();
        assertTrue(homePage.checkIfCartDropdownOpened(),
                "Should opened cart dropdown box");
        homePage.clickOnViewCartButton();
        assertEquals("Shopping Cart", cartPage.getCurrentPageTitle(), "Should navigate to Cart Page");
        cartPage.clickOnCheckoutButton();
        assertEquals("Checkout", checkoutPage.getCurrentPageTitle(), "Should navigate to Checkout Page");
        checkoutPage.clickOnRadioButton();
        assertTrue(checkoutPage.checkGuestRadioButtonSelected(),
                "Should selected Guest User");
        checkoutPage.clickOnContinueButton();
        assertTrue(checkoutPage.checkBillingDetailsMenuOpened(),
                "Should open Billing Details menu");
        checkoutPage.fillOutInputsWithRandomKeywords();
        checkoutPage.typeValidEmailAddress();
        checkoutPage.chooseOnCountrySelectBox("Turkey");
        assertEquals("Adana", checkoutPage.getFirstValidRegionNameOnSelectBox(), "Should be Adana first valid select box option");
        checkoutPage.chooseOnRegionSelectBox("İstanbul");
        checkoutPage.clickOnBillingContinueButton();
        assertTrue(checkoutPage.checkPaymentMethodMenuOpened(),
                "Should open Payment Method menu");
        checkoutPage.clickOnTermsAndConditionInput();
        checkoutPage.clickOnPaymentContinueButton();
        assertTrue(checkoutPage.checkConfirmOrderMenuOpened(),
                "Should open Confirm Order menu");
        checkoutPage.clickConfirmOrderButton();
        orderSuccessPage.waitUntilContentVisible();
        assertEquals("Your order has been placed!", orderSuccessPage.getCurrentPageTitle(), "Should navigate to Order Success Page");
    }
}
