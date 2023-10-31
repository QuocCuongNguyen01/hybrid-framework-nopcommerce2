package pageObjects.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.MyAccountSideBarPageUI;
import commons.BaseElement;
import commons.BasePage;
import commons.PageGeneratorManager;

public class MyAccountSideBarPageObject extends BaseElement{
	WebDriver driver;

	public MyAccountSideBarPageObject(WebDriver driver) {
		super(driver);
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
	
	public MyAccountSideBarPageObject openDynamicSideBarPage(String pageName) {
		waitForElementClickable(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getCustomerPage(driver);
		case "Addresses":
			return PageGeneratorManager.getAddressPage(driver);
		case "Orders":
			return PageGeneratorManager.getOrderPage(driver);
		case "Reward points":
			return PageGeneratorManager.getRewardPointPage(driver);
		default:
			new RuntimeException("Sidebar page name incorrect");
			return null;
		}
		
	}
	public void openDynamicSideBarPageByName(String pageName) {
		waitForElementClickable(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
	}
}
