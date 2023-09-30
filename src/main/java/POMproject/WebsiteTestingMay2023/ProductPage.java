package POMproject.WebsiteTestingMay2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Abstract.AbstractClass;

public class ProductPage extends AbstractClass {
	
	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css=".mb-3")
	List<WebElement> products;
	
	@FindBy (css=".mb-3")
	WebElement productappear;
	
	@FindBy (css=".toast-container")
	WebElement toastappear;
	
	@FindBy (css=".ng-animating")
	WebElement productselecteddisappear;
	
	@FindBy (xpath="//button[contains(@routerlink,'cart')]")
	WebElement checkout;
	
	
	
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productappear);
		return products;
	}
	
	public WebElement SelectProduct(String productname)
	{
		
		WebElement prod=getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
		return prod;
	}
	public CartPage clickOnProduct(String productname) throws InterruptedException
	{	WebElement prod=SelectProduct(productname);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		waitForElementToAppear(toastappear);
		//waitForElementToDisappear(productselecteddisappear);
		
		Thread.sleep(4000);
		clickOnCart();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}

	


}
