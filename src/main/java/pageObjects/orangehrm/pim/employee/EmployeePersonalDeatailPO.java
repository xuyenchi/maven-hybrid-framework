package pageObjects.orangehrm.pim.employee;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.pim.employee.PersonalDetailsUI;

public class EmployeePersonalDeatailPO extends EmployeeTabsPO {

    public EmployeePersonalDeatailPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;

    public void clickImgUploadAvt() {
        waitForElementClickable(driver, PersonalDetailsUI.IMG_UPLOAD_AVT);
        clickToElement(driver, PersonalDetailsUI.IMG_UPLOAD_AVT);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, PersonalDetailsUI.SAVE_BUTTON_UPLOAD_AVT);
        clickToElement(driver, PersonalDetailsUI.SAVE_BUTTON_UPLOAD_AVT);
    }


    public Dimension getAvtSize() {
        return getElementSize(driver, PersonalDetailsUI.IMG_UPLOAD_AVT);
    }

    public boolean isProfileAvtUpdateSuccess(Dimension beforeUpload) {
        Dimension afterUpload = getAvtSize();
        System.out.println("Width after " + afterUpload.getWidth()); // ✅ Đúng
        System.out.println("Height after: " + afterUpload.getHeight());
        return beforeUpload.equals(afterUpload);
    }

    public void enterFirstNameTextbox(String editFirstName) {
        waitForElementVisible(driver,PersonalDetailsUI.FIRSTNAME_TEXTBOX);
        clearAttributeValue(driver, PersonalDetailsUI.FIRSTNAME_TEXTBOX);
        senkeyToElement(driver, PersonalDetailsUI.FIRSTNAME_TEXTBOX, editFirstName);
    }

    public void enterLastNameTextbox(String editLastName) {
        waitForElementVisible(driver,PersonalDetailsUI.LASTNAME_TEXTBOX);
        clearAttributeValue(driver, PersonalDetailsUI.LASTNAME_TEXTBOX);
        senkeyToElement(driver, PersonalDetailsUI.LASTNAME_TEXTBOX, editLastName);
    }

    public String getEmployeeID() {
        return getElementAtribute(driver, PersonalDetailsUI.EMPLOYEE_ID_TEXTBOX,"value");


    }

    public void enterDriverLicenseTextbox(String editDriverLicense) {
        waitForElementVisible(driver,PersonalDetailsUI.DRIVER_LICENSE_TEXTBOX);
        senkeyToElement(driver, PersonalDetailsUI.DRIVER_LICENSE_TEXTBOX, editDriverLicense);
    }

    public void selectNationalityDropdown(String nationality) throws InterruptedException {
        waitForElementClickable(driver, PersonalDetailsUI.NATIONNALITY_SELECT);
        selectItemInCustomDropdown(driver, PersonalDetailsUI.NATIONNALITY_SELECT, PersonalDetailsUI.NATIONALITY_CHILD, nationality);
    }

    public void selectMaritalSatusDropdown(String marital) throws InterruptedException {
        waitForElementClickable(driver, PersonalDetailsUI.MARTIAL_STATUS_SELECT);
        selectItemInCustomDropdown(driver, PersonalDetailsUI.MARTIAL_STATUS_SELECT, PersonalDetailsUI.MARTIAL_STATUS_CHILD, marital);
    }

    public void enterDateOfBirthTextbox(String dob) {
        waitForElementVisible(driver, PersonalDetailsUI.DATE_OF_BIRTH_TEXTBOX);
        senkeyToElement(driver, PersonalDetailsUI.DATE_OF_BIRTH_TEXTBOX, dob);
    }

    public void selectGenderMaleRadio(String gender) throws InterruptedException {
       // waitForElementClickable(driver, PersonalDetailsUI.GENDER_RADIO, gender);
        checkToCheckboxRadio(driver, PersonalDetailsUI.GENDER_RADIO, gender);
       // clickToElement(driver, PersonalDetailsUI.GENDER_RADIO, gender);
        clickToElementByJS(driver, PersonalDetailsUI.GENDER_RADIO, gender);


    }

    public void clickSaveButtonAtPersonalDetail() {
        waitForElementClickable(driver, PersonalDetailsUI.SAVE_BUTTON_PERSONAL_DETAILS);
        clickToElement(driver, PersonalDetailsUI.SAVE_BUTTON_PERSONAL_DETAILS);
    }

    public String getFirstName() {
        waitForElementVisible(driver, PersonalDetailsUI.FIRSTNAME_TEXTBOX);
        return getElementAtribute(driver, PersonalDetailsUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastName() {
        waitForElementVisible(driver, PersonalDetailsUI.LASTNAME_TEXTBOX);
        return getElementAtribute(driver, PersonalDetailsUI.LASTNAME_TEXTBOX, "value");
    }

    public String getDriverLicense() {
        waitForElementVisible(driver, PersonalDetailsUI.DRIVER_LICENSE_TEXTBOX);
        return getElementAtribute(driver, PersonalDetailsUI.DRIVER_LICENSE_TEXTBOX, "value");
    }

    public String getNationality() {
        waitForElementVisible(driver, PersonalDetailsUI.NATIONALITY_SELECTED);
        return getElementText(driver, PersonalDetailsUI.NATIONALITY_SELECTED);

    }

    public String getMaritalStatus() {
        waitForElementVisible(driver, PersonalDetailsUI.MARITAL_SELECTED);
        return getElementText(driver, PersonalDetailsUI.MARITAL_SELECTED);
    }

    public String getDOB() {
        waitForElementVisible(driver, PersonalDetailsUI.DATE_OF_BIRTH_TEXTBOX);
        return getElementAtribute(driver, PersonalDetailsUI.DATE_OF_BIRTH_TEXTBOX, "value");
    }
    public boolean isGenderMaleSelected(String gender){
        waitForElementSelected(driver, PersonalDetailsUI.GENDER_RADIO_INPUT, gender);
        return isElemenSelected(driver, PersonalDetailsUI.GENDER_RADIO_INPUT, gender);


    };

}
