package pageObjects.orangehrm.pim.employee;

import org.openqa.selenium.WebDriver;

public class ContactDetailsPO extends EmployeeTabsPO {
    public ContactDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;
}
