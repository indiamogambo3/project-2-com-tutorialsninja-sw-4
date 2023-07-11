package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class MacBookPage extends Utility {

    By verifyMacBook = By.xpath("//h1[contains(text(),'MacBook')]");
    By addToCart = By.id("button-cart");
    By verifySuccessMessage = By.xpath("//div[@class = 'alert alert-success alert-dismissible']");
    By shoppingCartLink = By.linkText("shopping cart");



    public String verifyTextMacBook() {
        return getTextFromElement(verifyMacBook);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCart);
    }

    public String verifyMacBookAddedToShoppingCart() {
        return getTextFromElement(verifySuccessMessage);
    }

    public void clickOnShoppingCartLink() {
        clickOnElement(shoppingCartLink);
    }

}
