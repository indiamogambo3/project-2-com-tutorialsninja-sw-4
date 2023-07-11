package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {

    By shoppingCartText = By.xpath("//div[@id='content']/h1");
    By productNameText = By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]");
    By deliveryDate = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    By modelName = By.xpath("//td[contains(text(),'Product 21')]");
    By selectCurrency = By.xpath("//span[contains(text(),'Currency')]");
    By selectPounds = By.xpath("//button[contains(text(),'£Pound Sterling')]");
    By verifyTotal = By.xpath("//tbody/tr[1]/td[6]");
    By quantity = By.xpath("//input[@value = '1']");
    By update = By.xpath("//i[@class ='fa fa-refresh']");
    By verifyUpdateMessage = By.xpath("//body/div[@id='checkout-cart']/div[1]");
    By checkoutButton = By.linkText("Checkout");

    public String verifyShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }

    public String verifyProductName() {
        return getTextFromElement(productNameText);
    }

    public String verifyDeliveryDate() {
        return getTextFromElement(deliveryDate);
    }

    public String verifyModelName() {
        return getTextFromElement(modelName);
    }

    public void selectCurrencyTab() {
        clickOnElement(selectCurrency);
    }

    public void selectPoundsSterling() {
        clickOnElement(selectPounds);
    }

    public String verifyTheTotal() {
        return getTextFromElement(verifyTotal);
    }

    public void clearQuantity() {

        driver.findElement(quantity).clear();
    }

    public void inputQuantity(String text) {
        sendTextToElement(quantity, text);
    }

    public void clickOnUpdateTab() {
        clickOnElement(update);
    }

    public String modifiedMessage() {
        return getTextFromElement(verifyUpdateMessage);
    }

    public void clickOnCheckOutButton() {
        clickOnElement(checkoutButton);
    }

}
