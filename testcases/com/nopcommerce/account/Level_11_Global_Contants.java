package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstant;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.AddressPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.OrderPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointPageObject;
import pageObjects.user.UserLoginPageObject;

public class Level_11_Global_Contants extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashBoardPage;
	private CustomerPageObject customerPage;
	private AddressPageObject addressPage;
	private OrderPageObject orderPage;
	private RewardPointPageObject rewardPointPage;
	private String emailAdress = getEmailRandom();
	private String adminUrl = GlobalConstant.DEV_ADMIN_URL;
	private String userUrl = GlobalConstant.DEV_USER_URL;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, userUrl);

		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_User_To_Admin() {
		// homePage = registerPage.clickToNopCommerceLogo();

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("Anh");
		registerPage.enterToLastNameTextbox("Tuan");
		registerPage.enterToEmailTextbox(emailAdress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
		homePage = registerPage.clickToNopCommerceLogo();

		userLoginPage = homePage.clickToLoginLink();

		homePage = userLoginPage.loginToUser(emailAdress, "123456");

		homePage.clickToLogoutLink();

		// Homepage user => login page admin

		homePage.openPageUrl(driver, adminUrl);

		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		adminDashBoardPage = adminLoginPage.loginToAdmin(GlobalConstant.DEV_ADMIN_USERNAME, GlobalConstant.DEV_ADMIN_PASSWORD);

		Assert.assertTrue(adminDashBoardPage.isPageLoadedSuccess(driver));
	}

	@Test
	public void User_02_Admin_To_User() {
		adminLoginPage = adminDashBoardPage.clickToLogoutLink();
		adminLoginPage.openPageUrl(driver, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		userLoginPage = homePage.clickToLoginLink();
		homePage = userLoginPage.loginToUser(emailAdress, "123456");

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