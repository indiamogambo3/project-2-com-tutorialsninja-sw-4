package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HP_LP3065Page extends Utility {

    By verifyText = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By deliveryDate = By.xpath("//div[@class = 'input-group date']//button");
    By monthYear = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");
    By datePicker = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");
    By dates = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
    By quantity = By.id("input-quantity");
    By cartButton = By.id("button-cart");
    By successMessage = By.xpath("//div[@class = 'alert alert-success alert-dismissible']");
    By shoppingCartLink = By.xpath("//span[contains(text(),'Shopping Cart')]");




    public String verifyHPLP3065Text() {
        return getTextFromElement(verifyText);
    }


    public void selectDeliveryDate() {

        String year = "2022";
        String month = "November";
        String date = "30";

        clickOnElement(deliveryDate);

        while (true) {
            String monthAndYear = getTextFromElement(monthYear);
            String arr[] = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(datePicker);
            }
        }

        List<WebElement> allDates = driver.findElements(dates);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void clearQuantity() {
        driver.findElement(quantity).clear();
    }

    public void inputQuantity(String text) {
        sendTextToElement(quantity, text);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(cartButton);
    }

    public String messageAddedToShoppingCart() {
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLink() {
        clickOnElement(shoppingCartLink);
    }

}
