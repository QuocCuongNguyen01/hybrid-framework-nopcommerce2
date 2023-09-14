//package com.nopcommerce.account;
//
//import java.lang.reflect.Method;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import pageObjects.user.HomePageObject;
//import pageObjects.user.RegisterPageObject;
//import reportConfig.ExtentManager;
//
//public class Level_18_Extent_Report extends BaseTest {
//	WebDriver driver;
//	private HomePageObject homePage;
//	private RegisterPageObject registerPage;
//	private String emailAdress = getEmailRandom();
//	private String firstName, lastName, password;
//
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		driver = getBrowserDriver(browserName);
//		homePage = PageGeneratorManager.getHomePage(driver);
//		registerPage = PageGeneratorManager.getRegisterPage(driver);
//		firstName = "Anh";
//		lastName = "Tuan";
//		password = "123456";
//	}
//
//	@Test
//	public void User_01_Register_Verify(Method method) {
//		ExtentManager.startTest(method.getName(), "User_01_Register_Verify");
//		// homePage = registerPage.clickToNopCommerceLogo();
//		// Verify Register link Displayed -> Failed
//		ExtentManager.getTest().log(LogStatus.INFO, "User 01  - Step 01: Verify Register Link is Displayed");
//		Assert.assertFalse(homePage.isRegisterLinkDisplayed());
//
//		ExtentManager.getTest().log(LogStatus.INFO, "User 01  - Step 02: Click to register link");
//		registerPage = homePage.clickToRegisterLink();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "User 01  - Step 03: lick to register button");
//		registerPage.clickToRegisterButton();
//		// Verify error message at FirstName Textbox Displayed -> Pass
//
//		ExtentManager.getTest().log(LogStatus.INFO, "User 01  - Step 04: Verify error message at firstname textbox");
//		Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
//
//		// Verify error message at LastName Textbox Displayed -> Failed
//		ExtentManager.getTest().log(LogStatus.INFO, "User 01  - Step 05: Verify error message at LastName textbox");
//		Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
//
//	}
//
//	@Test
//	public void User_02_Register_Success(Method method) {
//		ExtentManager.startTest(method.getName(), "User_02_Register_Success");
//
//		ExtentManager.getTest().log(LogStatus.INFO, "User 01  - Step 06: Enter to FirstName textbox" + firstName);
//		registerPage.refreshToPage(driver);
//		registerPage.enterToFirstNameTextbox(firstName);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "User 01  - Step 07: Enter to LastName textbox" + lastName);
//		registerPage.enterToLastNameTextbox(lastName);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "User 01  - Step 08: Enter to Email textbox" + emailAdress);
//		registerPage.enterToEmailTextbox(emailAdress);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "User 01  - Step 09: Enter to Password textbox" + password);
//		registerPage.enterToPasswordTextbox(password);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "User 01  - Step 10: Enter to Confirm Password textbox" + password);
//		registerPage.enterToConfirmPasswordTextbox(password);
//
//		// Verify successs message -> Failed
//
//		ExtentManager.getTest().log(LogStatus.INFO, "User 01  - Step 11:Click to register button");
//		registerPage.clickToRegisterButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "User 01  - Step 12: Verify messsage registration completed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed.");
//	}
//
//	public void sleepInsecond(long timeInsecond) {
//		try {
//			Thread.sleep(timeInsecond * 1000);
//		} catch (InterruptedException e) {
//
//			e.printStackTrace();
//		}
//	}
//
//	@AfterClass
//	public void afterClass() {
//		closeBrowser();
//	}
//}