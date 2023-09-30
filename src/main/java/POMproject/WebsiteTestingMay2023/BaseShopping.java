package POMproject.WebsiteTestingMay2023;




import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseShopping {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		
	String productname="zara coat 3";
	String countryname="ind";
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LandingPage landpage=new LandingPage(driver);
		landpage.getToPage();
		ProductPage productpage=landpage.Login("jaibirsingh1312@gmail.com", "123456");
		CartPage cartPage=productpage.clickOnProduct(productname);
		//.toast-container
		Boolean match=cartPage.getItemText(productname);
		Assert.assertTrue(match);
		CheckoutPage checkout=cartPage.clickOnCartProduct();
		
		//select country using actions checkout page
		ThankyouPage thankyoupage=checkout.goToThankyouPage(countryname);
		
		//contents of thankyoupage
		String expectedtext="Thankyou for the order.";
		String actualtext=thankyoupage.getThankyouText();
		
		Assert.assertTrue(actualtext.equalsIgnoreCase(expectedtext),"test failed");
		
		
	}

}

