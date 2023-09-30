package POMproject.WebsiteTestingMay2023;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class OrderPage extends AbstractClass{
	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//tbody/tr/td[2]")
	List<WebElement> orderproducts;
	
	public Boolean getorderedproducts(String productname)
	{
		Boolean match2=orderproducts.stream().anyMatch(orderproduct->orderproduct.getText().equalsIgnoreCase(productname));
		return match2;
	}
}
