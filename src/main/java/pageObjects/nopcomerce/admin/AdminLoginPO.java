package pageObjects.nopcomerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcomerce.PageGenerator;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    WebDriver driver;
    public AdminLoginPO(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsernameTextbox(String adminUser) {
        //waitForElementInvisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        clearInput(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        senkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, adminUser);
    }

    public void enterPassTextbox(String adminPass) {
        //waitForElementInvisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        clearInput(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        senkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPass);
    }

    public AdminDashboardPO clickLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getAdminDashboardPage(driver);
    }
}
