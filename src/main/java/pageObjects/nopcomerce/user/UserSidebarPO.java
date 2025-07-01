package pageObjects.nopcomerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcomerce.PageGenerator;
import pageUIs.user.UserSidebarPageUI;


public class UserSidebarPO extends BasePage {
    WebDriver driver;

    public UserSidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserOrderPO openOrderPage() {
        waitForElementClickable(driver, UserSidebarPageUI.ORDER_LINK);
        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }

    public UserAddressBookPO openAdressPage() {
        waitForElementClickable(driver, UserSidebarPageUI.ADDRESS_BOOK_LINK);
        clickToElement(driver, UserSidebarPageUI.ADDRESS_BOOK_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }

    public UserMyAccountPO openMyAccountPage() {
        waitForElementClickable(driver, UserSidebarPageUI.MYACCOUNT_LINK);
        clickToElement(driver, UserSidebarPageUI.MYACCOUNT_LINK);
        return PageGenerator.getUserMyAccountPage(driver);
    }

    public UserSidebarPO openSidebarLinkByPageName(String pagename) {
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGENAME, pagename);
        clickToElement(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGENAME, pagename);
        switch (pagename) {
            case "Address Book":
                return PageGenerator.getUserAddressPage(driver);
            case "My Orders":
                return PageGenerator.getUserOrderPage(driver);
            case "Account Dashboard":
                return PageGenerator.getUserMyAccountPage(driver);
            default:
                throw new RuntimeException("This page name not valid");

        }

    }
    public void openSidebarLinkByPageNames(String pagename) {
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGENAME, pagename);
        clickToElement(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGENAME, pagename);

    }

}
