package Framework.SeleniumRevision.Tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Framework.SeleniumRevision.pageobjects.CartPage;
import Framework.SeleniumRevision.pageobjects.LandingPage;
import Framework.SeleniumRevision.pageobjects.OrderConfirmationPage;
import Framework.SeleniumRevision.pageobjects.OrderPage;
import Framework.SeleniumRevision.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

//E2E Automation with POM and Abstract Method Incorporated

public class ProductsOrderingTestNG {

	public static void main(String[] args) throws InterruptedException {

		String ProductName = "ADIDAS ORIGINAL";
		WebDriver driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize(); // maximize the window

		// 1.Landing Page
		LandingPage Login = new LandingPage(driver);
		Login.goTo();
		ProductCatalogue Prod = Login.LoginApplication("selenium@ggg.com", "Hello123");
//-------------------------------------------------------------------------
		// 2.Product Catalog Page
		Prod.getProductList();

		// Add product :
		Prod.getProductByName(ProductName);

		// Click on Cart
		CartPage Cart=Prod.GotoCartPage();
//---------------------------------------------------------------------------
		// 3.CartPage
		boolean result = Cart.VerifyProductinCart(ProductName);

		Assert.assertTrue(result);

		// checkout from cart
		OrderPage Order = Cart.CheckoutfromCart();
//-----------------------------------------------------------------------------
		// 4.Place Order Page
		Order.CountrySelection("India");
		OrderConfirmationPage OrderConf = Order.PlaceOrder();
//---------------------------------------------------------------------------------
		// 5.Order Confirmation Page
		String ConfirmationMsg = OrderConf.OrderConfirmationValidation();
		Assert.assertTrue(ConfirmationMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

}
