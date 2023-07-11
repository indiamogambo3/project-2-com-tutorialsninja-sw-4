package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends BaseTest {

    TopMenuPage topMenuPage = new TopMenuPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    MacBookPage macBookPage = new MacBookPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        topMenuPage.mouseHoverAndClickOnLaptopsAndNotebooks();
        topMenuPage.clickOnShowAllLaptopsAndNotebooks();
    }

    public void verifyPriceOrder() {

        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        Collections.sort(originalProductPrice, Collections.reverseOrder());

        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");

        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }

        Assert.assertEquals(afterSortByPrice, originalProductPrice, "Product not sorted by price High to Low");


    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        topMenuPage.mouseHoverAndClickOnLaptopsAndNotebooks();
        topMenuPage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.selectSortByPriceHighToLow("Price (High > Low)");
        laptopsAndNotebooksPage.selectProductMacBook();
        String expectedMacBookText = "MacBook";
        Assert.assertEquals(macBookPage.verifyTextMacBook(), expectedMacBookText, "Unable to verify text");
        macBookPage.clickOnAddToCartButton();
        String expectedSuccessMessage = "Success: You have added MacBook to your shopping cart!\n" + "×";
        Assert.assertEquals(macBookPage.verifyMacBookAddedToShoppingCart(), expectedSuccessMessage, "Unable to verify message");
        macBookPage.clickOnShoppingCartLink();
        String expectedShoppingCartText = "Shopping Cart  (0.00kg)";
        Assert.assertEquals(shoppingCartPage.verifyShoppingCartText(), expectedShoppingCartText, "Unable to verify text.");
        String expectedProductName = "MacBook";
        Assert.assertEquals(shoppingCartPage.verifyProductName(), expectedProductName, "Unable to verify name.");
        Thread.sleep(2000);
        shoppingCartPage.clearQuantity();
        shoppingCartPage.inputQuantity("2");
        shoppingCartPage.clickOnUpdateTab();
        String expectedModifiedMessage = "Success: You have modified your shopping cart!\n" + "×";
        Assert.assertEquals(shoppingCartPage.modifiedMessage(),expectedModifiedMessage, "Unable to confirm message.");
        shoppingCartPage.selectCurrencyTab();
        shoppingCartPage.selectPoundsSterling();
        String expectedTotal = "£737.45";
        Assert.assertEquals(shoppingCartPage.verifyTheTotal(), expectedTotal, "Unable to verify total.");
        shoppingCartPage.clickOnCheckOutButton();
        String expectedCheckoutText = "Checkout";
        Assert.assertEquals(checkoutPage.verifyCheckoutText(),expectedCheckoutText, "Unable to verify text.");
        Thread.sleep(2000);
        String expectedNewCustomerText = "New Customer";
        Assert.assertEquals(checkoutPage.verifyNewCustomerText(), expectedNewCustomerText, "Unable to verify text.");
        checkoutPage.clickOnGuestRadioButton();
        checkoutPage.clickOnContinueTab();
        checkoutPage.enterFirstName("Mukz");
        checkoutPage.enterLastName("Shah");
        checkoutPage.enterEmail("kkkk123@gmail.com");
        checkoutPage.enterTelephoneNumber("07745365214");
        checkoutPage.enterAddressLine1("123 Best Street");
        checkoutPage.enterCity("London");
        checkoutPage.enterPostCode("LN1 1LN");
        checkoutPage.enterCountry("United Kingdom");
        checkoutPage.enterRegion("Merseyside");
        checkoutPage.clickOnContinueButton();
        Thread.sleep(2000);
        checkoutPage.addCommentsAboutOrder("Please dispatch as soon as possible.");
//        checkoutPage.clickOnContinue();
        checkoutPage.clickOnTermsAndConditions();
        checkoutPage.clickOnContinueButtonOnPayment();
        String expectedWarning = "Warning: Payment method required!\n" + "×";
        Assert.assertEquals(checkoutPage.verifyWarningMessage(), expectedWarning, "Unable to verify message.");

    }



}
