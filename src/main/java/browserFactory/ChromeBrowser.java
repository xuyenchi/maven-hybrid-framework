package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser implements BrowserFactory{
    @Override
    public WebDriver getDriver() {
        ChromeOptions cOptions = new ChromeOptions();
        return new ChromeDriver(cOptions);
    }
}
