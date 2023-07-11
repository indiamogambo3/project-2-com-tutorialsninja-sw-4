package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class DesktopsPage extends Utility {

    By sortBy = By.id("input-sort");
    By productHP = By.linkText("HP LP3065");



//    public void verifyOriginalProductsOrder() {
//
//        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
//        ArrayList<String> originalProductName = new ArrayList<>();
//        for (WebElement e : products) {
//            originalProductName.add(e.getText());
//        }
//        Collections.reverse(originalProductName);
//
//        selectByVisibleTextFromDropDown(productZtoA, "Name (Z - A)");
//
//         products = driver.findElements(By.xpath("//h4/a"));
//        ArrayList<String> afterSortByZToAProductName = new ArrayList<>();
//        for (WebElement e : products) {
//            afterSortByZToAProductName.add(e.getText());
//
//        }
//    }

    public void selectSortByPosition(String text) {
        selectByVisibleTextFromDropDown(sortBy, text);
    }

    public void selectProductHPLP3065() {
        clickOnElement(productHP);
    }










}
