package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

public class Level_15_Assert_Verify extends BaseTest {
	WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String emailAdress = getEmailRandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Register_Success() {
		// homePage = registerPage.clickToNopCommerceLogo();
		// Verify Register link Displayed -> Failed
		verifyFalse(homePage.isRegisterLinkDisplayed());

		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToRegisterButton();
		// Verify error message at FirstName Textbox Displayed -> Pass

		verifyEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
		
		// Verify error message at LastName Textbox Displayed -> Failed
		
		verifyEquals(registerPage.getLastNameErrorMessageText(), "Last name is required");

		registerPage.enterToFirstNameTextbox("Anh");
		registerPage.enterToLastNameTextbox("Tuan");
		registerPage.enterToEmailTextbox(emailAdress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		// Verify successs message -> Failed
		
		registerPage.clickToRegisterButton();

		verifyEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed.");
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