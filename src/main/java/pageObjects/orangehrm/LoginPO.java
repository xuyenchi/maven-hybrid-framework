package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.pim.LoginUI;

public class LoginPO extends BasePage {
    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }


    public void enterUsernameTextbox(String value) {
        senkeyToElement(driver, LoginUI.USERNAME_TEXTBOX, value);
    }

    public void enterPassTextbox(String value) {
        senkeyToElement(driver, LoginUI.PASS_TEXTBOX, value);
    }

    public DashboardPO clickLoginButton() {
        waitForElementClickable(driver, LoginUI.LOGIN_BUTTON);
        clickToElement(driver, LoginUI.LOGIN_BUTTON);
        waitAllIconLoadingInvisiblae(driver);
        return PageGenerator.getDashboardPage(driver);
    }
}
