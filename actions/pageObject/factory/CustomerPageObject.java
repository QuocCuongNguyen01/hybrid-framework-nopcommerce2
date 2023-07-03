package pageObject.factory;

import org.openqa.selenium.WebDriver;

import commons.BasePageFactory;

public class CustomerPageObject  extends BasePageFactory{
	WebDriver driver;
	public CustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getFirstNameTexboxAttributeValue() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getLastNameTexboxAttributeValue() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEmailTexboxAttributeValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
