package POMproject.WebsiteTestingMay2023;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POMproject.websiteTestComponents.BaseTest;

import org.testng.Assert;

public class ErrorValidationTest extends BaseTest {
	
	
	
	@Test(dataProvider="getdataerror")
	public void validateerrorcode(String email,String password) throws InterruptedException
	{
		ProductPage productpage=landpage.Login(email, password);
		Thread.sleep(1000);
		String errorreply=landpage.errormessege();
		Assert.assertEquals(errorreply, "Incorrect email or password.");
		
		
	}
	@DataProvider
	public Object[][] getdataerror()
	{
		return new Object[][] {{"jaibiirsingh1312@gmail.com","123456"},{"ajibirsingh1255@gmail.com","12345"}};
	}

	
	
}
