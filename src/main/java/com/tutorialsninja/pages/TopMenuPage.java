package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class TopMenuPage extends Utility {

    By desktops = By.linkText("Desktops");
    By verifyDesktops = By.xpath("//h2[contains(text(),'Desktops')]");
    By laptopsAndNotebooks = By.linkText("Laptops & Notebooks");
    By verifyLaptopsAndNotebooks = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By components = By.linkText("Components");
    By verifyComponents = By.xpath("//h2[contains(text(),'Components')]");
    By allDesktops = By.linkText("Show AllDesktops");
    By allLaptopsAndNotebooks = By.linkText("Show AllLaptops & Notebooks");

    public void selectMenu(String menu) {

        driver.findElement(By.linkText(menu)).click();
    }

    public void mouseHoverAndClickOnDesktops (){
        mouseHoverToElementAndClick(desktops);
    }

    public String verifyTextDesktops() {
        return getTextFromElement(verifyDesktops);
    }

    public void mouseHoverAndClickOnLaptopsAndNotebooks() {
        mouseHoverToElementAndClick(laptopsAndNotebooks);
    }

    public String verifyTextLaptopsAndNotebooks() {
        return getTextFromElement(verifyLaptopsAndNotebooks);
    }

    public void mouseHoverAndClickComponents() {
        mouseHoverToElementAndClick(components);
    }

    public String verifyTextComponents() {
        return getTextFromElement(verifyComponents);
    }

    public void clickOnShowAllDesktops() {
        clickOnElement(allDesktops);
    }

    public void clickOnShowAllLaptopsAndNotebooks() {
        clickOnElement(allLaptopsAndNotebooks);
    }

}
