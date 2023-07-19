package pageObjects.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.OrderPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class OrderPageObject extends MyAccountSideBarPageObject{
	WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		super(driver);

		this.driver = driver;
	}

	
}
