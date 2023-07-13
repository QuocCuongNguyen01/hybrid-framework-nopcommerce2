package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.AddressPageObject;
import pageObject.CustomerPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.OrderPageObject;
import pageObject.RegisterPageObject;
import pageObject.RewardPointPageObject;

public class Level_08_Switch_Page extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
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
		addressPage = customerPage.openAddressPage(driver);
		
		// Address Page => Order Page
		orderPage = addressPage.openOrderPage(driver);
		
		// Order Page => Customer info Page
		customerPage = orderPage.openCustomerPage(driver);
		
		// Customer Page => Order Page
		orderPage = customerPage.openOrderPage(driver);
		
		// Order Page => Address Page
		addressPage = orderPage.openAddressPage(driver);
		
		// Address Page => Reward Point Page
		rewardPointPage = addressPage.openRewardPointPage(driver);
		
		// Reward Point Page => Customer Page
		customerPage = rewardPointPage.openCustomerPage(driver);
		

		// Customer Page => Reward Points Page
		rewardPointPage = customerPage.openRewardPointPage(driver);
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