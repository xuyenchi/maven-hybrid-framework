package pageUIs.jquery;

public class HomePageUI {
    public static final String DYNAMIC_LINK_PAGIN = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String DYNAMIC_TEXBOX_BY_HEADER_NAME = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_DATA_ROW = "xpath=//td[@data-key='females' and text()='%s']/following-sibling::"
        +"td[@data-key='country' and text()='%s']/following-sibling::"
        +"td[@data-key='males' and text()='%s']/following-sibling::"
        +"td[@data-key='total' and text()='%s']";
    public static final String DYNAMIC_DELETE_BUTTON = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td/button[@class='qgrd-remove-row-btn']";
    public static final String DYNAMIC_EDIT_BUTTON = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td/button[@class='qgrd-edit-row-btn']";
    public static final String LOAD_DATA_BUTTON = "id=load";
    public static final String DYNAMIC_PRECEDING_COLUMN = "xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_TEXTBOX_BY_ROWINDEX_COLUMNINDEX = "xpath=//tr[%s]/td[%s]/input";
    public static final String DYNAMIC_SELECT_BY_ROWINDEX_COLUMNINDEX = "xpath=//tr[%s]/td[%s]//select";
    public static final String DYNAMIC_CHECKBOX_BY_ROWINDEX_COLUMNINDEX = "xpath=//tr[%s]/td[%s]//input";
    public static final String DYNAMIC_ICON_BY_ROWINDEX = "xpath=//tr[%s]//button[contains(@title,'%s')]";
    public static final String DYNAMIC_PRECEDING_COLUMN2 ="xpath=//div[text()='%s']/ancestor::th/preceding-sibling::th";
    public static final String ALL_VALUE_COLUMNINDEX = "xpath=//td[%s]";
    public static final String PAGE_TITLE_REGISTER = "xpath=//div[@class='page-title']/h1";


}
