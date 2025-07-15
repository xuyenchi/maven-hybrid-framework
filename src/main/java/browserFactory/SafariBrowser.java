package browserFactory;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariBrowser implements BrowserFactory{
    @Override
    public WebDriver getDriver() {
        if(!GlobalConstants.OS_NAME.toUpperCase().contains("MAC")){
            throw new BrowserNotSupport("Safari not suport on " + GlobalConstants.OS_NAME);
        }
        SafariOptions safariOptions = new SafariOptions();
        return new SafariDriver(safariOptions);
    }
}
