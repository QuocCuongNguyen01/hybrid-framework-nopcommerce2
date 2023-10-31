package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.RegisterPageObject;

public class Level_21_Pattern_Object extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private String emailAdress = getEmailRandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage =  PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Register_Empty_Data() {
		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.clickToButtonByText("Register");
		
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("FirstName"),"First name is required."); 
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("LastName"),"Last name is required."); 
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"),"Email is required."); 
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Password"),"Password is required."); 
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"),"Password is required."); 
	}

	@Test
	public void User_02_Register_Invalid_Email() {
		registerPage.clickToNopCommerceLogo();

		homePage = new HomePageObject(driver);

		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		
		registerPage.enterToTextboxByID("FirstName","Anh");
		registerPage.enterToTextboxByID("LastName","Tuan");
		registerPage.enterToTextboxByID("Email","join");
		registerPage.enterToTextboxByID("Password","123456");
		registerPage.enterToTextboxByID("ConfirmPassword","123456");

		registerPage.clickToButtonByText("Register");
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"),"Wrong email"); 


	}

	@Test
	public void User_03_Register_Invalid_Passsword() {
		homePage = registerPage.clickToNopCommerceLogo();

		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.enterToTextboxByID("FirstName","Anh");
		registerPage.enterToTextboxByID("LastName","Tuan");
		registerPage.enterToTextboxByID("Email","join@gmail.com");
		registerPage.enterToTextboxByID("Password","12456");
		registerPage.enterToTextboxByID("ConfirmPassword","12456");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Password"),"Password must meet the following rules:\nmust have at least 6 characters"); 


	}

	@Test
	public void User_04_Register_Incorrect_Confirm_Password() {
		homePage = registerPage.clickToNopCommerceLogo();

		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.enterToTextboxByID("FirstName","Anh");
		registerPage.enterToTextboxByID("LastName","Tuan");
		registerPage.enterToTextboxByID("Email",emailAdress);
		registerPage.enterToTextboxByID("Password","123456");
		registerPage.enterToTextboxByID("ConfirmPassword","12456");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"), "The password and confirmation password do not match.");


	}

	@Test
	public void User_05_Register_Success() {
		homePage = registerPage.clickToNopCommerceLogo();

		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.enterToTextboxByID("FirstName","Anh");
		registerPage.enterToTextboxByID("LastName","Tuan");
		registerPage.enterToTextboxByID("Email",emailAdress);
		registerPage.enterToTextboxByID("Password","123456");
		registerPage.enterToTextboxByID("ConfirmPassword","123456");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
	}

	@Test
	public void User_06_Login_Success() {
		homePage = registerPage.clickToNopCommerceLogo();

		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getUserLoginPage(driver);

		
		loginPage.enterToTextboxByID("Email", emailAdress);
		loginPage.enterToTextboxByID("Password", "123456");

		loginPage.clickToButtonByText("Log in");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		homePage.clickToHeaderLinkByName("My account");
		customerPage = PageGeneratorManager.getCustomerPage(driver);

		Assert.assertEquals(customerPage.getTextboxAttributeByID("FirstName"), "Anh");
		Assert.assertEquals(customerPage.getTextboxAttributeByID("LastName"), "Tuan");
		Assert.assertEquals(customerPage.getTextboxAttributeByID("Email"), emailAdress);
		
		
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