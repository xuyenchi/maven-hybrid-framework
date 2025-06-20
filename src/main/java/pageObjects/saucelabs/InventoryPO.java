package pageObjects.saucelabs;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.saucelabs.InventoryPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPO extends BasePage {
    WebDriver driver;

    public InventoryPO(WebDriver driver) {
        this.driver = driver;
    }


    public void selectSortDropdown(String sortItem) throws InterruptedException {
        waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN);
        selectItemInDropdown(driver, InventoryPageUI.SORT_DROPDOWN, sortItem);
        sleepInSeconds(2);
    }

    public boolean isNameSortASC() {
        List<WebElement> productNameElement = getListElement(driver, InventoryPageUI.PRODUCT_NAME);
        //khai báo list string để add product name
        List<String> productNameText = new ArrayList<String>();
        for (WebElement element : productNameElement) {
            productNameText.add(element.getText());
        }

        //new thêm 1 list string nữa để đi sort và so sánh, sao chép toàn bộ productNameText qua list mới
        List<String> productNameTextSort = new ArrayList<String>(productNameText);

        //sort list trên
        Collections.sort(productNameTextSort);

        //so sánh 2 list vơi nhau

        return productNameText.equals(productNameTextSort);
    }

    public boolean isNameSortDESC() {
        List<WebElement> productNameElement = getListElement(driver, InventoryPageUI.PRODUCT_NAME);
        //khai báo list string để add product name
        List<String> productNameText = new ArrayList<String>();
        for (WebElement element : productNameElement) {
            productNameText.add(element.getText());
        }

        //new thêm 1 list string nữa để đi sort và so sánh, sao chép toàn bộ productNameText qua list mới
        List<String> productNameTextSort = new ArrayList<String>(productNameText);

        //sort list trên
        Collections.sort(productNameTextSort, Collections.reverseOrder());

        //so sánh 2 list vơi nhau

        return productNameText.equals(productNameTextSort);    }

    public boolean isPriceSortASC() {
        List<WebElement> productPriceElement = getListElement(driver, InventoryPageUI.PRODUCT_PRICE);
        List<Float> productPriceText = new ArrayList<Float>();
        for (WebElement element : productPriceElement) {
            productPriceText.add(Float.valueOf(element.getText().replace("$", "")));
        }

        List<Float> productPriceTextSort = new ArrayList<Float>(productPriceText);

        Collections.sort(productPriceTextSort);

        return productPriceText.equals(productPriceTextSort);
    }

    public boolean isPriceSortDESC() {
        List<WebElement> productPriceElement = getListElement(driver, InventoryPageUI.PRODUCT_PRICE);
        List<Float> productPriceText = new ArrayList<Float>();
        for (WebElement element : productPriceElement) {
            productPriceText.add(Float.valueOf(element.getText().replace("$", "")));
        }

        List<Float> productPriceTextSort = new ArrayList<Float>(productPriceText);

        Collections.sort(productPriceTextSort, Collections.reverseOrder());

        return productPriceText.equals(productPriceTextSort);
    }
}
