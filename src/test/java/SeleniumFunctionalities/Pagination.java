package SeleniumFunctionalities;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {

	@Test
	public void CartPage() throws InterruptedException {
		WebDriver driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize(); // maximize the window

		// Input Data
		String InputVeggies = "Rice";

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//span[@class='sort-icon sort-descending']")).click();
	
		List<String> PriceofItem;

		do {
			List<WebElement> VeggiesList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			
			PriceofItem = VeggiesList.stream().filter(Veggies -> Veggies.getText().contains(InputVeggies))
					.map(Veggies -> GetthePrice(Veggies)).collect(Collectors.toList());

			PriceofItem.forEach(System.out::println);

			if (PriceofItem.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();

			}

		} while (PriceofItem.size() < 1);

	}

	private static String GetthePrice(WebElement Veggies) {
		// TODO Auto-generated method stub
		WebElement MyItemPrice = Veggies.findElement(By.xpath("following-sibling::td[1]"));
		String Price = MyItemPrice.getText();
		return Price;

	}

}
