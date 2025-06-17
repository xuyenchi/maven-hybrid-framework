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

public class User_01_Lv12_Data_Table extends BaseTest {
    WebDriver driver;
    private HomePO homePage;

    public User_01_Lv12_Data_Table() {
        super();
    }

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserName(browserName, url);
        homePage = PageGenerator.getHomePage(driver);

    }




    public void Table_01() throws InterruptedException {
        //navigate pagin
        homePage.openPaginByNumber("15");
        Assert.assertTrue(homePage.isPageNumberActive("15"));

        Thread.sleep(2000);
        homePage.openPaginByNumber("12");
        Assert.assertTrue(homePage.isPageNumberActive("12"));

        Thread.sleep(2000);
        homePage.openPaginByNumber("20");
        Assert.assertTrue(homePage.isPageNumberActive("20"));



    }

    public void Table_02() throws InterruptedException {
        homePage.enterToTextBoxByHeaderName("Country", "Albania");
        homePage.sleepInSeconds(2);
        Assert.assertTrue(homePage.isDataRowDisplay("24128","Albania","25266","49397"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextBoxByHeaderName("Males", "25266");
        homePage.sleepInSeconds(2);
        homePage.refreshCurrentPage(driver);


    }
    @Test
    public void Table_03_Edit_Or_Delete(){
        homePage.enterToTextBoxByHeaderName("Country", "Albania");
        homePage.deleRowByCountryName("Albania");
        homePage.refreshCurrentPage(driver);
    }

    //@Test
    public void Table_04_Action_By_Index() throws InterruptedException {
        homePage.openPageURL(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        homePage.clickLoadData();
        homePage.enterTextBoxByIndex("2", "Contact Person", "Xuyen");
        homePage.sleepInSeconds(3);
        homePage.enterTextBoxByIndex("1", "Company", "Xuyen Comppppppp");
        homePage.selectToDropdownByIndex("6", "Country","Hong Kong");
        homePage.sleepInSeconds(3);

        homePage.checkToCheckboxByIndex("2", "NPO?", true);
        homePage.checkToCheckboxByIndex("5", "NPO?", false);
        homePage.sleepInSeconds(3);

        homePage.clickIconByIndex("8", "Move Up");
        homePage.clickIconByIndex("1", "Insert");
        homePage.sleepInSeconds(3);




    }
    @Test
    public void Table_05_Get_All_Value_Row_Or_Column(){
        System.out.println(homePage.getAllValueAtColumnName("Country"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
