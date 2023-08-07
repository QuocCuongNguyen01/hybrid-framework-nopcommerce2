package pageObjects.user;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import PageUIs.user.CustomerPageUI;

public class CustomerPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public CustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public CustomerPageObject(WebDriver driver, long timeout) {
		super(driver);
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
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
