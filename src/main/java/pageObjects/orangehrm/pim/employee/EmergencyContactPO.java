package pageObjects.orangehrm.pim.employee;

import org.openqa.selenium.WebDriver;

public class EmergencyContactPO extends EmployeeTabsPO {
    public EmergencyContactPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;
}
