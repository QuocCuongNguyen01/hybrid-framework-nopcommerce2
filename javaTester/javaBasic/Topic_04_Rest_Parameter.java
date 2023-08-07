package javaBasic;

import org.testng.annotations.Test;

public class Topic_04_Rest_Parameter {

	String addressLink = "//div[@class='side-2']//a[text()='Addresses']";
	String orderLink = "//div[@class='side-2']//a[text()='Orders']";

	String dynamicSidebarLink = "//div[@class='side-2']//a[text()='%s']";
	String dynamicLink = "//div[@class='%s']//a[text()='%s']";
	String dynamicMenuLink = "//div[@class='%s']//div[id='%s']//a[text()='%s']";

	@Test
	public void TC_01_Rest_Param() {
		clickToElement(addressLink);
		clickToElement(orderLink);

		clickToElement(dynamicSidebarLink, "Addresses");
		clickToElement(dynamicSidebarLink, "Orders");
		clickToElement(dynamicSidebarLink, "Customer info");

		clickToElement(dynamicLink, "footer", "Orders");
		clickToElement(dynamicLink, "footer", "Blog");

		clickToElement(dynamicLink, "header", "Register");
		clickToElement(dynamicLink, "header", "Login");

		clickToElement(dynamicMenuLink, "header", "Account", "Login");
		clickToElement(dynamicMenuLink, "header", "mobile", "Samsung");
	
	}

//	// Hàm để click vào 1 element cố định
//	public void clickToElement(String locatorValue) {
//		System.out.println("Click to:" + locatorValue);
//	}
//
//	// Hàm để click vào 1 element không cố định (dynamic) với 1 tham số
//	public void clickToElement(String locatorValue, String param) {
//		locatorValue = String.format(locatorValue, param);
//		System.out.println("Locator Trước khi pass value vào:" + locatorValue);
//	}
//	// Hàm để click vào 1 element không cố định (dynamic) với 2 tham số
//
//	public void clickToElement(String locatorValue, String pageType, String pageName) {
//		locatorValue = String.format(locatorValue, pageType, pageName);
//		System.out.println("Locator Trước khi pass value vào:" + locatorValue);
//	}
//	// Hàm để click vào 1 element không cố định (dynamic) với 3 tham số
//
//	public void clickToElement(String locatorValue, String pageType, String categoryType, String pageName) {
//		locatorValue = String.format(locatorValue, pageType, categoryType, pageName);
//		System.out.println("Locator Trước khi pass value vào:" + locatorValue);
//	}
	
	// Var Arguments = Rest Parameter
	// Hàm để click vào 1 element không cố định (dynamic) với bất kì 1 tham số nào(từ 1 -n tham số)
	public void clickToElement(String locatorValue, String... values) {
		locatorValue = String.format(locatorValue, (Object[]) values);
		System.out.println("Locator Trước khi pass value vào:" + locatorValue);
	}
}
