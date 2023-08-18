package pageObject.jquery;

import org.openqa.selenium.WebDriver;

import PageUIs.jquery.AdminPageUI;
import commons.BasePage;

public class AdminPageObject extends BasePage{
	WebDriver driver;

	public AdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToClosePopup() {
		waitForElementClickable(driver, AdminPageUI.CLOSE_BUTTON);
		clickToElement(driver, AdminPageUI.CLOSE_BUTTON);
	}

	public void enterEmailToSearch(String valueToSend) {
		waitForElementVisible(driver, AdminPageUI.ENTER_EMAIL_TEXTBOX);
		senkeyToElement(driver, AdminPageUI.ENTER_EMAIL_TEXTBOX, valueToSend);
		
	}

	public void clickToSearchEmail() {
		waitForElementClickable(driver, AdminPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminPageUI.SEARCH_BUTTON);
	}

	public String isRowvaluesDisplayed(String columnToGet) {
		 waitForElementClickable(driver, AdminPageUI.GET_VALUES, columnToGet);
		return getElementText(driver, AdminPageUI.GET_VALUES, columnToGet);
		
	}
	
}
