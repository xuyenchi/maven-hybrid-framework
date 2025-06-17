package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangehrm.pim.employee.AddEmployeeUI;

public class AddEmployeePO extends BasePage {
    public AddEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public void enterFirstnameTextbox(String firstName) {
        senkeyToElement(driver, AddEmployeeUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterLastnameTextbox(String lastName) {
        senkeyToElement(driver, AddEmployeeUI.LASTNAME_TEXTBOX, lastName);

    }

    public String getEmployeeID() {
       // waitForElementInvisible(driver, AddEmployeeUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAtribute(driver, AddEmployeeUI.EMPLOYEE_ID_TEXTBOX,"value");
        //String value = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value");
       // return value;
    }

    public EmployeePersonalDeatailPO clickToSaveButton() {
        waitForElementClickable(driver, AddEmployeeUI.BUTTON_SAVE_AT_ADD_EMPLOYEE);
        clickToElement(driver, AddEmployeeUI.BUTTON_SAVE_AT_ADD_EMPLOYEE);
        waitAllIconLoadingInvisiblae(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }
}
