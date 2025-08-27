package Framework.SeleniumRevision.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Framework.SeleniumRevision.AbstractComponents.AbstractComponent;
//2nd Page
public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[contains(@class,'mb-3')]")
	List<WebElement> products;

	By ProductBy = By.xpath("//div[contains(@class,'mb-3')]");

	By AddtoCart = By.xpath(".//div[@class='card-body']/button[2]");

	By Toast = By.id("toast-container");

	@FindBy(xpath = ".//h5/b")
	WebElement MyProduct;

	@FindBy(css = ".ng-animating")
	WebElement Spinner;

	public List<WebElement> getProductList() {

		waitforElementtoAppear(ProductBy);
		return products;

	}

	public void getProductByName(String ProductName) throws InterruptedException {

		WebElement MyProduct = getProductList().stream()
				.filter(OneProduct -> OneProduct.findElement(By.xpath(".//h5/b")).getText().equals(ProductName))
				.findFirst().orElse(null);

		MyProduct.findElement(AddtoCart).click();

		waitforElementtoAppear(Toast);
		WaitforElementtoDisappear(Spinner);
		Thread.sleep(3000);

	}

}
