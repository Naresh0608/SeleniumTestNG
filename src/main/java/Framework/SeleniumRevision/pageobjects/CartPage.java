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
public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ul[contains(@class,'cartWrap')]//h3")
	List<WebElement> CartProducts;

	@FindBy(xpath = "//*[@class='totalRow']/button")
	WebElement CheckoutBtn;



	public Boolean VerifyProductinCart(String ProductName){

		Boolean result = CartProducts.stream()
				.anyMatch(CartProduct -> CartProduct.getText().equalsIgnoreCase(ProductName));
		return result;


	}
	
	public OrderPage CheckoutfromCart() {

		CheckoutBtn.click();
		OrderPage Order = new OrderPage(driver);
		return Order;
	}

}
