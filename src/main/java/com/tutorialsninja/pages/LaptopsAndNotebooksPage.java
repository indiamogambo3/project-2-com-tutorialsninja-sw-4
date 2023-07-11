package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LaptopsAndNotebooksPage extends Utility {

    By sortPrice = By.id("input-sort");
    By macBook = By.linkText("MacBook");


    public void selectSortByPriceHighToLow(String text) {
        selectByVisibleTextFromDropDown(sortPrice, text);
    }

    public void selectProductMacBook() {
        clickOnElement(macBook);
    }


}
