package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class CheckoutPage extends Utility {

    By verifyCheckoutText = By.xpath("//h1[contains(text(),'Checkout')]");
    By verifyNewCustomer = By.xpath("//h2[contains(text(),'New Customer')]");
    By guestRadioButton = By.xpath("//input[@value = 'guest']");
    By continueTab = By.id("button-account");
    By firstNameField = By.id("input-payment-firstname");
    By lastNameField = By.id("input-payment-lastname");
    By emailField = By.id("input-payment-email");
    By telephoneNumberField = By.id("input-payment-telephone");
    By address1Field = By.id("input-payment-address-1");
    By cityField = By.id("input-payment-city");
    By postCodeField = By.id("input-payment-postcode");
    By countryField = By.id("input-payment-country");
    By regionField = By.id("input-payment-zone");
    By continueButton = By.id("button-guest");
    By addComments = By.tagName("textarea");
    By continueTabDeliveryMethod = By.xpath("//input[@id='button-shipping-method']");
    By termsAndConditions = By.name("agree");
    By continueButtonOnPayment = By.xpath("//input[@id='button-payment-method']");
    By paymentMethod = By.xpath("//div[@class='alert alert-danger alert-dismissible']");



    public String verifyCheckoutText() {
        return getTextFromElement(verifyCheckoutText);
    }

    public String verifyNewCustomerText() {
        return getTextFromElement(verifyNewCustomer);
    }

    public void clickOnGuestRadioButton() {
        clickOnElement(guestRadioButton);
    }

    public void clickOnContinueTab() {
        clickOnElement(continueTab);
    }

    public void enterFirstName(String firstName) {
        sendTextToElement(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        sendTextToElement(lastNameField, lastName);
    }

    public void enterEmail (String email) {
        sendTextToElement(emailField, email);
    }

    public void enterTelephoneNumber(String number) {
        sendTextToElement(telephoneNumberField, number);
    }

    public void enterAddressLine1(String text) {
        sendTextToElement(address1Field, text);
    }

    public void enterCity(String text) {
        sendTextToElement(cityField, text);
    }

    public void enterPostCode(String text) {
        sendTextToElement(postCodeField, text);
    }

    public void enterCountry(String text) {
        selectByVisibleTextFromDropDown(countryField, text);
    }

    public void enterRegion(String text) {
        sendTextToElement(regionField, text);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public void addCommentsAboutOrder(String text) {
        sendTextToElement(addComments, text);
    }

    public void clickOnContinue() {
        clickOnElement(continueTabDeliveryMethod);
    }

    public void clickOnTermsAndConditions() {
        clickOnElement(termsAndConditions);
    }

    public void clickOnContinueButtonOnPayment() {
        clickOnElement(continueButtonOnPayment);
    }

    public String verifyWarningMessage() {
        return getTextFromElement(paymentMethod);
    }



}
