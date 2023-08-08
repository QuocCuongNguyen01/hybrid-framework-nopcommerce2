package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jquery.HomePageObject;
import pageObject.jquery.PageGeneratorManager;


public class Level_13_Handel_DataTable extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		homePage = PageGeneratorManager.getHomePageObject(driver); 

	}
	@Test
	public void TC_01_Search() {
		homePage.inputToColumnTextboxByName("Females", "283821");
		homePage.sleepInsecond(2);
		homePage.inputToColumnTextboxByName("Country", "Angola");
		homePage.sleepInsecond(2);
		homePage.inputToColumnTextboxByName("Males", "1205");
		homePage.sleepInsecond(2);
		homePage.inputToColumnTextboxByName("Total", "1900");
		homePage.sleepInsecond(2);

	}

	@Test
	public void TC_02_Paging() {
		//Click to any page
		homePage.clickToPageNumber("9");
		homePage.sleepInsecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("9"));
		homePage.clickToPageNumber("2");
		homePage.sleepInsecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("2"));
		homePage.clickToPageNumber("19");
		homePage.sleepInsecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("19"));
	}

	@Test
	public void TC_03_Displayed() {
		homePage.refreshToPage(driver);

		//verify for any row
		Assert.assertTrue(homePage.isRowValuesDisplayed("384187", "Afghanistan", "407124", "791312"));
		Assert.assertTrue(homePage.isRowValuesDisplayed("12253515", "AFRICA", "12599691", "24853148"));
		Assert.assertTrue(homePage.isRowValuesDisplayed("777", "Antigua and Barbuda", "803", "1580"));
		homePage.refreshToPage(driver);
	}

	@Test
	public void TC_04_Icon_Button_Checkbox() {
		//Click vào bất kì 1 cái icon/button/checkbox/... của 1 row nào đó
		//Tìm được 1 key là duy nhất của row đó so với các row khác
		
		homePage.clickToRowActionByCountryName("Afghanistan", "remove");
		homePage.clickToRowActionByCountryName("AFRICA", "remove");
		homePage.clickToRowActionByCountryName("Albania", "remove");
		homePage.clickToRowActionByCountryName("Algeria", "remove");
		homePage.refreshToPage(driver);
		homePage.clickToRowActionByCountryName("Afghanistan", "edit");
		homePage.refreshToPage(driver);

		homePage.clickToRowActionByCountryName("AFRICA", "edit");
		homePage.refreshToPage(driver);

		homePage.clickToRowActionByCountryName("Albania", "edit");
		homePage.refreshToPage(driver);

		homePage.clickToRowActionByCountryName("Algeria", "edit");
		homePage.refreshToPage(driver);

		
	}

	@Test
	public void TC_05() {

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}