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
import utilities.FakerConfig;

public class User_01_Lv21_Faker extends BaseTest {
    WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserMyAccountPO myAccountPage;
    private UserAddressBookPO addressBookPage;
    private UserOrderPO orderPage;
    private FakerConfig faker;
    String firstname;
    String middlename;
    String lastname;
    String email_address;
    String password;
    String fullname;

    public User_01_Lv21_Faker() {
        super();
    }

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserName(browserName);
        homePage = PageGenerator.getHomePage(driver);
        faker = FakerConfig.getFaker();
        firstname = faker.getFirstName();
        middlename = faker.getLastName();
        lastname = faker.getLastName();
        email_address = faker.getEmailAddress();
        password = faker.getPassword();
        fullname = firstname + " " + middlename + " " + lastname;


    }

    @Description("Register new account")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC_01_Register_Techpanda() {

        registerPage = homePage.openRegisterPage();
        Assert.assertEquals(homePage.getTextpageTitle(), "CREATE AN ACCOUNT");
        //qua trang register

        registerPage.enterTextboxByID(driver, "firstname", firstname);
        registerPage.enterTextboxByID(driver, "middlename", middlename);
        registerPage.enterTextboxByID(driver, "lastname", lastname);
        registerPage.enterTextboxByID(driver, "email_address", email_address);
        registerPage.enterTextboxByID(driver, "password", password);
        registerPage.enterTextboxByID(driver, "confirmation", password);

        myAccountPage = registerPage.clickRegisterButon();

        //qua trang my account
        Assert.assertEquals(myAccountPage.getSuccessRegister(), "Thank you for registering with Main Website Store.");
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

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
