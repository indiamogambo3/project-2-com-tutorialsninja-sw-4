package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.TopMenuPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {

    TopMenuPage topMenuPage = new TopMenuPage();


    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        topMenuPage.mouseHoverAndClickOnDesktops();
        topMenuPage.selectMenu("Show AllDesktops");
        String expectedDesktopsText = "Desktops";
        Assert.assertEquals(topMenuPage.verifyTextDesktops(), expectedDesktopsText, "Unable to verify text.");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        topMenuPage.mouseHoverAndClickOnLaptopsAndNotebooks();
        topMenuPage.selectMenu("Show AllLaptops & Notebooks");
        String expectedLaptopsAndNotebookText = "Laptops & Notebooks";
        Assert.assertEquals(topMenuPage.verifyTextLaptopsAndNotebooks(), expectedLaptopsAndNotebookText, "Unable to verify text.");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        topMenuPage.mouseHoverAndClickComponents();
        topMenuPage.selectMenu("Show AllComponents");
        String expectedComponentsText = "Components";
        Assert.assertEquals(topMenuPage.verifyTextComponents(), expectedComponentsText, "Unable to verify text.");
    }


}
