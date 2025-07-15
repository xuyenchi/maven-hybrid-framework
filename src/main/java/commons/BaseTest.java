package commons;


import browserFactory.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BaseTest {
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    protected int generateRandomNumber() {
        return new Random().nextInt(99999);
    }

    protected final Logger log;

    protected WebDriver getBrowserName(String browserName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case CHROME:
                driver = new ChromeBrowser().getDriver();
                break;
            case FIREFOX:
               // driver = new FirefoxDriver();
                driver = new FirefoxBrowser().getDriver();

                break;
            case HFIREFOX:
//                FirefoxOptions options = new FirefoxOptions();
//                options.addArguments("-headless");
//                options.addArguments("window-size=1920x1080");
//                driver = new FirefoxDriver(options);
                driver = new FirefoxHeadlessBrowser().getDriver();
                break;
            case HCHROME:
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("--headless");
//                chromeOptions.addArguments("window-size=1920x1080");
//                driver = new ChromeDriver(chromeOptions);
                driver = new ChromeHeadlessBrowser().getDriver();
                break;
            default:
                throw new RuntimeException("Browser not valid");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(GlobalConstants.LIVE_USER_URL);
        return driver;
    }

    protected WebDriver getBrowserName(String browserName, String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case CHROME:
                ChromeOptions cOptions = new ChromeOptions();
                //disable noti
                cOptions.addArguments("--disable-notifications");
                // disable google map
                cOptions.addArguments("--disable-geolocation");
                // disable auto
                cOptions.setExperimentalOption("useAutomationExtension", false);
                cOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                // disable save pass
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.pasword_manager_enable", false);
                //disable save card
                prefs.put("autofill.credit_card_enabled", false);

                cOptions.setExperimentalOption("prefs", prefs);


                driver = new ChromeDriver(cOptions);
                break;
            case FIREFOX:
//                FirefoxOptions fOptions = new FirefoxOptions();
//                fOptions.addPreference("dom.webnotifications.enabled", false);
//                fOptions.addPreference("geo.enabled", false);
//                fOptions.addPreference("geo.provider.use_corelocation", false);

                driver = new FirefoxDriver();
                break;

            case HFIREFOX:
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("-headless");
                options.addArguments("window-size=1920x1080");
                driver = new FirefoxDriver(options);
                break;
            case HCHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("window-size=1920x1080");
                driver = new ChromeDriver(chromeOptions);
                break;

            default:
                throw new RuntimeException("Browser not valid");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    //hàm get browser với cloud
    protected WebDriver getBrowserNameBrowserStack(String url, String osName, String osVersion, String browserName, String browserVersion) {

        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
        capabilities.setCapability("browserName", browserName);
        bstackOptions.put("os", osName);
        bstackOptions.put("osVersion", osVersion);
        bstackOptions.put("browserVersion", browserVersion);
        bstackOptions.put("userName", GlobalConstants.BROWSER_USERNAME);
        bstackOptions.put("accessKey", GlobalConstants.BROWSER_AUTOMATE_KEY);
        bstackOptions.put("seleniumVersion", "4.33.0");
        capabilities.setCapability("bstack:options", bstackOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    protected WebDriver getBrowserNameSauceLab(String url, String platform, String browserName, String browserVersion) {
        MutableCapabilities capability = null;
        browserName = browserName.toLowerCase();
        switch (browserName) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setPlatformName(platform);
                fOptions.setBrowserVersion(browserVersion);
                capability = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setPlatformName(platform);
                cOptions.setBrowserVersion(browserVersion);
                capability = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setPlatformName(platform);
                eOptions.setBrowserVersion(browserVersion);
                capability = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setPlatformName(platform);
                sOptions.setBrowserVersion(browserVersion);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        HashMap<String, String> sauceOptions = new HashMap<String, String>();
        sauceOptions.put("username", GlobalConstants.SAUCE_USERNAME);
        sauceOptions.put("accessKey", GlobalConstants.SAUCE_AUTOMATE_KEY);
        sauceOptions.put("build", "automation-fc-build");
        sauceOptions.put("name", "Run on " + platform + " | " + browserName + " | " + browserVersion);

        capability.setCapability("sauce:options", sauceOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCE_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    protected WebDriver getBrowserNameLamdatest(String url, String platform, String browserName, String browserVersion) {
        MutableCapabilities capability = null;
        browserName = browserName.toLowerCase();
        switch (browserName) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setPlatformName(platform);
                fOptions.setBrowserVersion(browserVersion);
                capability = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setPlatformName(platform);
                cOptions.setBrowserVersion(browserVersion);
                capability = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setPlatformName(platform);
                eOptions.setBrowserVersion(browserVersion);
                capability = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setPlatformName(platform);
                sOptions.setBrowserVersion(browserVersion);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        HashMap<String, String> lamdaOptions = new HashMap<String, String>();
        lamdaOptions.put("username", GlobalConstants.LAMBDA_USERNAME);
        lamdaOptions.put("accessKey", GlobalConstants.LAMBDA_AUTOMATE_KEY);
        lamdaOptions.put("build", "automation-fc-build");
        lamdaOptions.put("project", "Techpanda");
        lamdaOptions.put("name", "Run on " + platform + " | " + browserName + " | " + browserVersion);
        lamdaOptions.put("selenium_version", "4.33.0");
//        lamdaOptions.put("w3c", true);


        capability.setCapability("LT:Options", lamdaOptions);


        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.LAMBDA_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    protected void assertFalse(boolean condition) {
        Assert.assertTrue(verifyFalse(condition));
    }

    protected boolean verifyFalse(boolean condition) {
        boolean status = true;
        try {
            Assert.assertFalse(condition);
            log.info("---------PASSED----------");

        } catch (Throwable e) {
            status = false;
            log.info("----------FAILED-----------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);

        }
        return status;

    }

    protected boolean verifyTrue(boolean condition) {
        boolean status = true;
        try {
            Assert.assertTrue(condition);
            log.info("---------PASSED----------");

        } catch (Throwable e) {
            status = false;
            log.info("---------FAILED----------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);

        }
        return status;

    }

    protected boolean verifyEquals(Object expected, Object actual) {
        boolean status = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("---------PASSED----------");

        } catch (Throwable e) {
            status = false;
            log.info("---------FAILED----------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);

        }
        return status;

    }

    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }