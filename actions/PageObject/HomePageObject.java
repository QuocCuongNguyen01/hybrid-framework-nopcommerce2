package PageObject;

import org.openqa.selenium.WebDriver;

import PageUIs.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public void clickToRegisterLink() {
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		
	}

	public void clickToMyAccountLink() {
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

}
