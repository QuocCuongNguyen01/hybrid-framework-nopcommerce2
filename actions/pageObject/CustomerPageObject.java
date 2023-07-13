package pageObject;

import org.openqa.selenium.WebDriver;

import PageUIs.CustomerPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class CustomerPageObject extends BasePage {
	WebDriver driver;

	public CustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstNameTexboxAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.FISTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.FISTNAME_TEXTBOX, "value");
	}

	public String getLastNameTexboxAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmailTexboxAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");
	}

	

}
