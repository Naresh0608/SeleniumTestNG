package Framework.SeleniumRevision.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Framework.SeleniumRevision.TestComponents.BaseTestCase;
import Framework.SeleniumRevision.TestComponents.Retry;
import Framework.SeleniumRevision.pageobjects.CartPage;
import Framework.SeleniumRevision.pageobjects.OrderConfirmationPage;
import Framework.SeleniumRevision.pageobjects.OrderPage;
import Framework.SeleniumRevision.pageobjects.ProductCatalogue;

//E2E Automation with Base Class, Properties file and TestNG Annotations

public class ErrorVerifications extends BaseTestCase {

	@Test(groups={"LoginError"},retryAnalyzer=Retry.class)
	public void	LoginErrorScenario () throws IOException, InterruptedException {

//-------------------------------------------------------------------------
		// 1.Landing Page
		Login.LoginApplication("selenium@gggttt.com", "Hello1234");
		Assert.assertEquals(Login.ErrorMsgValidation(), "Inorrect email or password.");
//-------------------------------------------------------------------------
	}
	
	@Test(groups={"LoginError"})
	public void InvalidProductErrorSceanrio() throws InterruptedException {
		
		String ProductName = "ADIDAS ORIGINAL";

//-------------------------------------------------------------------------
		// 1.Landing Page
	//	Login.goTo();
		ProductCatalogue Prod = Login.LoginApplication("selenium@naresh.com", "Hello234");
//-------------------------------------------------------------------------
		// 2.Product Catalog Page
		Prod.getProductList();

		// Add product :
		Prod.getProductByName(ProductName);

		// Click on Cart
		CartPage Cart=Prod.GotoCartPage();
//---------------------------------------------------------------------------
		// 3.CartPage
		boolean result = Cart.VerifyProductinCart("Nike Orginal");

		Assert.assertFalse(result);
		
		
	}

}
