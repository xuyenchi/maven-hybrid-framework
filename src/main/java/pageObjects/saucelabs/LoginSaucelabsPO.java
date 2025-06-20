package pageObjects.saucelabs;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.DashboardPO;
import pageUIs.orangehrm.pim.LoginUI;
import pageUIs.saucelabs.LoginSaucelabsPageUI;

public class LoginSaucelabsPO extends BasePage {
    WebDriver driver;

    public LoginSaucelabsPO(WebDriver driver) {
        this.driver = driver;
    }


    public void enterUsernameTextbox(String userName) {
        waitForElementVisible(driver, LoginSaucelabsPageUI.USERNAME_TEXTBOX);
        senkeyToElement(driver, LoginSaucelabsPageUI.USERNAME_TEXTBOX, userName);
    }

    public void enterPassTextbox( String password) {
        waitForElementVisible(driver, LoginSaucelabsPageUI.PASS_TEXTBOX);
        senkeyToElement(driver, LoginSaucelabsPageUI.PASS_TEXTBOX, password);
    }

    public InventoryPO clickToButtonLogin(WebDriver driver) {
        waitForElementClickable(driver, LoginSaucelabsPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginSaucelabsPageUI.LOGIN_BUTTON);
        return PageGenerator.getInventoryPage(driver);
    }
}
