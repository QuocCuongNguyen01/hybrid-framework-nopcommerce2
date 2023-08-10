package com.jquery.table;

import java.util.ArrayList;
import java.util.List;

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
	List<String> allValueUI = new ArrayList<String>();
	List<String> allValueDB = new ArrayList<String>();
	List<String> allValueAPI = new ArrayList<String>();
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		homePage = PageGeneratorManager.getHomePageObject(driver); 

	}
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

	
	public void TC_03_Displayed() {
		homePage.refreshToPage(driver);

		//verify for any row
		Assert.assertTrue(homePage.isRowValuesDisplayed("384187", "Afghanistan", "407124", "791312"));
		Assert.assertTrue(homePage.isRowValuesDisplayed("12253515", "AFRICA", "12599691", "24853148"));
		Assert.assertTrue(homePage.isRowValuesDisplayed("777", "Antigua and Barbuda", "803", "1580"));
		homePage.refreshToPage(driver);
	}


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

	public void TC_05_Get_All_Column_Values() {
		// B1: LẤy ra tất cả các page
		// B2: Duyệt qua từng Page
		// B3: Lấy ra tất cả các giá trị của 1 cột trong cái page đó -> lưu vào list/Set/...
		// B4: Duyệt hết các page còn lại
		
		allValueUI = homePage.getAllPageValueByColumnName("Country");
		
		allValueDB = homePage.getAllPageValueByColumnNameInDB("Country");
		
		allValueDB = homePage.getAllPageValueByColumnNameInAPI("Country");
		homePage.getAllPageValueByColumnName("Total");

	}
	@Test
	public void TC_06_Action_By_Index() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		// Nhập vào textbox tại cột Contact Person dòng thứ 2
		homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person", "2", "Anh Phan");
		homePage.enterToTextboxByColumnNameAndRowIndex("Company", "2", "Anh Phan");
		homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person", "2", "Anh Phan");
		
		
		// Select Dữ liệu tại cột Country dòng thứ 3
		homePage.selectDropDownByColumnNameAndRowIndex("Country", "3", "Germany");
		homePage.selectDropDownByColumnNameAndRowIndex("Country", "2", "Hong Kong");
		
		
		// Click vào checkbox tại cột NPO? dòng thứ nhất
		
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "2");
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "1");
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "3");
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}