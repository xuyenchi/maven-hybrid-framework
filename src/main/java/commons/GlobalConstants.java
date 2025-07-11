package commons;

public class GlobalConstants {
    //System info
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");


    //Enviroment
    public static final String DEV_USER_URL = "http://dev.techpanda.org/";
    public static final String STAGIN_USER_URL = "http://stagin.techpanda.org/";
    public static final String LIVE_USER_URL = "http://live.techpanda.org/";

    public static final String DEV_ADMIN_URL = "http://dev.techpanda.org/";
    public static final String STAGIN_ADMIN_URL = "http://stagin.techpanda.org/";
    public static final String LIVE_ADMIN_URL = "https://admin-demo.nopcommerce.com/";


    //Wait for
    public static final long SHORT_TIMEOUT = 10;
    public static final long LONG_TIMEOUT = 30;

    //User info
    public static final String ADMIN_TECH_USERNAME = "user01";
    public static final String ADMIN_TECH_PASS = "guru99com";
    public static final String ADMIN_NOP_USERNAME = "admin@yourstore.com";
    public static final String ADMIN_NOP_PASS = "admin";
    public static final String ADMIN_ORANGE_USERNAME = "Admin";
    public static final String ADMIN_ORANGE_PASS = "admin123";


    //download/upload path
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;

    //retry case fail
    public static final int RETRY_TIME = 3;

    //Browser log/extension
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + SEPARATOR + "browserLogs" + SEPARATOR;
    public static final String BROWSER_ETENSION_PATH = PROJECT_PATH + SEPARATOR + "browserExtensions" + SEPARATOR;

    //HTML report
    public static final String REPORT_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG" + SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + SEPARATOR + "htmlAllure" + SEPARATOR;

    //Data test
    public static final String DATA_TEST_PATH = PROJECT_PATH + SEPARATOR + "testdata" + SEPARATOR;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + SEPARATOR + "environmentConfig" + SEPARATOR;

    //BrowserStack
    public static final String BROWSER_USERNAME = "ngcxuynlth1";
    public static final String BROWSER_AUTOMATE_KEY = "C6gcEtYjys6KxGWW3i5U";
    public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    //Saucelab
    public static final String SAUCE_USERNAME = "oauth-ngocxuyenlt1996-1b393";
    public static final String SAUCE_AUTOMATE_KEY = "95081210-db13-44fc-8f96-91a05e8b7d5d";
    public static final String SAUCE_URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_AUTOMATE_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    //LamdaTest
    public static final String LAMBDA_USERNAME = "ngocxuyenlt1996";
    public static final String LAMBDA_AUTOMATE_KEY = "LT_HlKRvZFuMX2zEqcY3fuDCOsRTrKBjlBHEF5Uri60iKyXJds";
    public static final String LAMBDA_URL = "https://hub.lambdatest.com/wd/hub";
}
