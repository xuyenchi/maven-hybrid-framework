package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.employee.EmployeeListPO;
import pageUIs.orangehrm.pim.DashboardUI;

public class DashboardPO extends BasePage {
    WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }


    public EmployeeListPO clickToPIMPage() {
        waitForElementClickable(driver, DashboardUI.PIM_LINK);
        clickToElement(driver, DashboardUI.PIM_LINK);
        waitAllIconLoadingInvisiblae(driver);
        return PageGenerator.getEmployeeListPage(driver);
    }
}
