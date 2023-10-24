package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import PageUIs.facebook.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		//waitForElementClickable(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isFirstNameTextboxDisplayed() {
	//	waitForElementVisible(driver, HomePageUI.FIRSTNAME_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.FIRSTNAME_TEXTBOX);
	}

	public boolean isSurNameTextboxDisplayed() {
	//	waitForElementVisible(driver, HomePageUI.LASTNAME_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.LASTNAME_TEXTBOX);
	}

	public boolean isEmailTextboxDisplayed() {
	//	waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.EMAIL_TEXTBOX);
	}

	public boolean isPasswordTextboxDisplayed() {
		//waitForElementVisible(driver, HomePageUI.PASSWORD_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.PASSWORD_TEXTBOX);
	}

	public void enterToEmailTextbox(String valueToSend) {
	//	waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, HomePageUI.EMAIL_TEXTBOX, valueToSend);
	}

	public boolean isConfirmEmailTextboxDisplayed() {
		//waitForElementVisible(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void clickToCloseSignUpPopup() {
		waitForElementClickable(driver, HomePageUI.CLOSE_POPUP_BUTTON);
		clickToElement(driver, HomePageUI.CLOSE_POPUP_BUTTON);
		sleepInsecond(3);
		
	}

	public boolean isFirstNameTextboxUndisplayed() {
		return isElementUndisplayed(driver,  HomePageUI.FIRSTNAME_TEXTBOX);
	}

	public boolean isSurNameTextboxUndisplayed() {
		return isElementUndisplayed(driver,  HomePageUI.LASTNAME_TEXTBOX);		
	}

	public boolean isEmailTextboxUndisplayed() {
		return isElementUndisplayed(driver,  HomePageUI.EMAIL_TEXTBOX);
	}

	public boolean isPasswordTextboxUndisplayed() {
		return isElementUndisplayed(driver,  HomePageUI.PASSWORD_TEXTBOX);
	}

	public boolean isConfirmEmailTextboxUndisplayed() {
		return isElementUndisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
	}
}
