package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountsPage extends Utility {

    By myAccountLink = By.xpath("//span[contains(text(),'My Account')]");


    public void selectMyAccountOptions(String option) {

        List<WebElement> registerList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
        for (WebElement element : registerList) {
            if (element.getText().equals(option)) {
                element.click();
                break;
            }
        }
    }

    public void clickOnRegisterOption() {
        selectMyAccountOptions("Register");
    }

    public void clickOnLoginOption() {
        selectMyAccountOptions("Login");
    }

    public void clickOnLogoutOption() {
        selectMyAccountOptions("Logout");
    }



    public void clickOnMyAccountLink () {
        clickOnElement(myAccountLink);
    }



}


