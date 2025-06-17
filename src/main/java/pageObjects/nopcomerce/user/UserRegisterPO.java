package pageObjects.nopcomerce.user;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcomerce.PageGenerator;
import pageUIs.user.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter Firstname : {0}")
    public void enterFirstnameTextbox(String key) {
        senkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, key);

    }
    @Step("Enter Middlename : {0}")
    public void enterMiddlenameTextbox(String key) {
        senkeyToElement(driver, UserRegisterPageUI.MIDDLENAME_TEXTBOX, key);
    }
    @Step("Enter Lastname : {0}")
    public void enterLastnameTextbox(String key) {
        senkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, key);
    }

    @Step("Enter Email : {0}")
    public void enterEmailTextbox(String key) {
        senkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, key);
    }

    @Step("Enter Pass : {0}")
    public void enterPasswordTextbox(String key) {
        senkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, key);
    }

    @Step("Enter Re-Pass : {0}")
    public void enterConfirmPasswordTextbox(String key) {
        senkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, key);
    }

    @Step("Click button Register")
    public UserMyAccountPO clickRegisterButon() {
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
        return PageGenerator.getUserMyAccountPage(driver);
    }
}
