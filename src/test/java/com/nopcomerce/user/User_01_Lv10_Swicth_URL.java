package com.nopcomerce.user;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcomerce.PageGenerator;
import pageObjects.nopcomerce.admin.AdminDashboardPO;
import pageObjects.nopcomerce.admin.AdminLoginPO;
import pageObjects.nopcomerce.user.*;

public class User_01_Lv10_Swicth_URL extends BaseTest {
    WebDriver driver;
    private UserHomePO userHomePage;
    private UserRegisterPO userRegisterPage;
    private UserMyAccountPO userMyAccountPage;
    private UserAddressBookPO userAddressBookPage;
    private UserOrderPO userOrderPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;
    String firstname = "Le";
    String middlename = "Ngoc";
    String lastname = "Xuyen";
    String email_address = "xuyen" + generateRandomNumber() + "@gmail.com";
    String password = "123456";
    String fullname = firstname + " " + middlename + " " + lastname;
    String adminUser = GlobalConstants.ADMIN_NOP_USERNAME;
    String adminPass = GlobalConstants.ADMIN_NOP_PASS;
    private String userUrlValue, adminUrlValue;

    public User_01_Lv10_Swicth_URL() {
        super();
    }

    @Parameters({"browser", "userUrl", "adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        userUrlValue = userUrl;
        adminUrlValue = adminUrl;

        driver = getBrowserName(browserName, userUrlValue);
        userHomePage = PageGenerator.getHomePage(driver);

        userRegisterPage = userHomePage.openRegisterPage();

        //qua trang register
        userRegisterPage.enterFirstnameTextbox(firstname);
        userRegisterPage.enterMiddlenameTextbox(middlename);
        userRegisterPage.enterLastnameTextbox(lastname);
        userRegisterPage.enterEmailTextbox(email_address);
        userRegisterPage.enterPasswordTextbox(password);
        userRegisterPage.enterConfirmPasswordTextbox(password);
        userMyAccountPage = userRegisterPage.clickRegisterButon();

        Assert.assertEquals(userMyAccountPage.getSuccessRegister(), "Thank you for registering with Main Website Store.");
        Assert.assertTrue(userMyAccountPage.getContactInfo().contains(fullname));
        Assert.assertTrue(userMyAccountPage.getContactInfo().contains(email_address));

    }


    @Test
    public void TC01_User_To_Admin() throws InterruptedException {

        // đang ở trang myaccount
        //...
        //switch qua trang admin

        userMyAccountPage.openPageURL(driver, adminUrlValue);
        //nếu chưa login thì login
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);
        adminLoginPage.enterUsernameTextbox(adminUser);
        adminLoginPage.enterPassTextbox(adminPass);
        adminDashboardPage = adminLoginPage.clickLoginButton();
        Thread.sleep(5000);
        //nếu login rồi khởi tạo trang dashboard
        //adminDashboardPage = PageGenerator.getAdminDashboardPage(driver);

    }



    @Test
    public void TC01_Admin_To_User() {
        // qua được trang admin rồi
        //'''
        //switch lại trang techpanda user
        adminDashboardPage.openPageURL(driver, userUrlValue);
        userHomePage = PageGenerator.getHomePage(driver);
        //chạy các step khác
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
