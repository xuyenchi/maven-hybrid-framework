package com.orangehrm.employee;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.PageGenerator;
import pageObjects.orangehrm.pim.employee.AddEmployeePO;
import pageObjects.orangehrm.pim.employee.EmployeeListPO;
import pageObjects.orangehrm.pim.employee.EmployeePersonalDeatailPO;

public class PIM_01_Employee extends BaseTest {
    WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private EmployeePersonalDeatailPO personalDetailPage;
    private AddEmployeePO addEmployeePage;
    private
    String firstName = "Xuyen";
    String lastName = "Le";
    String employeeID;
    private String avtImageName = "danang.png";
    String editFirstName = "Tuong";
    String editLastName = "Ngo";
    String editDriverLicense = "ABC";
    String nationality = "Afghan";
    String martialStatus = "Single";
    String DOB = "1996-19-09";
    String gender = "Male";


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserName(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.enterUsernameTextbox(GlobalConstants.ADMIN_ORANGE_USERNAME);
        loginPage.enterPassTextbox(GlobalConstants.ADMIN_ORANGE_PASS);
        dashboardPage = loginPage.clickLoginButton();


    }

    @Test
    public void Employee_01_Add_New() {
        //System.out.println("Hello");
        // dashboardPage.waitAllIconLoadingInvisiblae(driver);đưa sự kiện wait này vào hàm click button chuyển trang luôn
        employeeListPage = dashboardPage.clickToPIMPage();
        addEmployeePage = employeeListPage.clickToAddEmployee();
        addEmployeePage.enterFirstnameTextbox(firstName);
        addEmployeePage.enterLastnameTextbox(lastName);
        employeeID = addEmployeePage.getEmployeeID();
        System.out.println("employee Id:" + employeeID);
        personalDetailPage = addEmployeePage.clickToSaveButton();


    }

    @Test
    public void Employee_02_Upload_Avatar() throws InterruptedException {
       // System.out.println("Hello");
        personalDetailPage.clickImgUploadAvt();
        //lấy height width của element avt
        Dimension beforeUpload = personalDetailPage.getAvtSize();
        System.out.println("Width before: " + beforeUpload.getWidth()); // ✅ Đúng
        System.out.println("Height before: " + beforeUpload.getHeight());

        personalDetailPage.uploadMultipleFiles(driver, avtImageName);
        personalDetailPage.sleepInSeconds(3);
        personalDetailPage.clickToSaveButton();
        Assert.assertTrue(personalDetailPage.isSuccessMessageDisplayed(driver));
        personalDetailPage.waitAllIconLoadingInvisiblae(driver);
        personalDetailPage.sleepInSeconds(3);
        Assert.assertFalse(personalDetailPage.isProfileAvtUpdateSuccess(beforeUpload));

    }

    @Test
    public void Employee_03_Personal_Details() throws InterruptedException {
        //System.out.println("Hello");
        personalDetailPage.openPersonalDetailPage();
        personalDetailPage.waitAllIconLoadingInvisiblae(driver);
        personalDetailPage.sleepInSeconds(3);
        personalDetailPage.enterFirstNameTextbox(editFirstName);
        personalDetailPage.sleepInSeconds(3);
        personalDetailPage.enterLastNameTextbox(editLastName);
        personalDetailPage.sleepInSeconds(3);
        System.out.println("Employee id : " + personalDetailPage.getEmployeeID());
        Assert.assertEquals(personalDetailPage.getEmployeeID(), employeeID);
        personalDetailPage.sleepInSeconds(3);
        personalDetailPage.enterDriverLicenseTextbox(editDriverLicense);
        personalDetailPage.selectNationalityDropdown(nationality);
        personalDetailPage.selectMaritalSatusDropdown(martialStatus);
        personalDetailPage.enterDateOfBirthTextbox(DOB);
        personalDetailPage.selectGenderMaleRadio(gender);
        personalDetailPage.clickSaveButtonAtPersonalDetail();

        //Verify thông tin lưu chính xác
        Assert.assertTrue(personalDetailPage.isSuccessMessageDisplayed(driver));
        personalDetailPage.waitAllIconLoadingInvisiblae(driver);

        Assert.assertEquals(personalDetailPage.getFirstName(), editFirstName);
        Assert.assertEquals(personalDetailPage.getLastName(), editLastName);
        Assert.assertEquals(personalDetailPage.getEmployeeID(), employeeID);
        Assert.assertEquals(personalDetailPage.getDriverLicense(), editDriverLicense);
        Assert.assertEquals(personalDetailPage.getNationality(), nationality);
        Assert.assertEquals(personalDetailPage.getMaritalStatus(), martialStatus);
        Assert.assertEquals(personalDetailPage.getDOB(), DOB);
        Assert.assertTrue(personalDetailPage.isGenderMaleSelected(gender));








    }

    @Test
    public void Employee_04_Contact_Details() {
        System.out.println("Hello");
    }

    @Test
    public void Employee_05_Emergency_Details() {
        System.out.println("Hello");
    }

    @Test
    public void Employee_06_Assigned_Dependents() {
        System.out.println("Hello");
    }

    @Test
    public void Employee_07_Immigration() {
        System.out.println("Hello");
    }

    @Test
    public void Employee_08_Job() {
        System.out.println("Hello");
    }

    @Test
    public void Employee_09_Salary() {
        System.out.println("Hello");
    }

    @Test
    public void Employee_10_ReportTo() {
        System.out.println("Hello");
    }

    @Test
    public void Employee_11_Qualifications() {
        System.out.println("Hello");
    }

    @Test
    public void Employee_12_Search_Employee() {
        System.out.println("Hello");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
