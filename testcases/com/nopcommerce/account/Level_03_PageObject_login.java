
package com.nopcommerce.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObject.CustomerPageObject;
import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import PageObject.RegisterPageObject;
import commons.BasePage;

public class Level_03_PageObject_login extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private String emailAdress = getEmailRandom();

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		// Mở 1 URL ra nó page nào -> khởi tạo page đó lên
		// Từ 1 page này chuyển qua page kia -> khởi tạo page đó lên
		homePage = new HomePageObject(driver);
	}

	@Test
	public void User_00_Register_Success() {

		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextbox("Anh");
		registerPage.enterToLastNameTextbox("Tuan");
		registerPage.enterToEmailTextbox(emailAdress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
	}

	@Test
	public void User_01_Login_Empty_data() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailErrorMessageText(), "Please enter your email");

	}

	@Test
	public void User_02_Login_Invalid_Email() {
		loginPage.clickToNopCommerceLogo();

		homePage = new HomePageObject(driver);

		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.enterToEmailTextBox("áđâsđá");

		loginPage.enterToPasswordTextbox("123456");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailErrorMessageText(), "Wrong email");

	}

	@Test
	public void User_03_unregistered_email() {
		loginPage.clickToNopCommerceLogo();

		homePage = new HomePageObject(driver);

		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.enterToEmailTextBox("cuong133@gmail.com");

		loginPage.enterToPasswordTextbox("123456");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailLoginErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}
	@Test
	public void User_04_Empty_Password() {
		loginPage.clickToNopCommerceLogo();

		homePage = new HomePageObject(driver);

		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.enterToEmailTextBox(emailAdress);

		loginPage.enterToPasswordTextbox("");

		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getEmailLoginErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	@Test
	public void User_05_Wrong_Password() {
		loginPage.clickToNopCommerceLogo();
		
		homePage = new HomePageObject(driver);
		
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
				
		loginPage.enterToEmailTextBox(emailAdress);
		
		loginPage.enterToPasswordTextbox("123644");
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getEmailLoginErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void User_06_Login_In_Registed_Email() {
		homePage.clickToLoginLink();
		
		homePage = new HomePageObject(driver);
		
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);

		loginPage.enterToEmailTextBox(emailAdress);

		loginPage.enterToPasswordTextbox("123456");

		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getCurrentPageUrl(driver), "https://demo.nopcommerce.com/");

	}

	public String getEmailRandom() {
		Random rand = new Random();
		return "join" + rand.nextInt(99999) + "@gmail.com";
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}