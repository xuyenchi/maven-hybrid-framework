package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangehrm.pim.employee.EmployeeTabsUI;

public class EmployeeTabsPO extends BasePage {
    public EmployeeTabsPO(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public EmployeePersonalDeatailPO openPersonalDetailPage(){
        waitForElementClickable(driver, EmployeeTabsUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver, EmployeeTabsUI.PERSONAL_DETAIL_LINK);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    public ContactDetailsPO openContactDetailPage(){
        waitForElementClickable(driver, EmployeeTabsUI.CONTACT_DETAIL_LINK);
        clickToElement(driver, EmployeeTabsUI.CONTACT_DETAIL_LINK);
        return PageGenerator.getContactDetailPage(driver);
    }

    public EmergencyContactPO openEmergencyContactPage(){
        waitForElementClickable(driver, EmployeeTabsUI.EMERGENCY_CONTACT_LINK);
        clickToElement(driver, EmployeeTabsUI.EMERGENCY_CONTACT_LINK);
        return PageGenerator.getEmergencyContactPage(driver);
    }
}
