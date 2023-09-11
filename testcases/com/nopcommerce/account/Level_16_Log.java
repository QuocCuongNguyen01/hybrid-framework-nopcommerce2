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

public class Level_16_Log extends BaseTest {
	WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String emailAdress = getEmailRandom();
	private String firstName, lastName, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		firstName = "Anh";
		lastName = "Tuan";
		password = "123456";
	}

	@Test
	public void User_01_Register_Verify() {
		// homePage = registerPage.clickToNopCommerceLogo();
		// Verify Register link Displayed -> Failed
		log.info("User 01  - Step 01: Verify Register Link is Displayed");
		verifyFalse(homePage.isRegisterLinkDisplayed());

		log.info("User 01  - Step 02: Click to register link");
		registerPage = homePage.clickToRegisterLink();

		log.info("User 01  - Step 03: lick to register button");
		registerPage.clickToRegisterButton();
		// Verify error message at FirstName Textbox Displayed -> Pass
		
		log.info("User 01  - Step 04: Verify error message at firstname textbox");
		verifyEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
		
		// Verify error message at LastName Textbox Displayed -> Failed
		log.info("User 01  - Step 05: Verify error message at LastName textbox");
		verifyEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
		
	}
	@Test
	public void User_02_Register_Success() {
	log.info("User 01  - Step 06: Enter to FirstName textbox"+ firstName);
	registerPage.refreshToPage(driver);
	registerPage.enterToFirstNameTextbox(firstName);
	
	log.info("User 01  - Step 07: Enter to LastName textbox"+ lastName);
	registerPage.enterToLastNameTextbox(lastName);
	
	log.info("User 01  - Step 08: Enter to Email textbox"+ emailAdress);
	registerPage.enterToEmailTextbox(emailAdress);
	
	log.info("User 01  - Step 09: Enter to Password textbox"+password);
	registerPage.enterToPasswordTextbox(password);
	
	log.info("User 01  - Step 10: Enter to Confirm Password textbox"+password);
	registerPage.enterToConfirmPasswordTextbox(password);

	// Verify successs message -> Failed
	
	log.info("User 01  - Step 11:Click to register button");
	registerPage.clickToRegisterButton();

	log.info("User 01  - Step 12: Verify messsage registration completed");
	verifyEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
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