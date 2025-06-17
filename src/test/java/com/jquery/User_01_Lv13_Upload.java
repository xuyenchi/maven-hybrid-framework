package com.jquery;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;

public class User_01_Lv13_Upload extends BaseTest {
    WebDriver driver;
    private HomePO homePage;
    private String danang, phuquoc, hcm;

    public User_01_Lv13_Upload() {
        super();
    }

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserName(browserName, url);
        homePage = PageGenerator.getHomePage(driver);
        danang = "danang.png";
        phuquoc = "phuquoc.png";
        hcm = "hcm.png";

    }


    @Test
    public void Upload_01() throws InterruptedException {
        homePage.openPageURL(driver, "https://blueimp.github.io/jQuery-File-Upload/");
        //Lấy ra đúng đường dẫn cho Os đều chạy được

        //Upload 1 file
        homePage.uploadMultipleFiles(driver, danang);
        homePage.refreshCurrentPage(driver);


        //Upload nhiều file
        homePage.uploadMultipleFiles(driver, danang, phuquoc, hcm);
        homePage.sleepInSeconds(3);
        //Verify upload
        Assert.assertTrue(homePage.isFileLoadSuccess(danang));
        Assert.assertTrue(homePage.isFileLoadSuccess(phuquoc));
        Assert.assertTrue(homePage.isFileLoadSuccess(hcm));


        //click upload tại từng file
        homePage.clickUploadButton();

        //Verify upload thành công
        Assert.assertTrue(homePage.isFileUploaded(danang));
        Assert.assertTrue(homePage.isFileUploaded(phuquoc));
        Assert.assertTrue(homePage.isFileUploaded(hcm));




    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
