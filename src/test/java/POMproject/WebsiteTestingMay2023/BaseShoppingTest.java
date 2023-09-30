package POMproject.WebsiteTestingMay2023;




import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sun.net.httpserver.Authenticator.Retry;

import POMproject.websiteTestComponents.BaseTest;
import POMproject.websiteTestComponents.Retry1;
import resources.UtilityToReadJson;

public class BaseShoppingTest extends BaseTest{

	
	@Test(dataProvider="getdatasubmitjson",retryAnalyzer=Retry1.class)
	public void submittest(HashMap<String,String> input) throws IOException, InterruptedException{
		
		
	String productname="zara coat 3";
	String countryname="ind";
		
		ProductPage productpage=landpage.Login(input.get("email"), input.get("password"));
		CartPage cartPage=productpage.clickOnProduct(input.get("productname"));
		CartPage cartpage=productpage.clickOnCart();
		Boolean match=cartpage.getItemText(input.get("productname"));
		Assert.assertTrue(match);
		//.toast-container
		CheckoutPage checkout=cartPage.clickOnCartProduct();
		
		//select country using actions checkout page
		ThankyouPage thankyoupage=checkout.goToThankyouPage(input.get("countryname"));
		
		//contents of thankyoupage
		String expectedtext="Thankyou for the order.";
		String actualtext=thankyoupage.getThankyouText();
		
		Assert.assertTrue(actualtext.equalsIgnoreCase(expectedtext),"test failed");
		
		
	}
	
	@Test(dependsOnMethods= {"submittest"},dataProvider="getdatasubmitjson")
	public void verifyordertest(HashMap<String,String> input)
	{
		
		ProductPage productpage=landpage.Login(input.get("email"), input.get("password"));
		OrderPage orderpage=productpage.clickOnOrderPage();
		Boolean match1=orderpage.getorderedproducts(input.get("productname"));
		Assert.assertTrue(match1);
	}
	@Test(dependsOnMethods= {"submittest"},dataProvider="getdatasubmitjson")
	public void verifycarttest(HashMap<String,String> input)
	{	
		SoftAssert sa=new SoftAssert();
		ProductPage productpage=landpage.Login(input.get("email"), input.get("password"));
		
		CartPage cartpage=productpage.clickOnCart();
		Boolean match=cartpage.getItemText(input.get("productname"));
		sa.assertFalse(match);
		sa.assertAll();
	}
	
	
	//using hashmap
	@DataProvider
	public Object[][] getdatasubmit()
	{
		HashMap<Object,Object> map=new HashMap<Object,Object>();
		map.put("email", "jaibirsingh1312@gmail.com");
		map.put("password", "123456");
		map.put("productname", "zara coat 3");
		HashMap<Object,Object> map2=new HashMap<Object,Object>();
		map2.put("email", "jaibirsingh131213@gmail.com");
		map2.put("password", "@Ks123456");
		map2.put("productname", "adidas original");
		return new Object[][] {{map},{map2}};
		
		
	}
	
	//using json file
   @DataProvider
   public Object[][] getdatasubmitjson() throws IOException
 {
	UtilityToReadJson read=new UtilityToReadJson();
	List<HashMap<String,String>>data=read.getJsonDataToMap(System.getProperty("user.dir")+"//src//main//java//resources//data.json");
	return new Object[][] {{data.get(0)},{data.get(1)}};
}
   
   
   
   
}

