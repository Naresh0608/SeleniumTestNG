package SeleniumFunctionalities;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddtoCart {
	
	@Test
	public void AddtoCart() throws InterruptedException {
		WebDriver driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize(); // maximize the window
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);

		// Input Data

		String[] InputVeggies = { "Brocolli", "Cucumber", "Carrot" };

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


}
