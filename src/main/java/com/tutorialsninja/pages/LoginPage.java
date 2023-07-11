package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = By.xpath("//input[@type = 'submit']");
    By verifyAccountText = By.xpath("//h2[contains(text(),'My Account')]");


    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String verifyTextMyAccount() {
        return getTextFromElement(verifyAccountText);
    }




}
