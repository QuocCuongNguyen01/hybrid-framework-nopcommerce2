package com.jquery.table;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jquery.AdminPageObject;
import pageObject.jquery.DashBoardPageObject;
import pageObject.jquery.HomePageObject;
import pageObject.jquery.LoginPageAdminObject;
import pageObject.jquery.PageGeneratorManager;
import pageObject.jquery.RegisterPageObjectPanda;


public class Level_13_Home_Work extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObjectPanda registerPage;
	DashBoardPageObject dashBoardPage;
	LoginPageAdminObject loginAdminPage;
	AdminPageObject adminPage;
	private String emailAdress = getEmailRandom();

	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		homePage = PageGeneratorManager.getHomePageObject(driver); 

	}
	@Test
	public void TC_01_Register_Account() {
		homePage.openPageUrl(driver, "http://live.techpanda.org/");
		
		homePage.clickToAccount();
		
		registerPage = homePage.clickToRegisterLink("Register");
		
		registerPage.enterToTextBox("firstname", "Cuong");
		registerPage.enterToTextBox("lastname", "Nguyen");
		registerPage.enterToTextBox("email_address", emailAdress);
		registerPage.enterToTextBox("password", "123456");
		registerPage.enterToTextBox("confirmation", "123456");
		dashBoardPage = registerPage.clickToRegisterButton();
		Assert.assertEquals(dashBoardPage.getCurrentPageUrl(driver), "http://live.techpanda.org/index.php/customer/account/index/");

	
	}
	@Test
	public void TC_02_Confirm_Account_On_Admin_Page() {
		loginAdminPage= dashBoardPage.openAdminPage();
		
		loginAdminPage.enterToAccount("username","user01");
		loginAdminPage.enterToAccount("login","guru99com");
		adminPage= loginAdminPage.clickToLogin();
		
		adminPage.clickToClosePopup();
		
		adminPage.enterEmailToSearch(emailAdress);
		adminPage.clickToSearchEmail();
		Assert.assertEquals(adminPage.isRowvaluesDisplayed("3") ,"Cuong Nguyen");
		Assert.assertEquals(adminPage.isRowvaluesDisplayed("4"), emailAdress);
	
	}
	public String getEmailRandom() {
		Random rand = new Random();
		return "join" + rand.nextInt(99999) + "@gmail.com";
	}
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}