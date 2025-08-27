package Framework.SeleniumRevision.Tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework.SeleniumRevision.TestComponents.BaseTestCase;
import Framework.SeleniumRevision.pageobjects.CartPage;
import Framework.SeleniumRevision.pageobjects.LandingPage;
import Framework.SeleniumRevision.pageobjects.OrderConfirmationPage;
import Framework.SeleniumRevision.pageobjects.OrderPage;
import Framework.SeleniumRevision.pageobjects.ProductCatalogue;
import Framework.SeleniumRevision.pageobjects.PurchasedOrdersPage;
import io.github.bonigarcia.wdm.WebDriverManager;

//E2E Automation with Base Class, Properties file , TestNG Annotations and with parameterization

public class ProductsOrderingTestNGV2 extends BaseTestCase {

	String NProductName = "ADIDAS ORIGINAL";

	@Test(dataProvider = "GetHashMapData", groups = {"ProductOrder"})
	public void ItemCheckout(HashMap<String,String> Map) throws IOException, InterruptedException {

//-------------------------------------------------------------------------
		// 1.Landing Page
		// Login.goTo();
		ProductCatalogue Prod = Login.LoginApplication(Map.get("MapUserEmail"), Map.get("MapUserPassword"));
//-------------------------------------------------------------------------
		// 2.Product Catalog Page
		Prod.getProductList();

		// Add product :
		Prod.getProductByName(Map.get("MapProductName"));

		// Click on Cart
		CartPage Cart = Prod.GotoCartPage();
//---------------------------------------------------------------------------
		// 3.CartPage
		boolean result = Cart.VerifyProductinCart(Map.get("MapProductName"));

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

	@Test(dependsOnMethods = { "ItemCheckout" })
	public void OrdersSectionValidation() {

//-------------------------------------------------------------------------
		// 1.Landing Page
		ProductCatalogue Prod = Login.LoginApplication("selenium@ggg.com", "Hello123");

//-------------------------------------------------------------------------
		// 2.PurchasedOrdersPage

		PurchasedOrdersPage Order = Prod.GotoOrdersPage();

		boolean OrderPresence = Order.VerifyProductinOrdersList(NProductName);

		Assert.assertTrue(OrderPresence);

//-------------------------------------------------------------------------

	}
	
 	@DataProvider
 		public Object[][] GetData() {
		
		Object [] [] OrderDetails = {{"selenium@ggg.com","Hello123","ADIDAS ORIGINAL"},{"selenium@naresh.com","Hello234","ZARA COAT 3"}};
		return OrderDetails;
	}
	
	@DataProvider
	public Object[][] GetHashMapData() {
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("MapUserEmail","selenium@ggg.com");
		map1.put("MapUserPassword","Hello123");
		map1.put("MapProductName","ADIDAS ORIGINAL");
		

		HashMap<String,String> map2 = new HashMap<String,String>();
		map2.put("MapUserEmail","selenium@naresh.com");
		map2.put("MapUserPassword","Hello234");
		map2.put("MapProductName","ZARA COAT 3");
		
		Object [] [] MapOrderDetails = {{map1},{map2}};
		return MapOrderDetails;
	
		
	}
	
	@DataProvider
	public Object[][] GetJsonData() throws IOException {
		

		List<HashMap<String,String>> data = GetJsonHashMapData(System.getProperty("user.dir")+"\\src\\test\\java\\Framework\\SeleniumRevision\\data\\PurchaseProducts.json");
		Object [] [] MapOrderDetails = {{data.get(0)},{data.get(0)}};
		return MapOrderDetails;
		
	}
	
	
	


	
}
