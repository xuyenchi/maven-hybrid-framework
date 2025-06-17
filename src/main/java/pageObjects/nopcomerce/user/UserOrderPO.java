package pageObjects.nopcomerce.user;

import org.openqa.selenium.WebDriver;

public class UserOrderPO extends UserSidebarPO {
    WebDriver driver;
    public UserOrderPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


}
