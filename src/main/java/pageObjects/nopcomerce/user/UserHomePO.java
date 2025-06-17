package pageObjects.nopcomerce.user;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcomerce.PageGenerator;
import pageUIs.jquery.HomePageUI;
import pageUIs.user.UserHomePageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;
    public UserHomePO(WebDriver driver){
        this.driver = driver;
    }
    @Step("Open Register Page")
    public UserRegisterPO openRegisterPage() {
        waitForElementClickable(driver, UserHomePageUI.MYACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MYACCOUNT_LINK);

        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);

        return PageGenerator.getUserRegisterPage(driver);
    }

    public String getTextpageTitle() {
        return getElementText(driver, HomePageUI.PAGE_TITLE_REGISTER);
    }
}
