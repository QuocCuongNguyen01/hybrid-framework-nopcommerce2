package pageObject.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.jquery.UpLoadPageUI;
import commons.BasePage;

public class UploadPageObject extends BasePage {
	WebDriver driver;

	public UploadPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedSuccess(String fileName) {
		waitForElementVisible(driver, UpLoadPageUI.FILE_LOADED_BY_NAME, fileName);
		return isElementDisplayed(driver, UpLoadPageUI.FILE_LOADED_BY_NAME, fileName);
	}

	public void clickToStartButtonOnEachFile() {
		List<WebElement> startButtons = getListWebElement(driver, UpLoadPageUI.MULTIPLE_START_BUTTON);
		for (WebElement button : startButtons) {
			waitForElementClickable(driver, button);
			clickToElement(driver, button);
		}
	}

	public boolean isFileUpLoadedSuccess(String fileName) {
		waitForElementVisible(driver, UpLoadPageUI.FILE_UPLOADED_BY_NAME, fileName);
		return isElementDisplayed(driver, UpLoadPageUI.FILE_UPLOADED_BY_NAME, fileName);
	}

	public boolean isLoadingIconAtMainContentDisappear() {
		return waitForElementInvisible(driver, UpLoadPageUI.SPIN_BORDER_ICON_AT_MAIN_CONTENT);
	}

	public boolean isLoadingIconAtMainUploadDisappear() {
		return waitForElementInvisible(driver, UpLoadPageUI.SPIN_BORDER_ICON_AT_MAIN_UPLOAD);
	}

	public boolean isMultipleProgressBarIconDisappear() {
		return waitForListElementInvisible(driver, UpLoadPageUI.MULTIPLE_PROGRESS_BAR_ICON);
	}

	public boolean isSuccessMessageDisplayed(String successMessage) {
		waitForElementVisible(driver, UpLoadPageUI.UPLOADED_SUCCESS_MESSAGE,successMessage);
		return isElementDisplayed(driver, UpLoadPageUI.UPLOADED_SUCCESS_MESSAGE,successMessage);
	}
	public void clickToSuccessLink() {
		waitForElementClickable(driver, UpLoadPageUI.UPLOADED_SUCCESS_LINK);
		clickToElement(driver, UpLoadPageUI.UPLOADED_SUCCESS_LINK);
	}
	public boolean isContentTableDisplayed() {
		waitForElementVisible(driver, UpLoadPageUI.UPLOADED_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UpLoadPageUI.UPLOADED_SUCCESS_MESSAGE);
	}



	public boolean isDownloadButtonDisplayed(String fileName) {
		waitForElementVisible(driver, UpLoadPageUI.DOWNLOAD_BUTTON_FILE_BY_NAME, fileName);
		return isElementDisplayed(driver, UpLoadPageUI.DOWNLOAD_BUTTON_FILE_BY_NAME, fileName);
	}

	public boolean isPlayButtonDisplayed(String fileName) {
		waitForElementVisible(driver, UpLoadPageUI.PLAY_BUTTON_FILE_BY_NAME, fileName);
		return isElementDisplayed(driver, UpLoadPageUI.PLAY_BUTTON_FILE_BY_NAME, fileName);
	}
}
