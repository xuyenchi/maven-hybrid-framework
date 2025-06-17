package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.employee.*;

public class PageGenerator {
    public static LoginPO getLoginPage(WebDriver driver){
        return new LoginPO(driver);
    }

    public static DashboardPO getDashboardPage(WebDriver driver){
        return new DashboardPO(driver);
    }

    public static AddEmployeePO getAddEmployee(WebDriver driver){
        return new AddEmployeePO(driver);
    }

    public static ContactDetailsPO getContactDetailPage(WebDriver driver){
        return new ContactDetailsPO(driver);
    }

    public static EmergencyContactPO getEmergencyContactPage(WebDriver driver){
        return new EmergencyContactPO(driver);
    }

    public static EmployeeListPO getEmployeeListPage(WebDriver driver){
        return new EmployeeListPO(driver);
    }

    public static EmployeePersonalDeatailPO getPersonalDetailsPage(WebDriver driver){
        return new EmployeePersonalDeatailPO(driver);
    }
}
