package POMproject.WebsiteTestingMay2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class LandingPage extends AbstractClass{
	WebDriver driver;
	
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(css="#userEmail")
	WebElement Email;
	
	@FindBy(css="#userPassword")
	WebElement Password;
	
	@FindBy(css=".btn")
	WebElement Button;
	

	@FindBy(css=".ng-star-inserted")
	WebElement errormessege;

	
	
	public void getToPage()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductPage Login(String email, String password)
	{
		Email.sendKeys(email);
		Password.sendKeys(password);
		Button.click();
		ProductPage productpage=new ProductPage(driver);
		return productpage;
		
	}
	
	public String errormessege()
	{
	String errorreply=errormessege.getText();
	return errorreply;
		
	}

}
