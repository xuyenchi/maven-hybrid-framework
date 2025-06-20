package com.saucelabs;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcomerce.user.*;
import pageObjects.saucelabs.InventoryPO;
import pageObjects.saucelabs.LoginSaucelabsPO;
import pageObjects.saucelabs.PageGenerator;

public class User_01_Lv20_Sort extends BaseTest {
    WebDriver driver;
    private LoginSaucelabsPO loginSaucelabsPage;
    private InventoryPO inventoryPage;
    String userName = "standard_user";
    String password = "secret_sauce";

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserName(browserName, url);
        loginSaucelabsPage = PageGenerator.getLoginSaucelabsPage(driver);
        loginSaucelabsPage.enterUsernameTextbox(userName);
        loginSaucelabsPage.enterPassTextbox(password);
        inventoryPage = loginSaucelabsPage.clickToButtonLogin(driver);

    }

    @Test
    public void TC01_Sort_Name() throws InterruptedException {
        inventoryPage.selectSortDropdown("Name (A to Z)");
        System.out.println("---Sort name A to Z---");
        Assert.assertTrue(inventoryPage.isNameSortASC());

        inventoryPage.selectSortDropdown("Name (Z to A)");
        System.out.println("---Sort name Z to A---");
        Assert.assertTrue(inventoryPage.isNameSortDESC());

    }

    @Test
    public void TC02_Sort_Price() throws InterruptedException {
        inventoryPage.selectSortDropdown("Price (low to high)");
        System.out.println("---Sort price low to high---");
        Assert.assertTrue(inventoryPage.isPriceSortASC());

        inventoryPage.selectSortDropdown("Price (high to low)");
        System.out.println("---Sort price high to low---");
        Assert.assertTrue(inventoryPage.isPriceSortDESC());


    }

    @Test
    public void TC03_Sort_Date(){

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
