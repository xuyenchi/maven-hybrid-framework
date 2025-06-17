package pageUIs.user;

public class BasePageUI {
    public static final String ADDRESS_BOOK_LINK = "xpath=//a[text()='Address Book']";
    public static final String MYACCOUNT_LINK = "xpath=//a[text()='Account Dashboard']";
    public static final String ORDER_LINK = "xpath=//a[text()='My Orders']";

    public static final String UPLOAD_FILE_TYPE = "xpath=//input[@type='file']";
    public static final String FILE_LOAD_SUCCESS = "xpath=//p[@class='name' and text()='%s']";
    public static final String UPLOAD_BUTTON = "xpath=//button/span[text()='Start']";
    public static final String FILE_UPLOADED = "xpath=//p[@class='name']/a[text()='%s']";

    //orange page
    public static final String ICON_LOADING = "xpath=//div[@class='oxd-loading-spinner']";
    public static final String SUCCESS_MESSAGE = "xpath=//p[text()='Successfully Updated']";


}
