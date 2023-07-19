package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.AddressPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.OrderPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointPageObject;

public class Level_09_Page_Navigation extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private AddressPageObject addressPage;
	private OrderPageObject orderPage;
	private RewardPointPageObject rewardPointPage;
	private String emailAdress = getEmailRandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage =  PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Register_Success() {
		//homePage = registerPage.clickToNopCommerceLogo();

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("Anh");
		registerPage.enterToLastNameTextbox("Tuan");
		registerPage.enterToEmailTextbox(emailAdress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
	}

	@Test
	public void User_02_Login_Success() {
		homePage = registerPage.clickToNopCommerceLogo();

		loginPage = homePage.clickToLoginLink();

		loginPage.enterToEmailTextBox(emailAdress);

		loginPage.enterToPasswordTextbox("123456");

		homePage = loginPage.clickToLoginButton();

		customerPage = homePage.clickToMyAccountLink();

		Assert.assertEquals(customerPage.getFirstNameTexboxAttributeValue(), "Anh");
		Assert.assertEquals(customerPage.getLastNameTexboxAttributeValue(), "Tuan");
		Assert.assertEquals(customerPage.getEmailTexboxAttributeValue(), emailAdress);
	}

	@Test
	public void User_03_Switch_Page() {
		// Customer Page => Address Page
		addressPage = customerPage.openAddressPage();
		
		// Address Page => Order Page
		orderPage = addressPage.openOrderPage();
		
		// Order Page => Customer info Page
		customerPage = orderPage.openCustomerPage();
		
		// Customer Page => Order Page
		orderPage = customerPage.openOrderPage();
		
		// Order Page => Address Page
		addressPage = orderPage.openAddressPage();
		
		// Address Page => Reward Point Page
		rewardPointPage = addressPage.openRewardPointPage();
		
		// Reward Point Page => Customer Page
		customerPage = rewardPointPage.openCustomerPage();
		

		// Customer Page => Reward Points Page
		rewardPointPage = customerPage.openRewardPointPage();
	}
	public void sleepInsecond(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}