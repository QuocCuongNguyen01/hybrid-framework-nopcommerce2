package pageObject.jquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DashBoardPageObject extends BasePage{
	WebDriver driver;

	public DashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageAdminObject openAdminPage() {
		openPageUrl(driver, "http://live.techpanda.org/index.php/backendlogin");
		return PageGeneratorManager.getLoginAdminPageObject(driver);
	}
	
}
