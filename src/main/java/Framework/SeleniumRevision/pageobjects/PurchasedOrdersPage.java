package Framework.SeleniumRevision.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Framework.SeleniumRevision.AbstractComponents.AbstractComponent;
//3rd Page
public class PurchasedOrdersPage extends AbstractComponent {

	WebDriver driver;

	public PurchasedOrdersPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//tr/td[2]")
	List<WebElement> OrderedProducts;




	public Boolean VerifyProductinOrdersList(String ProductName){

		Boolean result = OrderedProducts.stream()
				.anyMatch(OrderProduct -> OrderProduct.getText().equalsIgnoreCase(ProductName));
		return result;


	}
	


}
