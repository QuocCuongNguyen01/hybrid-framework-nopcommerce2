package com.nopcommerce.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_BasePage_3_Inheritance extends BasePage{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void Register_01_Empty_Data() {

		openPageUrl(driver, "https://demo.nopcommerce.com/");

		clickToElement(driver, "//a[@class='ico-register']");

		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {

		openPageUrl(driver, "https://demo.nopcommerce.com/");

		clickToElement(driver, "//a[@class='ico-register']");

		senkeyToElement(driver, "//input[@id='FirstName']", "Anh");
		senkeyToElement(driver, "//input[@id='LastName']", "Tuan");
		senkeyToElement(driver, "//input[@id='Email']", "join");
		senkeyToElement(driver, "//input[@id='Password']", "123456");
		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void Register_03_Invalid_Passsword() {
		openPageUrl(driver, "https://demo.nopcommerce.com/");

		clickToElement(driver, "//a[@class='ico-register']");
		
		senkeyToElement(driver, "//input[@id='FirstName']", "Anh");
		senkeyToElement(driver, "//input[@id='LastName']", "Tuan");
		senkeyToElement(driver, "//input[@id='Email']", "join@gail.com");
		senkeyToElement(driver, "//input[@id='Password']", "123");
		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
		
		clickToElement(driver, "//button[@id='register-button']");
		
		
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");

		// var text = $$(element)[note]
		// text.textcontext

	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {
		openPageUrl(driver, "https://demo.nopcommerce.com/");

		clickToElement(driver, "//a[@class='ico-register']");
		
		senkeyToElement(driver, "//input[@id='FirstName']", "Anh");
		senkeyToElement(driver, "//input[@id='LastName']", "Tuan");
		senkeyToElement(driver, "//input[@id='Email']", getEmailRandom());
		senkeyToElement(driver, "//input[@id='Password']", "123456");
		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");

		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");


	}

	@Test
	public void Register_05_Success() {
		openPageUrl(driver, "https://demo.nopcommerce.com/");

		clickToElement(driver, "//a[@class='ico-register']");
		
		senkeyToElement(driver, "//input[@id='FirstName']", "Anh");
		senkeyToElement(driver, "//input[@id='LastName']", "Tuan");
		senkeyToElement(driver, "//input[@id='Email']", getEmailRandom());
		senkeyToElement(driver, "//input[@id='Password']", "123456");
		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

	}

	public void sleepInsecond(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
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