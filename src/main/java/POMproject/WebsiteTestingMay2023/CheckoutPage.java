package POMproject.WebsiteTestingMay2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class CheckoutPage extends AbstractClass {

	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	/*		Actions a=new Actions(driver);
		
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"ind").build().perform();
		
		driver.findElement(By.cssSelector("button[type='button']:nth-of-type(2)")).click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();*/
	
	@FindBy (css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css="button[type='button']:nth-of-type(2)")
	WebElement selectcountry;
	
	@FindBy(css=".action__submit")
	WebElement thankyoupage;
	
	
	public void EnterCountry(String countryname)
	{
		Actions a= new Actions(driver);
		a.sendKeys(country,countryname).build().perform();
		selectcountry.click();
	}
	
	public ThankyouPage goToThankyouPage(String countryname)
	{
		EnterCountry(countryname);
		thankyoupage.click();
		ThankyouPage thankyoupage=new ThankyouPage(driver);
		return thankyoupage;
	}
	
	

}
