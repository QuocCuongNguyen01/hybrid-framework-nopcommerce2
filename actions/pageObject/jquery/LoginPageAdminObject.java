package pageObject.jquery;

import org.openqa.selenium.WebDriver;

import PageUIs.jquery.LoginAdminPageUI;
import commons.BasePage;

public class LoginPageAdminObject extends BasePage{
	WebDriver driver;

	public LoginPageAdminObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAccount(String valueName, String valueToSend) {
		clickToElement(driver, LoginAdminPageUI.DYNAMIC_ACCOUNT_VALUE_INPUT, valueName);
		senkeyToElement(driver, LoginAdminPageUI.DYNAMIC_ACCOUNT_VALUE_INPUT, valueToSend, valueName);
		
	}

	public AdminPageObject clickToLogin() {
		waitForElementClickable(driver, LoginAdminPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginAdminPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminPageObject(driver);
	}
}
