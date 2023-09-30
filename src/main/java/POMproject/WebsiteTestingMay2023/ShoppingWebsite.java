package POMproject.WebsiteTestingMay2023;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShoppingWebsite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		
		
		FirefoxDriver driver = new FirefoxDriver();
		String productname="zara coat 3";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("jaibirsingh1312@gmail.com");
		
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("123456");
		
		driver.findElement(By.cssSelector(".btn")).click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".mb-3"))));
		
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//.toast-container
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".toast-container"))));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
		
		List<WebElement>cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
		
	Boolean match=	cartproducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		//select country using actions
		
		Actions a=new Actions(driver);
		
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"ind").build().perform();
		
		driver.findElement(By.cssSelector("button[type='button']:nth-of-type(2)")).click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String expectedtext="Thankyou for the order.";
		
		String actualtext=driver.findElement(By.xpath("//h1")).getText();
		
		Assert.assertTrue(actualtext.equalsIgnoreCase(expectedtext),"test failed");
		
		driver.close();
	}

}
