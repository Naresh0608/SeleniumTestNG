package Framework.SeleniumRevision.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Framework.SeleniumRevision.AbstractComponents.AbstractComponent;
//4th Page
public class OrderPage extends AbstractComponent {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement CountryDropdownBtn;

	@FindBy(xpath = "//button[@type='button'][2]")
	WebElement CountrySelectionValue;

	@FindBy(css = ".action__submit")
	WebElement Placeorder;

	public void CountrySelection(String CountryName) {
		Actions act = new Actions(driver);
		CountryDropdownBtn.sendKeys(CountryName);
		// act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select
		// Country']")), "India").build().perform();
		CountrySelectionValue.click();

	}

	public OrderConfirmationPage PlaceOrder() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Placeorder);
		Thread.sleep(3000);
		Placeorder.click();
		OrderConfirmationPage OrderConf = new OrderConfirmationPage(driver);
		return OrderConf;
	}

}
