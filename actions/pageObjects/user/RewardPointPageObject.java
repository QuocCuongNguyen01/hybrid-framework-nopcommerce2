package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class RewardPointPageObject extends MyAccountSideBarPageObject{
	WebDriver driver;

	public RewardPointPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
