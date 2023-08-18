package pageObject.jquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static RegisterPageObjectPanda getRegisterPageObjectPanda(WebDriver driver) {
		return new RegisterPageObjectPanda(driver);
	}
	public static DashBoardPageObject getDashBoardPageObject(WebDriver driver) {
		return new DashBoardPageObject(driver);
	}
	public static LoginPageAdminObject getLoginAdminPageObject(WebDriver driver) {
		return new LoginPageAdminObject(driver);
	}
	
	public static AdminPageObject getAdminPageObject(WebDriver driver) {
		return new AdminPageObject(driver);
	}
	public static UploadPageObject getUploadPageObject(WebDriver driver) {
		return new UploadPageObject(driver);
	}
}
