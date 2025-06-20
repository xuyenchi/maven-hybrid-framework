package pageObjects.saucelabs;

import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.pim.employee.*;

public class PageGenerator {
    public static InventoryPO getInventoryPage(WebDriver driver){
        return new InventoryPO(driver);
    }

    public static LoginSaucelabsPO getLoginSaucelabsPage(WebDriver driver){
        return new LoginSaucelabsPO(driver);
    }
}
