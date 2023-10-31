package commons;

import org.openqa.selenium.WebDriver;

import PageUIs.user.BaseElementUI;
import PageUIs.user.CustomerPageUI;
import PageUIs.user.HomePageUI;
import PageUIs.user.RegisterPageUI;
import pageObjects.user.HomePageObject;

public class BaseElement extends BasePage{
	WebDriver driver;
	
	public BaseElement(WebDriver driver) {
		this.driver = driver;
	}
	
	// Hàm này theo business là bất kì 1 page nào cũng nhìn thấy để thao tác lên nó được
	public HomePageObject clickToNopCommerceLogo() {
		waitForElementClickable(driver, BaseElementUI.NOP_COMMERCE_LOGO);
		clickToElement(driver, BaseElementUI.NOP_COMMERCE_LOGO);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	// Theo business thì bất kì page nào cũng gọi ra dùng được
	public void clickToHeaderLinkByName(String pageName) {
		waitForElementClickable(driver, BaseElementUI.DYNAMNIC_HEADER_LINK_BY_NAME,pageName);
		clickToElement(driver, BaseElementUI.DYNAMNIC_HEADER_LINK_BY_NAME, pageName);
		
	}
	
	// Thao tác với bất kì 1 button ở page nào
	public void clickToButtonByText(String buttonName) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT,buttonName);
		clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonName);		
	}
	
	// Get ra error message của textbox tại bất kì 1 cái page nào
	public String getTextboxErrorMessageByID(String errorMessageID) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID,errorMessageID);
		return getElementText(driver,  BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID,errorMessageID);
	}
	
	
	// Nhập vào 1 text box bất kì của 1 page bất kì
	public void enterToTextboxByID(String textboxID, String valueToSend) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,textboxID);
		senkeyToElement(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, valueToSend, textboxID);
	}
	
	// Get ra attribute của textbox tại bất kì page nào
	public String getTextboxAttributeByID(String textboxID) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}
}
