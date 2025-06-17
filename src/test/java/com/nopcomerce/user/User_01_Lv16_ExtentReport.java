package com.nopcomerce.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcomerce.PageGenerator;
import pageObjects.nopcomerce.user.*;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class User_01_Lv16_ExtentReport extends BaseTest {
    WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserMyAccountPO myAccountPage;
    private UserAddressBookPO addressBookPage;
    private UserOrderPO orderPage;
    String firstname = "Le";
    String middlename = "Ngoc";
    String lastname = "Xuyen";
    String email_address = "xuyen" + generateRandomNumber() + "@gmail.com";
    String password = "123456";
    String fullname = firstname + " " + middlename + " " + lastname;

    public User_01_Lv16_ExtentReport(){
        super();
    }

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserName(browserName);
        homePage = PageGenerator.getHomePage(driver);

    }

    @Test
    public void TC_01_Register_Techpanda(Method method) {
        ExtentManager.startTest(method.getName(), "TC 01 Register");
        ExtentManager.getTest().log(Status.INFO,"TC01 Register");
        ExtentManager.getTest().log(Status.INFO," TC01 Register Step 1 : Open register page");
        registerPage = homePage.openRegisterPage();
        Assert.assertEquals(homePage.getTextpageTitle(), "CREATE AN ACCOUNT");
        //qua trang register
        ExtentManager.getTest().log(Status.INFO,"TC01 Register Step 2 : Enter user Firstname " + firstname);
        registerPage.enterFirstnameTextbox(firstname);

        ExtentManager.getTest().log(Status.INFO,"TC01 Register Step 2 : Enter user Middle name " + middlename);
        registerPage.enterMiddlenameTextbox(middlename);

        ExtentManager.getTest().log(Status.INFO,"TC01 Register Step 2 : Enter user lastname " + lastname);
        registerPage.enterLastnameTextbox(lastname);

        ExtentManager.getTest().log(Status.INFO,"TC01 Register Step 2 : Enter user email " + email_address);
        registerPage.enterEmailTextbox(email_address);

        ExtentManager.getTest().log(Status.INFO,"TC01 Register Step 2 : Enter user pass " + password);
        registerPage.enterPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO,"TC01 Register Step 2 : Enter user confirm pass " + password);
        registerPage.enterConfirmPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO,"TC01 Register Step 3 : Click Register button ");
        myAccountPage = registerPage.clickRegisterButon();

        //qua trang my account
        Assert.assertEquals(myAccountPage.getSuccessRegister(), "Thank you for registering with Main Website Store.000");
        Assert.assertTrue(myAccountPage.getContactInfo().contains(fullname));
        Assert.assertTrue(myAccountPage.getContactInfo().contains(email_address));


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

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
