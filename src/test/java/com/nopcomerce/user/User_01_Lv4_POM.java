package com.nopcomerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.nopcomerce.user.UserHomePO;
import pageObjects.nopcomerce.user.UserMyAccountPO;
import pageObjects.nopcomerce.user.UserRegisterPO;

import java.time.Duration;

public class User_01_Lv4_POM extends BaseTest {
    WebDriver driver;
    private UserHomePO homePageObject;
    private UserRegisterPO registerPageObject;
    private UserMyAccountPO myAccountObject;
    String firstname = "Le";
    String middlename = "Ngoc";
    String lastname = "Xuyen";
    String email_address = "xuyen" + generateRandomNumber() + "@gmail.com";
    String password = "123456";
    String fullname = firstname + " " + middlename + " " + lastname;

    public User_01_Lv4_POM() {
        super();
    }

    @BeforeClass
    public void beforeClass() {

        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //driver.get("https://demo.nopcommerce.com/");
        driver.get("http://live.techpanda.org/");
        homePageObject = new UserHomePO(driver);
    }

    @Test
    public void TC_01_Register_Techpanda() {

        homePageObject.openRegisterPage();

        //qua trang register
        registerPageObject = new UserRegisterPO(driver);
        registerPageObject.enterFirstnameTextbox(firstname);
        registerPageObject.enterMiddlenameTextbox(middlename);
        registerPageObject.enterLastnameTextbox(lastname);
        registerPageObject.enterEmailTextbox(email_address);
        registerPageObject.enterPasswordTextbox(password);
        registerPageObject.enterConfirmPasswordTextbox(password);
        registerPageObject.clickRegisterButon();

        //qua trang my account
        myAccountObject = new UserMyAccountPO(driver);
        Assert.assertEquals(myAccountObject.getSuccessRegister(), "Thank you for registering with Main Website Store.");
        Assert.assertTrue(myAccountObject.getContactInfo().contains(fullname));
        Assert.assertTrue(myAccountObject.getContactInfo().contains(email_address));


    }

    @Test
    public void TC_02_MyAccount() throws InterruptedException {
        myAccountObject.clickAccountLink();
        myAccountObject.openMyAccountPage();
        myAccountObject = new UserMyAccountPO(driver);


        Thread.sleep(3000);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
