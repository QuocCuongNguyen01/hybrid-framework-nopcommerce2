package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import PageUIs.admin.AdminLoginPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String emailAdress) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXT_BOX);
		senkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXT_BOX, emailAdress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXT_BOX);
		senkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXT_BOX, password);
	}

	public AdminDashboardPageObject clicktoLoginButton() {
		waitForElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);

	}

	public AdminDashboardPageObject loginToAdmin(String emailAdress, String password) {
		enterToEmailTextbox(emailAdress);
		enterToPasswordTextbox(password);
		return clicktoLoginButton();
	}
}
