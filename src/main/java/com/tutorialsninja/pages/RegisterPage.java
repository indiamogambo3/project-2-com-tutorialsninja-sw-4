package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class RegisterPage extends Utility {

    By registerText = By.xpath("//h1[contains(text(),'Register Account')]");
    By returningText = By.xpath("//h2[contains(text(),'Returning Customer')]");
    By firstNameField = By.id("input-firstname");
    By lastNameField = By.id("input-lastname");
    By emailField = By.id("input-email");
    By telephoneField = By.id("input-telephone");
    By passwordField = By.id("input-password");
    By confirmPasswordField = By.id("input-confirm");
    By newsletterRadio = By.name("newsletter");
    By privacyPolicy = By.name("agree");
    By continueButton = By.xpath("//input[@type = 'submit']");


    public String verifyTextRegisterAccount() {
        return getTextFromElement(registerText);
    }

    public String verifyTextReturningCustomer() {
        return getTextFromElement(returningText);
    }

    public void enterFirstName(String firstName) {
        sendTextToElement(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        sendTextToElement(lastNameField, lastName);
    }

    public void enterEmailName(String email) {
        sendTextToElement(emailField, email);
    }

    public void enterTelephoneNumber(String telephoneNumber) {
        sendTextToElement(telephoneField, telephoneNumber);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        sendTextToElement(confirmPasswordField, confirmPassword);
    }

    public void selectSubscribeYesRadioButton() {
        clickOnElement(newsletterRadio);
    }

    public void clickOnPrivacyPolicy() {
        clickOnElement(privacyPolicy);
    }
    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }



}
