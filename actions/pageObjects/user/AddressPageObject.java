package pageObjects.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.CustomerPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class AddressPageObject extends MyAccountSideBarPageObject{
	WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		super(driver);

		this.driver = driver;
	}

	

}
