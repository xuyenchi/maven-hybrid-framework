package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangehrm.pim.employee.EmployeeListUI;

public class

EmployeeListPO extends BasePage {
    WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }


    public AddEmployeePO clickToAddEmployee() {
        waitForElementClickable(driver, EmployeeListUI.ADD_EMPLOYEE_LINK);
        clickToElement(driver, EmployeeListUI.ADD_EMPLOYEE_LINK);
        waitAllIconLoadingInvisiblae(driver);
        return PageGenerator.getAddEmployee(driver);
    }
}
