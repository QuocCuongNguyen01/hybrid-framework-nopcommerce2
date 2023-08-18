package pageObject.jquery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.jquery.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToColumnTextboxByName(String ColumnName, String valueToSend) {
		waitForElementVisible(driver, HomePageUI.COLUMN_TEXBOX_BY_NAME, ColumnName);
		senkeyToElement(driver, HomePageUI.COLUMN_TEXBOX_BY_NAME, valueToSend, ColumnName);
	}

	public void clickToPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
	}

	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
	}

	public boolean isRowValuesDisplayed(String female, String country, String male, String total) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
		return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
	}

	public void clickToRowActionByCountryName(String country, String rowAction) {
		waitForElementClickable(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
		clickToElement(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
	}

	public List<String> getAllPageValueByColumnName(String ColumnName) {

		List<String> allValues = new ArrayList<String>();

		// ;lấy ra tất cả các page
		List<WebElement> allPageLinks = getListWebElement(driver, HomePageUI.ALL_PAGE_LINKS);

		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, ColumnName) + 1;
		// 2 Duyệt qua từng page
		for (WebElement pageLink : allPageLinks) {
			pageLink.click();
			sleepInsecond(2);
			// Duyệt qua lấy giá trị từng cột trong page đó
			List<WebElement> allRowValues = getListWebElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex));
			for (WebElement rowValue : allRowValues) {
				allValues.add(rowValue.getText());
			}
		}
		return allValues;
	}

	public List<String> getAllPageValueByColumnNameInDB(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getAllPageValueByColumnNameInAPI(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSend) {
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DYNAMIC_TEXBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		senkeyToElement(driver, HomePageUI.DYNAMIC_TEXBOX_BY_ROW_INDEX_AND_COLUMN_INDEX,valueToSend,  rowIndex, String.valueOf(columnIndex));
	}

	public void selectDropDownByColumnNameAndRowIndex(String columnName, String rowIndex, String dropdownItem) {
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX,dropdownItem,  rowIndex, String.valueOf(columnIndex));
	}

	public void clickToCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX,rowIndex, String.valueOf(columnIndex));
		checkToElement(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX,rowIndex, String.valueOf(columnIndex));
	}

	public void clickToAccount() {
		waitForElementClickable(driver, HomePageUI.ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.ACCOUNT_LINK);
		
	}

	public RegisterPageObjectPanda clickToRegisterLink(String value) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_ACCOUNT_LINK_REGISTER, value);
		clickToElement(driver, HomePageUI.DYNAMIC_ACCOUNT_LINK_REGISTER, value);
		return PageGeneratorManager.getRegisterPageObjectPanda(driver);
	}
	
	
}
