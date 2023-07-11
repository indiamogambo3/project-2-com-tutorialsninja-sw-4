package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HP_LP3065Page;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.pages.TopMenuPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends BaseTest {

    TopMenuPage topMenuPage = new TopMenuPage();
    DesktopsPage desktopsPage = new DesktopsPage();
    HP_LP3065Page hp_lp3065Page = new HP_LP3065Page();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyProductArrangedInAlphabeticalOrder() throws InterruptedException {

        topMenuPage.mouseHoverAndClickOnDesktops();
        topMenuPage.clickOnShowAllDesktops();
    }

    public void verifyProductsOrder() {

        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductName.add(e.getText());
        }
        Collections.reverse(originalProductName);

        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");

        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductName.add(e.getText());

        }
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {

        topMenuPage.mouseHoverAndClickOnDesktops();
        topMenuPage.clickOnShowAllDesktops();
        desktopsPage.selectSortByPosition("Name (A - Z)");
        desktopsPage.selectProductHPLP3065();
        String expectedHPText = "HP LP3065";
        Assert.assertEquals(hp_lp3065Page.verifyHPLP3065Text(), expectedHPText, "Unable to verify text.");
        hp_lp3065Page.selectDeliveryDate();
        hp_lp3065Page.clearQuantity();
        hp_lp3065Page.inputQuantity("1");
        Thread.sleep(2000);
        hp_lp3065Page.clickOnAddToCartButton();
        Thread.sleep(3000);
        String expectedSuccessMessage = "Success: You have added HP LP3065 to your shopping cart!\n" + "×";
        Assert.assertEquals(hp_lp3065Page.messageAddedToShoppingCart(), expectedSuccessMessage, "Unable to verify message.");
        hp_lp3065Page.clickOnShoppingCartLink();
        String expectedShoppingCartText = "Shopping Cart  (1.00kg)";
        Assert.assertEquals(shoppingCartPage.verifyShoppingCartText(), expectedShoppingCartText, "Unable to verify text.");
        String expectedProductName = "HP LP3065";
        Assert.assertEquals(shoppingCartPage.verifyProductName(), expectedProductName, "Unable to verify name.");
        Thread.sleep(3000);
        String expectedDeliveryDate = "Delivery Date:2022-11-30";
        Assert.assertEquals(shoppingCartPage.verifyDeliveryDate(), expectedDeliveryDate, "Unable to verify date.");
        Thread.sleep(3000);
        String expectModel = "Product 21";
        Assert.assertEquals(shoppingCartPage.verifyModelName(), expectModel, "Unable to verify model");
        shoppingCartPage.selectCurrencyTab();
        shoppingCartPage.selectPoundsSterling();
        String expectedTotal = "£74.73";
        Assert.assertEquals(shoppingCartPage.verifyTheTotal(), expectedTotal, "Unable to verify total.");

    }


}

