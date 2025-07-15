package browserFactory;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEBrowser implements BrowserFactory{
    @Override
    public WebDriver getDriver() {
        if(!GlobalConstants.OS_NAME.contains("Windows")){
            throw new BrowserNotSupport("IE not support on " + GlobalConstants.OS_NAME);
        }
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.destructivelyEnsureCleanSession();
        ieOptions.ignoreZoomSettings();
        ieOptions.introduceFlakinessByIgnoringSecurityDomains();
        return new InternetExplorerDriver(ieOptions);
    }
}
