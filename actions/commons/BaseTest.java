package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BaseTest {
	private WebDriver driver;

	String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		
		if (browser == BrowserList.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			driver = new FirefoxDriver();
		} else if (browser == BrowserList.CHROME) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			driver = new ChromeDriver();
		} else if (browser == BrowserList.EDGE) {
			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
			driver = new EdgeDriver();
		} else if (browser == BrowserList.OPERA) {
			System.setProperty("webdriver.opera.driver", projectPath + "/browserDrivers/operadriver");
			driver = new OperaDriver();
		}else {
		}
		
		switch (browserName) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
			driver = new EdgeDriver();
			break;
		case "opera":
			System.setProperty("webdriver.opera.driver", projectPath + "/browserDrivers/operadriver");
			driver = new OperaDriver();
			break;

		default:
			throw new RuntimeException("Browser name is not valid.");

		}
		
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().setSize(new Dimension(1920, 1080));
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}
	
	protected String getEmailRandom() {
		Random rand = new Random();
		return "join" + rand.nextInt(99999) + "@gmail.com";
	}
	
	protected void closeBrowser() {
		if (driver == null) {
			System.out.println("error");
		}else {
			driver.quit();
		}
	}
}
