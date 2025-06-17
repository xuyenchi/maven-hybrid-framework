package pageObjects.nopcomerce.user;

import org.openqa.selenium.WebDriver;

public class UserAddressBookPO extends UserSidebarPO {
    WebDriver driver;
    public UserAddressBookPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


}
