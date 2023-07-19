package pageObjects.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.BasePageUI;
import PageUIs.user.MyAccountSideBarPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;
import pageObjects.user.AddressPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.OrderPageObject;
import pageObjects.user.RewardPointPageObject;

public class MyAccountSideBarPageObject extends BasePage{
	WebDriver driver;

	public MyAccountSideBarPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public AddressPageObject openAddressPage() {
		waitForElementVisible(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
		clickToElement(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
		return PageGeneratorManager.getAddressPage(driver);
	}

	public OrderPageObject openOrderPage() {
		waitForElementVisible(driver, MyAccountSideBarPageUI.ORDER_LINK_TEXT);
		clickToElement(driver, MyAccountSideBarPageUI.ORDER_LINK_TEXT);
		return PageGeneratorManager.getOrderPage(driver);
	}

	public RewardPointPageObject openRewardPointPage() {
		waitForElementVisible(driver, MyAccountSideBarPageUI.REWARD_POINT_LINK_TEXT);
		clickToElement(driver, MyAccountSideBarPageUI.REWARD_POINT_LINK_TEXT);
		return PageGeneratorManager.getRewardPointPage(driver);

	}
	
	public CustomerPageObject openCustomerPage() {
		waitForElementVisible(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_LINK_TEXT);
		clickToElement(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_LINK_TEXT);
		return PageGeneratorManager.getCustomerPage(driver);
		
	}
}
