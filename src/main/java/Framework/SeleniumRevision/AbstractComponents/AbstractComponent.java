package Framework.SeleniumRevision.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.SeleniumRevision.pageobjects.CartPage;
import Framework.SeleniumRevision.pageobjects.PurchasedOrdersPage;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(@routerlink,'cart')]")
	WebElement CartBtn;
	
	@FindBy(xpath="//button[contains(@routerlink,'myorders')]")
	WebElement OrderBtn;
	

	public void waitforElementtoAppear(By productBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productBy));

	}
	
	public void waitforWebElementtoAppear(WebElement ErrorMsgWebElement) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ErrorMsgWebElement));
		
	}

	public void WaitforElementtoDisappear(WebElement Spinner) {

	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //application problem due to multiple spinner in background
	//	wait.until(ExpectedConditions.invisibilityOf(Spinner));
	}
	
	public CartPage GotoCartPage() {
		
		CartBtn.click();
		CartPage Cart = new CartPage(driver);
		return Cart;
		
	}
	
public PurchasedOrdersPage GotoOrdersPage() {
		
		OrderBtn.click();
		PurchasedOrdersPage Order = new PurchasedOrdersPage(driver);
		return Order;
		
	}
	
}
