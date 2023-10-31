package pageObjects.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.LoginPageUI;
import commons.BaseElement;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserLoginPageObject extends BaseElement {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToEmailTextBox(String emailAdress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAdress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public String getEmailErrorMessageText() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MSG);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MSG);
	}
	public String getEmailLoginErrorMessageText() {
		waitForElementVisible(driver, LoginPageUI.UN_CORRECT_EMAIL_MSG);
		return getElementText(driver, LoginPageUI.UN_CORRECT_EMAIL_MSG);
	}
	

//	public void clickToNopCommerceLogo() {
//		waitForElementClickable(driver, LoginPageUI.NOP_COMMERCE_LOGO);
//		clickToElement(driver, LoginPageUI.NOP_COMMERCE_LOGO);
//		
//	}
	
	public HomePageObject loginToUser(String emailAdress, String password) {
		enterToEmailTextBox(emailAdress);
		enterToPasswordTextbox(password);
		return clickToLoginButton();
	}

}
