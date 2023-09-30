package POMproject.WebsiteTestingMay2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Abstract.AbstractClass;

public class CartPage extends AbstractClass {

	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*		List<WebElement>cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
		
	Boolean match=	cartproducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();*/
	@FindBy (css=".cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy (css=".totalRow button")
	WebElement payment;
	

	public Boolean getItemText(String productname)
	{
		Boolean match=cartproducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
		return match;
	}
	
	public CheckoutPage clickOnCartProduct()
	{
		payment.click();
		CheckoutPage checkout= new CheckoutPage(driver);
		return checkout;
	}
	

}
