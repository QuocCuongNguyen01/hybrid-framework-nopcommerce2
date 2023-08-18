package com.jquery.upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jquery.PageGeneratorManager;
import pageObject.jquery.UploadPageObject;


public class Level_14_Upload_File extends BaseTest {
	WebDriver driver;
	UploadPageObject uploadPage;
	String indonesia = "Indonesia.jpeg";
	String thailan = "ThaiLan.jpeg";
	String vietnam = "VietNam.jpeg";
	String[] fileNames = {"Indonesia.jpeg","ThaiLan.jpeg"};
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		uploadPage = PageGeneratorManager.getUploadPageObject(driver);
	}

	public void TC_01_Upload_Single_File() {
		uploadPage.uploadMultipleFiles(driver, indonesia);
		uploadPage.sleepInsecond(2);
		
		uploadPage.uploadMultipleFiles(driver, thailan);
		uploadPage.sleepInsecond(2);

		uploadPage.uploadMultipleFiles(driver, vietnam);
		uploadPage.sleepInsecond(2);
		
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(indonesia));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(thailan));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(vietnam));

		uploadPage.clickToStartButtonOnEachFile();
		uploadPage.sleepInsecond(2);

		
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(indonesia));
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(thailan));
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(vietnam));
	}

	public void TC_02_Upload_Multiple_File() {
		uploadPage.refreshToPage(driver);
		uploadPage.uploadMultipleFiles(driver, fileNames);
		uploadPage.sleepInsecond(2);
		
		
		
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(indonesia));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(thailan));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(vietnam));

		uploadPage.clickToStartButtonOnEachFile();
	

		
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(indonesia));
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(thailan));
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(vietnam));

		
	}
	@Test
	public void TC_03_Upload_GoFile() {
		uploadPage.openPageUrl(driver, "https://gofile.io/uploadFiles");
		
		Assert.assertTrue(uploadPage.isLoadingIconAtMainContentDisappear());
		
		uploadPage.uploadMultipleFiles(driver, fileNames);
		
		Assert.assertTrue(uploadPage.isLoadingIconAtMainUploadDisappear());
		
		Assert.assertTrue(uploadPage.isMultipleProgressBarIconDisappear());
		
		Assert.assertTrue(uploadPage.isSuccessMessageDisplayed("Your files have been successfully uploaded"));
		
		uploadPage.clickToSuccessLink();
		
		Assert.assertTrue(uploadPage.isContentTableDisplayed());
		
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(indonesia));
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(thailan));
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(vietnam));
		
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(indonesia));
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(thailan));
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(vietnam));

		
		

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}