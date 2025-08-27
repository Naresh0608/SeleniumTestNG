package SeleniumFunctionalities;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndtoEndShoppingCart {
	
	@Test
	public void CartPage() throws InterruptedException {
		WebDriver driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize(); // maximize the window
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);

		// Input Data
		String[] InputVeggies = { "Brocolli", "Cucumber", "Carrot" };
		EndtoEndShoppingCart E2 = new EndtoEndShoppingCart();
		E2.AddtoCart(driver, InputVeggies);
		E2.CheckoutCart(driver);

	}
	
	
	public void AddtoCart(WebDriver driver, String[] InputVeggies) {

		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		List<WebElement> AddtoCart = driver.findElements(By.xpath("//div[@class='product-action']/button"));
		List InputVeggiesList = Arrays.asList(InputVeggies);

		int j = 0;
		for (int i = 0; i < products.size(); i++) {

			String name = products.get(i).getText();
			String ItemsFullName[] = name.split("-");
			String ItemName = ItemsFullName[0].trim();

			if (InputVeggiesList.contains(ItemName)) {

				AddtoCart.get(i).click();
				j++;

				if (j == InputVeggiesList.size()) {

					break;
				}

			}

		}

	}
	
	public void CheckoutCart(WebDriver driver) throws InterruptedException {
		//proceed to cart
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//Button[text()='PROCEED TO CHECKOUT']")).click();
		
		//DiscountCode Validation		
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		
	
		//ExplicitWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		
	}

}
