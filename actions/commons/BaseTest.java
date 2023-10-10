package commons;

import java.io.File;
import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	protected final Logger log;
	private WebDriver driver;

	public BaseTest() {
		log = LogManager.getLogger(getClass());
	}

	String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {

		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

//		if (browser == BrowserList.FIREFOX) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//			driver = new FirefoxDriver();
//		} else if (browser == BrowserList.CHROME) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//			driver = new ChromeDriver();
//		} else if (browser == BrowserList.EDGE) {
//			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
//			driver = new EdgeDriver();
//		} else if (browser == BrowserList.OPERA) {
//			System.setProperty("webdriver.opera.driver", projectPath + "/browserDrivers/operadriver");
//			driver = new OperaDriver();
//		}else {
//		}

		switch (browser) {
		case FIREFOX:
			// WebDriverManager 4.x/ 5.x : Tải về driver và setting biến môi trường
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();

			// WebDriverManager 5.x: Tải Driver + setting biến môi trường và khởi tạo driver lên
//			driver = WebDriverManager.firefoxdriver().create();
			
			// Selenium Manager
			driver = new FirefoxDriver();
			break;
		case CHROME:
//			driver = WebDriverManager.chromedriver().create();
			driver = new ChromeDriver();

			break;
		case EDGE:
//			driver = WebDriverManager.edgedriver().create();
			driver = new EdgeDriver();
			break;
		case OPERA:
//			driver = WebDriverManager.operadriver().create();
//		 	driver = new OperaDriver();
			break;

		default:
			throw new RuntimeException("Browser name is not valid.");

		}

		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String url) {

		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:
			driver = new ChromeDriver();

			break;
		case EDGE:
			driver = new EdgeDriver();
			break;
		case OPERA:
			break;

		default:
			throw new RuntimeException("Browser name is not valid.");

		}

		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT));
		driver.get(url);
		return driver;
	}

	protected String getEmailRandom() {
		Random rand = new Random();
		return "join" + rand.nextInt(99999) + "@gmail.com";
	}

	protected void closeBrowser() {
		if (driver == null) {
			System.out.println("error");
		} else {
			driver.quit();
		}
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info("----------PASS----------");

		} catch (Throwable e) {
			log.info("----------FALSE----------");

			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info("----------PASS----------");
		} catch (Throwable e) {
			log.info("----------FALSE----------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("----------PASS----------");

		} catch (Throwable e) {
			log.info("----------FALSE----------");

			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	public WebDriver getDriver() {
		return driver;
	}
	@BeforeSuite
	//public void deleteFileReportNG() {
		//log.info("Starting delete all file in ReportNG screenshot");
		//deleteAllFileInFolder();
		//log.info("Deleted success");
	
	public void deleteFileInReport() {
		//remove all file in reportNGImage
		deleteAllFileInFolder("reportNGImage");
		//remove all file in allure attachment
		deleteAllFileInFolder("allure-json");
	}
	
	public void deleteAllFileInFolder(String folderName) {
		try {
			String pathFolderDownload = GlobalConstant.RELATIVE_PROJECT_PATH + File.separator + folderName;
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			if (listOfFiles.length != 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
						new File(listOfFiles[i].toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
}
