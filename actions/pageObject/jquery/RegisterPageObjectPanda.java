package pageObject.jquery;

import org.openqa.selenium.WebDriver;

import PageUIs.jquery.RegisterPageUI;
import commons.BasePage;

public class RegisterPageObjectPanda extends BasePage{
	WebDriver driver;

	public RegisterPageObjectPanda(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToTextBox(String texboxName, String valueToSend) {
		waitForElementVisible(driver, RegisterPageUI.DYNAMIC_TEXTBOX_INPUT, texboxName);
		senkeyToElement(driver, RegisterPageUI.DYNAMIC_TEXTBOX_INPUT, valueToSend, texboxName);	
	}

	public DashBoardPageObject clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getDashBoardPageObject(driver);
	}
	
}
