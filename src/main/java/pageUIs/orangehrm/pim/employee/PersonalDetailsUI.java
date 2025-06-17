package pageUIs.orangehrm.pim.employee;

public class PersonalDetailsUI {
    public static final String IMG_UPLOAD_AVT = "xpath=//div[@class='orangehrm-edit-employee-name']/following-sibling::div//img[@class='employee-image']";
    public static final String ICON_UPLOAD_AVT = "xpath=//input[@type='file']";
    public static final String SAVE_BUTTON_UPLOAD_AVT = "xpath=//button[contains(string(),'Save')]";
    public static final String FIRSTNAME_TEXTBOX = "xpath=//input[@name='firstName']";
    public static final String LASTNAME_TEXTBOX = "xpath=//input[@name='lastName']";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String DRIVER_LICENSE_TEXTBOX = "xpath=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div/input";
    public static final String NATIONNALITY_SELECT = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String NATIONALITY_CHILD = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
    public static final String MARTIAL_STATUS_SELECT = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String MARTIAL_STATUS_CHILD = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
    public static final String DATE_OF_BIRTH_TEXTBOX = "xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
    public static final String GENDER_RADIO = "xpath=//label[text()='Gender']/parent::div/following-sibling::div//label[contains(string(),'%s')]//span";
    public static final String GENDER_RADIO_INPUT = "xpath=//label[text()='Gender']/parent::div/following-sibling::div//label[contains(string(),'%s')]//input";

    public static final String SAVE_BUTTON_PERSONAL_DETAILS = "xpath=//h6[text()='Personal Details']/following-sibling::form//button";
    public static final String NATIONALITY_SELECTED = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String MARITAL_SELECTED = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";

}
