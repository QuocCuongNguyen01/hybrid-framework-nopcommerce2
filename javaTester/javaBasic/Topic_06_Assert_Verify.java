package javaBasic;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_06_Assert_Verify {

	public static void main(String[] args) {
		Topic_06_Assert_Verify frodo = new Topic_06_Assert_Verify();
		Topic_06_Assert_Verify sauron = new Topic_06_Assert_Verify();

		// basic assertions
		assertThat(frodo.getName()).isEqualTo("Frodo");
		assertThat(frodo).isNotEqualTo(sauron);

		// chaining string specific assertions
		assertThat(frodo.getName()).startsWith("Fro");
		assertThat(frodo.getName()).endsWith("Fro");
		assertThat(frodo.getName()).isEqualToIgnoringCase("Fro");
		assertThat(frodo.getName()).startsWith("Fro")
		                           .endsWith("do")
		                           .isEqualToIgnoringCase("frodo");

	}
	public String getName() {
		return "Frodo";
	}
	
	//True/False : nó sẽ nhận tham số là kiểu dữ liệu boolean
	//isDisplayed/ isSelected/ isEnable/ isMultiple -> boolean
	// wait trả về boolean
	// isPageLoadingSuccess/ isImageLoaded .... 
	@Test
	public void TC_01() {
	boolean status = true;
	Assert.assertTrue(status);
	
	status = false;
	Assert.assertFalse(status);
	//Equals: nó sẽ nhận 2 kiểu tham số có kiểu dữ liệu tương ứng nhau

	String fullName = "QCNguyen";
	Assert.assertEquals(fullName, "QCNguyen");
	
	
	}
}
