package com.nopcomerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class User_01_Lv3_BasePage_Inheritant extends BasePage{
    WebDriver driver;
    String email = "xuyenltn" + new Random().nextInt() + "@gmail.com";

    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--user-data-dir=/Users/xuyenchi/Library/Application Support/Google/Chrome/Profile 14");
        chromeOptions.addArguments("--profile-directory=Profile 14");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //driver.get("https://demo.nopcommerce.com/");
        driver.get("http://live.techpanda.org/");
    }

//    @Test
//    public void TC_01_Register() throws InterruptedException {
//        System.out.println("TC 01");
//        driver.findElement(By.xpath("//a[text()='Register']")).click();
//
//        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
//        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Xuyen");
//        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Le");
//        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
//        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("ABC Company");
//        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
//        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");
//        driver.findElement(By.xpath("//button[@id='register-button']")).click();
//        Thread.sleep(6000);
//
//
//    }
//
//    @Test
//    public void TC_02_Login() throws InterruptedException {
//        driver.findElement(By.xpath("//a[text()='Log in']")).click();
//        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
//        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
//        driver.findElement(By.xpath("//button[text()='Log in']")).click();
//        Thread.sleep(6000);
@Test
public void TC_01_Register_Techpanda() {




    String firstname = "Le";
    String middlename = "Ngoc";
    String lastname = "Xuyen";
    String email_address = "xuyen" + new Random().nextInt() + "@gmail.com";
    String password = "123456";
    String fullname = firstname + " " + middlename + " " + lastname;

    waitForElementClickable(driver, "//div[@class='footer-container']//a[text()='My Account']");
    clickToElement(driver, "//div[@class='footer-container']//a[text()='My Account']");

    waitForElementClickable(driver, "//span[text()='Create an Account']");
    clickToElement(driver, "//span[text()='Create an Account']");

    senkeyToElement(driver, "//input[@id='firstname']", firstname);
    senkeyToElement(driver, "//input[@id='middlename']", middlename);
    senkeyToElement(driver, "//input[@id='lastname']", lastname);
    senkeyToElement(driver, "//input[@id='email_address']", email_address);
    senkeyToElement(driver, "//input[@id='password']", password);
    senkeyToElement(driver, "//input[@id='confirmation']", password);
    clickToElement(driver, "//span[text()='Register']");

    Assert.assertEquals(getElementText(driver,"//li[@class='success-msg']//span"),"Thank you for registering with Main Website Store.");
   // Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"Thank you for registering with Main Website Store.");

    String contactInfo = getElementText(driver,"//h3[text()='Contact Information']/parent::div/following-sibling::div/p");
    System.out.println("contactInfo:" + contactInfo);
    Assert.assertTrue(contactInfo.contains(fullname));
    Assert.assertTrue(contactInfo.contains(email_address));






}
    @Test
    public void TC_02_MyAccount() throws InterruptedException {
        waitForElementClickable(driver, "//div[@class='account-cart-wrapper']//span[text()='Account']");
        clickToElement(driver, "//div[@class='account-cart-wrapper']//span[text()='Account']");

        waitForElementClickable(driver, "//div[@id='header-account']//a[text()='My Account']");
        clickToElement(driver, "//div[@id='header-account']//a[text()='My Account']");


        Thread.sleep(3000);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
