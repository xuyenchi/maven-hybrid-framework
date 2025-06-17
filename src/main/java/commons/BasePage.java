package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nopcomerce.PageGenerator;
import pageObjects.nopcomerce.user.UserAddressBookPO;
import pageObjects.nopcomerce.user.UserMyAccountPO;
import pageObjects.nopcomerce.user.UserOrderPO;
import pageUIs.user.BasePageUI;
import pageUIs.user.UserRegisterPageUI;
import pageUIs.user.UserSidebarPageUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    public static BasePage getBasePage() {
        return new BasePage();
    }

    public void openPageURL(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitAlertPresent(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitAlertPresent(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitAlertPresent(driver).dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return waitAlertPresent(driver).getText();
    }

    public void senkeyAlert(WebDriver driver, String key) {
        waitAlertPresent(driver).sendKeys(key);
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }
    //css
    private String castParameter(String locator, String... resParameter){
        return String.format(locator, (Object[]) resParameter);
    }
    public By getByLocator(String prefixLocator){
        By by = null;
        if(prefixLocator.startsWith("css") || prefixLocator.startsWith("CSS") || prefixLocator.startsWith("Css")){
            by = By.cssSelector(prefixLocator.substring(4));
        }else if(prefixLocator.startsWith("ID") || prefixLocator.startsWith("id") || prefixLocator.startsWith("Id")){
            by = By.id(prefixLocator.substring(3));
        }
        else if(prefixLocator.startsWith("Class") || prefixLocator.startsWith("class") || prefixLocator.startsWith("CLASS")){
            by = By.className(prefixLocator.substring(6));
        }else if(prefixLocator.startsWith("tagname") || prefixLocator.startsWith("Tagname") || prefixLocator.startsWith("TAGNAME")){
            by = By.tagName(prefixLocator.substring(8));
        }else if(prefixLocator.startsWith("LinkText") || prefixLocator.startsWith("linktext") || prefixLocator.startsWith("LINKTEXT")){
            by = By.linkText(prefixLocator.substring(9));
        }else if(prefixLocator.startsWith("partialLinkText") || prefixLocator.startsWith("PartialLinkText") || prefixLocator.startsWith("PARTIALLINKTEXT")){
            by = By.partialLinkText(prefixLocator.substring(16));
        }else if(prefixLocator.startsWith("name") || prefixLocator.startsWith("Name") || prefixLocator.startsWith("NAME")){
            by = By.name(prefixLocator.substring(5));
        }else if(prefixLocator.startsWith("xpath") || prefixLocator.startsWith("Xpath") || prefixLocator.startsWith("Xpath")){
            by = By.xpath(prefixLocator.substring(6));
        }else {
            throw new RuntimeException("Locator type is not support");
        }
        return by;
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator, String... restParameter) {
        return driver.findElements(getByLocator(castParameter(locator, restParameter)));
    }

    public By getByXpath(String locator) {

        return By.xpath(locator);
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParameter) {
        getElement(driver, castParameter(locator, restParameter)).click();
    }

    public void senkeyToElement(WebDriver driver, String locator, String key) {
        clearInput(driver, locator);
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(key);
    }

    public void senkeyToElement(WebDriver driver, String locator, String key, String... restParameter) {
        getElement(driver, castParameter(locator, restParameter)).clear();
        getElement(driver, castParameter(locator, restParameter)).sendKeys(key);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String item ) {
        new Select(getElement(driver, locator)).selectByVisibleText(item);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String item, String... restParameter ) {
        new Select(getElement(driver, castParameter(locator, restParameter))).selectByVisibleText(item);
    }

    public String getSelectedItemInDropdown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) throws InterruptedException {
        getElement(driver, parentLocator).click();
        sleepInSeconds(2);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem))
                item.click();
            break;
        }
    }

    public void sleepInSeconds(long timeSeconds) throws InterruptedException {
        Thread.sleep(timeSeconds * 1000);
    }

    public String getElementAtribute(WebDriver driver, String locator, String atributeName) {
        return getElement(driver, locator).getAttribute(atributeName);
    }

    public String getElementAtribute(WebDriver driver, String locator, String atributeName, String resParameter) {
        return getElement(driver, castParameter(locator, resParameter)).getDomAttribute(atributeName);
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator,String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).getText();
    }

    public String getElementCSSValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getListElementSize(WebDriver driver, String locator) {
        return getListElement(driver, locator).size();
    }

    public void checkToCheckboxRadio(WebDriver driver, String locator) {
        if (!getElement(driver, locator).isSelected()) {
            clickToElement(driver, locator);
        }
    }

    public void checkToCheckboxRadio(WebDriver driver, String locator, String... restParameter) {
        if (!getElement(driver, castParameter(locator, restParameter)).isSelected()) {
            clickToElement(driver, castParameter(locator, restParameter));
        }
    }

    public void uncheckToCheckbox(WebDriver driver, String locator) {
        if (getElement(driver, locator).isSelected()) {
            clickToElement(driver, locator);
        }
    }

    public void uncheckToCheckbox(WebDriver driver, String locator, String... restParameter) {
        if (getElement(driver, castParameter(locator, restParameter)).isSelected()) {
            clickToElement(driver, castParameter(locator, restParameter));
        }
    }

    public boolean isElementDisplay(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();

    }
    public boolean isElementDisplay(WebDriver driver, String locator,String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).isDisplayed();

    }
    public void overideGlobalTimeout(WebDriver driver, long timeInSecond){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSecond));
    }
    public boolean isElementUnDisplayed(WebDriver driver, String locator, String... restParameter){
        overideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = getListElement(driver, castParameter(locator, restParameter));
        overideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
        if(elements.size() == 0){
            return true;
        }else if (elements.size() > 0 && !elements.get(0).isDisplayed()){ //element present not display
            return true;
        }else { //element visible
            return false;
        }


    }

    public boolean isElemenSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }
    public boolean isElemenSelected(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver, castParameter(locator,restParameter)).isSelected();
    }

    public boolean isElemenEnable(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public void switchToIframe(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    public void switchToDefaultPage(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }

    public void clickAndHoldElement(WebDriver driver, String locator) {
        new Actions(driver).clickAndHold(getElement(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getElement(driver, locator), key).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... restParameter) {
        new Actions(driver).sendKeys(getElement(driver, castParameter(locator, restParameter)), key).perform();
    }

    public void scrollToElement(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }

    public void hightlightElement(WebDriver driver, String locator) throws InterruptedException {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSeconds(3);
    }

    public void clickToElementByJS(WebDriver driver, String locator, String... restParameter) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, castParameter(locator, restParameter)));
        sleepInSeconds(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locator));
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementPresent(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public boolean waitForListElementInvisible(WebDriver driver, String locator){
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, locator)));

    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String resParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(castParameter(locator, resParameter))));
    }

    public void waitForElementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }
    public void waitForElementSelected(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(castParameter(locator,restParameter))));
    }

    public UserOrderPO openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarPageUI.ORDER_LINK);
        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }

    public UserAddressBookPO openAdressPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarPageUI.ADDRESS_BOOK_LINK);
        clickToElement(driver, UserSidebarPageUI.ADDRESS_BOOK_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }

    public UserMyAccountPO openMyAccountPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarPageUI.MYACCOUNT_LINK);
        clickToElement(driver, UserSidebarPageUI.MYACCOUNT_LINK);
        return PageGenerator.getUserMyAccountPage(driver);
    }

    public void clearInput(WebDriver driver, String locator){
        getElement(driver,locator).clear();
    }

    public void uploadMultipleFiles(WebDriver driver, String... fileNames){
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        for(String file : fileNames){
            fullFileName = fullFileName + filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);

    }

    public void enterTextboxByID(WebDriver driver, String textboxID, String value) {
        senkeyToElement(driver, UserRegisterPageUI.TEXTBOX_BY_ID, value, textboxID);
    }

    public void clickToButtonByText(WebDriver driver, String buttonText) {
        waitForElementClickable(driver, UserRegisterPageUI.BUTTON_BY_TEXT, buttonText);
        clickToElement(driver, UserRegisterPageUI.BUTTON_BY_TEXT, buttonText);
    }

    public boolean waitAllIconLoadingInvisiblae(WebDriver driver) {
        return waitForListElementInvisible(driver, BasePageUI.ICON_LOADING);
    }

    public Dimension getElementSize(WebDriver driver, String locator){
        return getElement(driver, locator).getSize();
    }
    public boolean isSuccessMessageDisplayed(WebDriver driver) {
        waitForElementVisible(driver, BasePageUI.SUCCESS_MESSAGE);
        return isElementDisplay(driver, BasePageUI.SUCCESS_MESSAGE);
    }

    public void clearAttributeValue(WebDriver driver, String locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].value = '';" +
                        "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
                getElement(driver, locator)
        );
    }

}
