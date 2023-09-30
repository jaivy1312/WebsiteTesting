package cucumber.stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import POMproject.WebsiteTestingMay2023.CartPage;
import POMproject.WebsiteTestingMay2023.CheckoutPage;
import POMproject.WebsiteTestingMay2023.LandingPage;
import POMproject.WebsiteTestingMay2023.ProductPage;
import POMproject.WebsiteTestingMay2023.ThankyouPage;
import POMproject.websiteTestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefImp extends BaseTest {
	public LandingPage landingpage;
	public ProductPage productpage;
	public CartPage cartpage;
	ThankyouPage thankyoupage;
	@Given("I landed on ecommerce loginPage")
	public void I_landed_on_ecommerce_loginPage() throws IOException
	{
		landingpage=launchapplication();
	}
	
	@Given("^Logged in using username \"([^\"]*)\" and password \"([^\"]*)\" $")
	public void Logged_in_using_username_and_password(String username,String password)
	{
		productpage=landingpage.Login(username,password);
	}
	
	@When("^I add product \"([^\"]*)\" in the cart$")
	public void addproductcucumber(String product) throws InterruptedException
	{
		List<WebElement> prod=productpage.getProductList();
		cartpage=productpage.clickOnProduct(product);
	}
	
	@And("^checkoutPage verify order \"([^\"]*)\" and submit order$")
	public void verifyProductAndOrder(String product)
	{
		cartpage=productpage.clickOnCart();
		Boolean match=cartpage.getItemText(product);
		Assert.assertTrue(match);
		CheckoutPage checkout=cartpage.clickOnCartProduct();
		
		thankyoupage=checkout.goToThankyouPage("Ind");
	}
	
	@Then("{string} messege is displayed on confirmationPage")
	public void verifymessege(String string)
	{

		
		String actualtext=thankyoupage.getThankyouText();
		
		Assert.assertTrue(actualtext.equalsIgnoreCase(string),"test failed");
	}
	/*@Given("Logged in using usernamejaibirsingh131213@gmail.com and password@Ks123456")
	public void logged_in_using_usernamejaibirsingh131213_gmail_com_and_password_ks123456() {
		productpage=landingpage.Login("jaibirsingh131213@gmail.com","@Ks123456");
	    throw new io.cucumber.java.PendingException();
	}
	
	
	@When("^I add productzara coat {String} in the cart$")
	public void i_add_productzara_coat_in_the_cart(String int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("checkoutPage verify orderzara coat {int} and submit order")
	public void checkout_page_verify_orderzara_coat_and_submit_order(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/
	
}
