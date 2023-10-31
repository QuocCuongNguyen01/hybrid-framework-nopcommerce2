package pageObjects.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.RegisterPageUI;
import commons.BaseElement;
import io.qameta.allure.Step;

public class RegisterPageObject extends BaseElement {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Click to Register button")
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.RIGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.RIGISTER_BUTTON);
	}

	public String getFirstNameErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
	}

	public String getLastNameErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
	}

	public String getEmailrrorMessageText() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MSG);
	}

	public String getPasswordErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
	}

	public String getConfirmPasswordErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
	}


	@Step("Enter to First Name textbox with value is {0}")
	public void enterToFirstNameTextbox(String firstNameValue) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstNameValue);
	}

	@Step("Enter to Last Name textbox with value is {0}")
	public void enterToLastNameTextbox(String lastNameValue) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastNameValue);
	}

	@Step("Enter to  Email textbox with value is {0}")
	public void enterToEmailTextbox(String emailAddressValue) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddressValue);
	}

	@Step("Enter to Password textbox with value is {0}")
	public void enterToPasswordTextbox(String passwordValue) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, passwordValue);
	}
	@Step("Enter to Confirm Password textbox with value is {0}")
	public void enterToConfirmPasswordTextbox(String passwordValue) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, passwordValue);
	}
	@Step("Verify Register sucessMessage is displayed")
	public String getRegisterSuccessMessageText() {
		waitForElementVisible(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
		return getElementText(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
	}

}
