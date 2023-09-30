package Abstract;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POMproject.WebsiteTestingMay2023.CartPage;
import POMproject.WebsiteTestingMay2023.OrderPage;

public class AbstractClass {
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	


	public AbstractClass(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		this.wait=wait;
		
	}
	
	@FindBy (xpath="//button[contains(@routerlink,'cart')]")
	WebElement cart;
	
	@FindBy (css="button[routerlink*='myorders']")
	WebElement order;

	
	public void waitForElementToAppear(WebElement findby)
	{
		
		wait.until(ExpectedConditions.visibilityOf(findby));
	
	}
	
	public void waitForElementToDisappear(WebElement findby)
	{
		
		wait.until(ExpectedConditions.invisibilityOf(findby));
	}

	public CartPage clickOnCart()
	{
		cart.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
		
	}

	
	public OrderPage clickOnOrderPage()
	{
		order.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
	}



}
