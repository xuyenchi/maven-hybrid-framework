package pageObjects.nopcomerce.user;

import org.openqa.selenium.WebDriver;
import pageObjects.nopcomerce.PageGenerator;
import pageUIs.user.UserMyAccountUI;

public class UserMyAccountPO extends UserSidebarPO {
    private WebDriver driver;

    public UserMyAccountPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getSuccessRegister() {
        return getElementText(driver, UserMyAccountUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getContactInfo() {
        return getElementText(driver, UserMyAccountUI.CONTACT_INFO_LABEL);
    }

    public void clickAccountLink() {
        waitForElementClickable(driver, UserMyAccountUI.ACCOUNT_LINK);
        clickToElement(driver, UserMyAccountUI.ACCOUNT_LINK);

    }

    public UserMyAccountPO openMyAccountPage() {
        waitForElementClickable(driver, UserMyAccountUI.MYACCOUNT_LINK);
        clickToElement(driver, UserMyAccountUI.MYACCOUNT_LINK);
        return PageGenerator.getUserMyAccountPage(driver);
    }


}
