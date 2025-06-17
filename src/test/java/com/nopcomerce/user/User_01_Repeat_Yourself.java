package com.nopcomerce.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class User_01_Repeat_Yourself {
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


    driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
    driver.findElement(By.xpath("//span[text()='Create an Account']")).click();

    String firstname = "Le";
    String middlename = "Ngoc";
    String lastname = "Xuyen";
    String email_address = "xuyen" + new Random().nextInt() + "@gmail.com";
    String password = "123456";
    String fullname = firstname + " " + middlename + " " + lastname;
    String review_field = "Best product\n Best phone";
    String summary_review = "Hot phone";

    driver.findElement(By.id("firstname")).sendKeys(firstname);
    driver.findElement(By.id("middlename")).sendKeys(middlename);
    driver.findElement(By.id("lastname")).sendKeys(lastname);
    driver.findElement(By.id("email_address")).sendKeys(email_address);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.id("confirmation")).sendKeys(password);
    driver.findElement(By.xpath("//span[text()='Register']")).click();

    Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"Thank you for registering with Main Website Store.");

    String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

    Assert.assertTrue(contactInfo.contains(fullname));
    Assert.assertTrue(contactInfo.contains(email_address));

    driver.findElement(By.xpath("//a[text()='Mobile']")).click();
    driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();
    driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

    driver.findElement(By.xpath("//input[@id='Quality 1_5']")).click();
    driver.findElement(By.id("review_field")).sendKeys(review_field);
    driver.findElement(By.id("summary_field")).sendKeys(summary_review);
    driver.findElement(By.xpath("//button[@title='Submit Review']")).click();
    Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"Your review has been accepted for moderation.");




}
    @Test
    public void TC_02_MyAccount() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//div[@id='header-account']//a[text()='My Account']")).click();
        Thread.sleep(3000);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
