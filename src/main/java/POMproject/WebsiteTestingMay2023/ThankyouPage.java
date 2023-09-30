package POMproject.WebsiteTestingMay2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class ThankyouPage extends AbstractClass {
	WebDriver driver;
	
	
	public ThankyouPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 		String expectedtext="Thankyou for the order.";
		
		String actualtext=driver.findElement(By.xpath("//h1")).getText();
		*/
	@FindBy(xpath="//h1")
	WebElement thankyoutext;
	
	public String getThankyouText()
	{
		String actualtext=thankyoutext.getText();
		return actualtext;
	}
	
	
}
