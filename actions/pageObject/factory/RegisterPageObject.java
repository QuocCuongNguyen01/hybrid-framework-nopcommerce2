package pageObject.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject  extends BasePageFactory{
	WebDriver driver;
	@CacheLookup
	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(id = "FirstName-error")
	private WebElement firstNameErrorMsg;
	
	@FindBy(id = "LastName-error")
	private WebElement lastNameErrorMsg;
	
	@FindBy(id = "Email-error")
	private WebElement emailErrorMsg;
	
	@FindBy(id = "Password-error")
	private WebElement passwordErrorMsg;
	
	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPasswordErrorMsg;
	
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registrationCompleteMsg;
	
	@FindBy(xpath = "//div[@class='header-logo']//img")
	private WebElement nopcommerceLogo;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}
	public String getFirstNameErrorMessageText() {
		waitForElementVisible(driver, firstNameErrorMsg);
		return getElementText(driver, firstNameErrorMsg);
	}
	public String getLastNameErrorMessageText() {
		waitForElementVisible(driver, lastNameErrorMsg);
		return getElementText(driver, lastNameErrorMsg);
	}
	public String getEmailrrorMessageText() {
		waitForElementVisible(driver, emailErrorMsg);
		return getElementText(driver, emailErrorMsg);
	}
	public String getPasswordErrorMessageText() {
		waitForElementVisible(driver, passwordErrorMsg);
		return getElementText(driver, passwordErrorMsg);
	}
	public String getConfirmPasswordErrorMessageText() {
		waitForElementVisible(driver, confirmPasswordErrorMsg);
		return getElementText(driver, confirmPasswordErrorMsg);
	}
	public void clickToNopCommerceLogo() {
		waitForElementClickable(driver, nopcommerceLogo);
		clickToElement(driver, nopcommerceLogo);	
	}
	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
	}
	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
	}
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}
	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}
	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
		
	}
	public String getRegisterSuccessMessageText() {
		waitForElementVisible(driver, registrationCompleteMsg);
		return getElementText(driver, registrationCompleteMsg);
	}

}
