package com.nopcomerce.user;

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
import pageObjects.nopcomerce.PageGenerator;
import pageObjects.nopcomerce.user.*;
import pojo.UserInfo;
import utilities.ExcelConfig;

public class User_01_Lv22_Data_Excel extends BaseTest {
    WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserMyAccountPO myAccountPage;
    private UserAddressBookPO addressBookPage;
    private UserOrderPO orderPage;
    public UserInfo userInfo;
    private ExcelConfig excelConfig;
    private String email, fullName;


    public User_01_Lv22_Data_Excel() {
        super();
    }

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserName(browserName);
        homePage = PageGenerator.getHomePage(driver);
        excelConfig = ExcelConfig.getExcelData();
        excelConfig.switchToSheet("Sheet1");
        email = excelConfig.getCellData("Email", 1)+ generateRandomNumber() + "@gmail.com";
        fullName = excelConfig.getCellData("FirstName", 1) + " " + excelConfig.getCellData("MiddleName", 1) + " " + excelConfig.getCellData("LastName", 1);

    }

    @Description("Register new account")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC_01_Register_Techpanda() {

        registerPage = homePage.openRegisterPage();
        Assert.assertEquals(homePage.getTextpageTitle(), "CREATE AN ACCOUNT");
        //qua trang register
        // có thể gom các bước lại thành 1 bước duy nhất

        registerPage.enterTextboxByID(driver, "firstname", excelConfig.getCellData("FirstName", 1));
        registerPage.enterTextboxByID(driver, "middlename", excelConfig.getCellData("MiddleName", 1));
        registerPage.enterTextboxByID(driver, "lastname", excelConfig.getCellData("LastName", 1));
        registerPage.enterTextboxByID(driver, "email_address", email);
        registerPage.enterTextboxByID(driver, "password", excelConfig.getCellData("Password", 1));
        registerPage.enterTextboxByID(driver, "confirmation", excelConfig.getCellData("Password", 1));

   //     registerPage.enterFormRegister(userInfo);

        myAccountPage = registerPage.clickRegisterButon();

        //qua trang my account
        Assert.assertEquals(myAccountPage.getSuccessRegister(), "Thank you for registering with Main Website Store.");
        System.out.printf("---Asert Fullname---");
        System.out.println("Get fullname system : " + myAccountPage.getContactInfo());
        System.out.println("Get fullname variable : " +  fullName);
        Assert.assertTrue(myAccountPage.getContactInfo().contains(fullName));
        System.out.println("---Assert Email---");
        Assert.assertTrue(myAccountPage.getContactInfo().contains(excelConfig.getCellData("Email", 1)));


    }

    // @Test
    public void TC_02_MyAccount() throws InterruptedException {
        myAccountPage.clickAccountLink();
        myAccountPage = myAccountPage.openMyAccountPage();
        Thread.sleep(3000);
    }

    // @Test
    public void TC_03_Switch_Page() {
        //Myaccount -> Adrress
        addressBookPage = (UserAddressBookPO) myAccountPage.openSidebarLinkByPageName("Address Book");

        //Adress -> Order
        orderPage = (UserOrderPO) addressBookPage.openSidebarLinkByPageName("My Orders");
        // Order -> My account
        myAccountPage = (UserMyAccountPO) orderPage.openSidebarLinkByPageName("Account Dashboard");
        ;

    }

    // @Test
    public void TC_04_Switch_Page() {
        //Myaccount -> Adrress
        myAccountPage.openSidebarLinkByPageName("Address Book");
        addressBookPage = PageGenerator.getUserAddressPage(driver);

        //Adress -> Order
        addressBookPage.openSidebarLinkByPageName("My Orders");
        orderPage = PageGenerator.getUserOrderPage(driver);
        // Order -> My account
        orderPage.openSidebarLinkByPageName("Account Dashboard");
        myAccountPage = PageGenerator.getUserMyAccountPage(driver);
        ;

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
