package pageObject.jquery;

import org.openqa.selenium.WebDriver;

import PageUIs.jquery.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage{
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
}
