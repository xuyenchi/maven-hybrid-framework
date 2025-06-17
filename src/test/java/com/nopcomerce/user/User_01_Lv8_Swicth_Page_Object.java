package com.nopcomerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcomerce.PageGenerator;
import pageObjects.nopcomerce.user.*;

public class User_01_Lv8_Swicth_Page_Object extends BaseTest {
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

    public User_01_Lv8_Swicth_Page_Object() {
        super();
    }

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserName(browserName);
        homePage = PageGenerator.getHomePage(driver);
    }

    @Test
    public void TC_01_Register_Techpanda() {

        registerPage = homePage.openRegisterPage();

        //qua trang register
        registerPage.enterFirstnameTextbox(firstname);
        registerPage.enterMiddlenameTextbox(middlename);
        registerPage.enterLastnameTextbox(lastname);
        registerPage.enterEmailTextbox(email_address);
        registerPage.enterPasswordTextbox(password);
        registerPage.enterConfirmPasswordTextbox(password);
        myAccountPage = registerPage.clickRegisterButon();

        //qua trang my account
        Assert.assertEquals(myAccountPage.getSuccessRegister(), "Thank you for registering with Main Website Store.");
        Assert.assertTrue(myAccountPage.getContactInfo().contains(fullname));
        Assert.assertTrue(myAccountPage.getContactInfo().contains(email_address));


    }

    @Test
    public void TC_02_MyAccount() throws InterruptedException {
        myAccountPage.clickAccountLink();
        myAccountPage = myAccountPage.openMyAccountPage();
        Thread.sleep(3000);
    }

    @Test
    public void TC_03_Switch_Page(){
        //Myaccount -> Adrress
        addressBookPage = myAccountPage.openAdressPage();

        //Adress -> Order
        orderPage = addressBookPage.openOrderPage();
        // Order -> My account
        myAccountPage = orderPage.openMyAccountPage();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
