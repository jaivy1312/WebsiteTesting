package POMproject.websiteTestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import POMproject.WebsiteTestingMay2023.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landpage;
	public WebDriver initialization() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fp= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//browser.properties");
		prop.load(fp);
		String browser=System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if (browser.contains("chrome"))
		{	
			ChromeOptions option=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browser.contains("headless"))
			{
			option.addArguments("headless");
			}
			driver = new ChromeDriver(option);
			driver.manage().window().setSize(new Dimension(1140,900));

		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchapplication() throws IOException
	{	
		initialization();
		landpage=new LandingPage(driver);
		landpage.getToPage();
		return landpage;
	}

	
	@AfterMethod(alwaysRun=true)
	public void closebrowser() {
		driver.close();

}
	   public  String getscreenshot(String testcasename,WebDriver driver) throws IOException
	   {
		   TakesScreenshot ts=(TakesScreenshot)driver;
		  File source =ts.getScreenshotAs(OutputType.FILE);
		  File file=new File(System.getProperty("user.dir") + "//reports//" + testcasename + ".png");
		  FileUtils.copyFile(source, file);
		  return System.getProperty("user.dir") + "//reports//" + testcasename + ".png";
		   
	   }
	 //takes screenshot

	

}
