package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

@Epic("Account")
@Feature("Create Account")
public class Level_19_Allure_Report extends BaseTest {
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
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		firstName = "Anh";
		lastName = "Tuan";
		password = "123456";
	}
@Description("User 01 - Validate Register form")
@Story("register")
@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register_Verify() {
		Assert.assertFalse(homePage.isRegisterLinkDisplayed());

		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToRegisterButton();
		// Verify error message at FirstName Textbox Displayed -> Pass

		Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

		// Verify error message at LastName Textbox Displayed -> Failed
		Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");

	}
@Description("User 02 - Register Account")
@Story("register")
@Severity(SeverityLevel.CRITICAL)
	@Test
	public void User_02_Register_Success() {

		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextbox(firstName);

		registerPage.enterToLastNameTextbox(lastName);

		registerPage.enterToEmailTextbox(emailAdress);

		registerPage.enterToPasswordTextbox(password);

		registerPage.enterToConfirmPasswordTextbox(password);

		// Verify successs message -> Failed

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
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