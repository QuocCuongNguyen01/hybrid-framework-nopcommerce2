package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import PageUIs.admin.AdminDashboardPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class AdminDashboardPageObject extends BasePage{
	 WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminLoginPageObject clickToLogoutLink() {
		waitForElementVisible(driver, AdminDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, AdminDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
}
