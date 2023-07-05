package pageObject.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject  extends BasePageFactory{
	WebDriver driver;
	@CacheLookup
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[contains(string(),'Log in')]")
	private WebElement loginButton;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}
	public void enterToEmailTextBox(String emailAdress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAdress);
	}
	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, passwordTextBox, password);
	}
	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

}
