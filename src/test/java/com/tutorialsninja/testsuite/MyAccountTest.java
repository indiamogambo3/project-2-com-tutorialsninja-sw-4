package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {

    MyAccountsPage myAccountsPage = new MyAccountsPage();
    RegisterPage registerPage = new RegisterPage();
    SuccessPage successPage = new SuccessPage();
    LogoutPage logoutPage = new LogoutPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void verifyUserShouldShouldNavigateToRegisterPageSuccessfully() {

        myAccountsPage.clickOnMyAccountLink();
        myAccountsPage.clickOnRegisterOption();
        String expectedRegisterText = "Register Account";
        Assert.assertEquals(registerPage.verifyTextRegisterAccount(), expectedRegisterText, "Unable to verify text.");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccountsPage.clickOnMyAccountLink();
        myAccountsPage.clickOnLoginOption();
        String expectedReturningText = "Returning Customer";
        Assert.assertEquals(registerPage.verifyTextReturningCustomer(), expectedReturningText, "Unable to verify text.");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {

        myAccountsPage.clickOnMyAccountLink();
        myAccountsPage.clickOnRegisterOption();
        registerPage.enterFirstName("Mukz");
        registerPage.enterLastName("Shah");
        registerPage.enterEmailName("mukz12345@gmail.com");
        registerPage.enterTelephoneNumber("07125698742");
        registerPage.enterPassword("Mukz123");
        registerPage.enterConfirmPassword("Mukz123");
        registerPage.selectSubscribeYesRadioButton();
        registerPage.clickOnPrivacyPolicy();
        registerPage.clickOnContinueButton();
        String expectedAccountCreatedMessage = "Your Account Has Been Created!";
        Assert.assertEquals(successPage.verifyAccountHasBeenCreatedMessage(), expectedAccountCreatedMessage, "Unable to verify message.");
        successPage.clickOnContinueButton();
        myAccountsPage.clickOnMyAccountLink();
        myAccountsPage.clickOnLogoutOption();
        String expectedAccountLogoutText = "Account Logout";
        Assert.assertEquals(logoutPage.verifyAccountLogoutText(),expectedAccountLogoutText, "Unable to verify text.");
        logoutPage.clickOnContinueButton();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {

        myAccountsPage.clickOnMyAccountLink();
        myAccountsPage.clickOnLoginOption();
        loginPage.enterEmail("mukz12345@gmail.com");
        loginPage.enterPassword("Mukz123");
        loginPage.clickOnLoginButton();
        String expectedMyAccountText = "My Account";
        Assert.assertEquals(loginPage.verifyTextMyAccount(), expectedMyAccountText, "Unable to verify text");
        myAccountsPage.clickOnMyAccountLink();
        myAccountsPage.clickOnLogoutOption();
        String expectedAccountLogoutText = "Account Logout";
        Assert.assertEquals(logoutPage.verifyAccountLogoutText(),expectedAccountLogoutText, "Unable to verify text.");
        logoutPage.clickOnContinueButton();
    }


}
