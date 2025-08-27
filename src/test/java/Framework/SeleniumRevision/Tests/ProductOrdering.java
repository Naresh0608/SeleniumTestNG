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

import io.github.bonigarcia.wdm.WebDriverManager;

//E2E Automation with all steps in Test case

public class ProductOrdering {

	public static void main(String[] args) throws InterruptedException {
		
		String ProductName = "ADIDAS ORIGINAL";
		WebDriver driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize(); // maximize the window
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions act = new Actions(driver);

		// login
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("selenium@ggg.com");
		driver.findElement(By.id("userPassword")).sendKeys("Hello123");
		driver.findElement(By.id("login")).click();

		// Order Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'mb-3')]")));
		List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));

		// Add product :
		WebElement MyProduct = products.stream()
				.filter(OneProduct -> OneProduct.findElement(By.xpath(".//h5/b")).getText().equals(ProductName))
				.findFirst().orElse(null);
		MyProduct.findElement(By.xpath(".//div[@class='card-body']/button[2]")).click();

		// Wait related to notification and pop-ups :
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		// Click on Cart
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();

		// CartConfirmation
		List<WebElement> CartProducts = driver.findElements(By.xpath("//ul[contains(@class,'cartWrap')]//h3"));
		Boolean result = CartProducts.stream()
				.anyMatch(CartProduct -> CartProduct.getText().equalsIgnoreCase(ProductName));
		Assert.assertTrue(result);

		// checkout from cart
		driver.findElement(By.xpath("//*[@class='totalRow']/button")).click();

		// PlaceOrder
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
		// act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select
		// Country']")), "India").build().perform();
		driver.findElement(By.xpath("//button[@type='button'][2]")).click();

		WebElement Placeorder = driver.findElement(By.cssSelector(".action__submit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Placeorder);

		Thread.sleep(3000);
		Placeorder.click();

		// Orderconfirmation
		String ConfirmationMsg = driver.findElement(By.className("hero-primary")).getText();
		Assert.assertTrue(ConfirmationMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

}
