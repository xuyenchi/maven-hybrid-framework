package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageUI;
import pageUIs.user.BasePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePO extends BasePage {
    WebDriver driver;
    public HomePO(WebDriver driver){
        this.driver = driver;
    }

    public void openPaginByNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_LINK_PAGIN, pageNumber);
        clickToElement(driver, HomePageUI.DYNAMIC_LINK_PAGIN, pageNumber);
        //Assert.assertTrue(HomePageUI.DYNAMIC_LINK_PAGIN);
    }

    public boolean isPageNumberActive(String pageNumber) {
        return  getElementAtribute(driver, HomePageUI.DYNAMIC_LINK_PAGIN, "class", pageNumber ).contains("active");
    }

    public void enterToTextBoxByHeaderName(String headerName, String key) {

        senkeyToElement(driver, HomePageUI.DYNAMIC_TEXBOX_BY_HEADER_NAME, key, headerName);
        pressKeyToElement(driver, HomePageUI.DYNAMIC_TEXBOX_BY_HEADER_NAME, Keys.ENTER, headerName);

    }

    public boolean isDataRowDisplay(String female, String country, String male, String total) {
            return isElementDisplay(driver, HomePageUI.DYNAMIC_DATA_ROW, female, country, male, total);
    }

    public void deleRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_DELETE_BUTTON, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_DELETE_BUTTON, countryName);

    }

    public void clickLoadData() {
        waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
    }

    public void enterTextBoxByIndex(String rowIndex, String columnName, String value) {
        //Từ columnName lấy được column index
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_COLUMN, columnName).size() + 1;
        // Convert qua dạng text
        String columnIndex = String.valueOf(columnIndexNumber);
        //Truyền rownIndex và columnIndex để truyền vào locator
        senkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROWINDEX_COLUMNINDEX, value, rowIndex, columnIndex);
    }

    public void selectToDropdownByIndex(String rowIndex, String columnName, String value) {
        //Từ columnName lấy được column index
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_COLUMN, columnName).size() + 1;
        // Convert qua dạng text
        String columnIndex = String.valueOf(columnIndexNumber);
        //select
        selectItemInDropdown(driver, HomePageUI.DYNAMIC_SELECT_BY_ROWINDEX_COLUMNINDEX, value, rowIndex, columnIndex);
    }

    public void checkToCheckboxByIndex(String rowIndex, String columnName, boolean check) {
        //Từ columnName lấy được column index
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_COLUMN, columnName).size() + 1;
        // Convert qua dạng text
        String columnIndex = String.valueOf(columnIndexNumber);
        //check or uncheck
        if(check){
            checkToCheckboxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROWINDEX_COLUMNINDEX, rowIndex, columnIndex);

        }else {
            uncheckToCheckbox(driver,HomePageUI.DYNAMIC_CHECKBOX_BY_ROWINDEX_COLUMNINDEX, rowIndex, columnIndex);
        }
    }

    public void clickIconByIndex(String rowIndex, String iconName) {

        //click icon
        clickToElement(driver, HomePageUI.DYNAMIC_ICON_BY_ROWINDEX, rowIndex, iconName);
    }

    public List<String> getAllValueAtColumnName(String columnName) {
        //Từ columnName lấy được column index
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_COLUMN2, columnName).size() + 1;
        // Convert qua dạng text
        String columnIndex = String.valueOf(columnIndexNumber);
        List<WebElement> allValueAtColunb = getListElement(driver, HomePageUI.ALL_VALUE_COLUMNINDEX, columnIndex);
        List<String> allTextValue = new ArrayList<String>();
        for(WebElement element : allValueAtColunb){
            allTextValue.add(element.getText());
        }
        return allTextValue;
    }

    public boolean isFileLoadSuccess(String fileName) {
        return isElementDisplay(driver, BasePageUI.FILE_LOAD_SUCCESS, fileName);
    }

    public void clickUploadButton() throws InterruptedException {
        List<WebElement> startButtons = getListElement(driver, BasePageUI.UPLOAD_BUTTON);
        for(WebElement button : startButtons){
            button.click();
            Thread.sleep(2);
        }

    }

    public boolean isFileUploaded(String fileName) {
        return isElementDisplay(driver, BasePageUI.FILE_UPLOADED, fileName);
    }
}
