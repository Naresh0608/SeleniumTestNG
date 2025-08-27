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

public class StreamsTable {
	
	@Test
	public void CartPage() throws InterruptedException {
		WebDriver driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize(); // maximize the window
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Input Data
		String InputVeggies = "Brinjal";
		StreamsTable E2 = new StreamsTable();
		E2.SortingOrder(driver);
	
		// Tc 2
		// Get The Price Step
	//	driver.findElement(By.xpath("//span[@class='sort-icon sort-ascending']")).click();
		List<WebElement> VeggiesList = driver.findElements(By.xpath("//tbody/tr/td[1]"));

		List<String> PriceofItem = VeggiesList.stream().filter(Veggies->Veggies.getText().contains(InputVeggies))
				.map(Veggies->GetthePrice(Veggies)).collect(Collectors.toList());

		PriceofItem.forEach(System.out::println);

	}

	private static String GetthePrice(WebElement Veggies) {
		// TODO Auto-generated method stub
		WebElement MyItemPrice = Veggies.findElement(By.xpath("following-sibling::td[1]"));
		String Price = MyItemPrice.getText();
		return Price;
		
	}

	public void SortingOrder(WebDriver driver) {
		// tc 1
		// Click on Sort Button
		// Capture Veggies in Column in list
		// Use Sorted Function on this list
		// Compare both the lists

		driver.findElement(By.xpath("//span[@class='sort-icon sort-descending']")).click();
		List<WebElement> VeggiesList = driver.findElements(By.xpath("//tbody/tr/td[1]"));

		List<String> VeggieNames = VeggiesList.stream().map(s -> s.getText()).collect(Collectors.toList());
		VeggieNames.forEach(System.out::println);

		List<String> SortedVeggieNames = VeggieNames.stream().sorted().collect(Collectors.toList());
		SortedVeggieNames.forEach(System.out::println);

		Assert.assertTrue(VeggieNames.equals(SortedVeggieNames));

	}



}
