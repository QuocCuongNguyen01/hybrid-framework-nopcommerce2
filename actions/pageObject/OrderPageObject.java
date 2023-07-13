package pageObject;

import org.openqa.selenium.WebDriver;

import PageUIs.OrderPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class OrderPageObject extends BasePage{
	WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	
}
