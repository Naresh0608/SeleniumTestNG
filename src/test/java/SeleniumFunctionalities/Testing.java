package SeleniumFunctionalities;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {
	
	@Test
	public void AddtoCart() throws InterruptedException {
		
		
		WebDriver driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize(); // maximize the window
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);

		// Input Data

		String InputVeggies = "Carrot - 1 Kg";

	List<WebElement> Allproducts = driver.findElements(By.xpath("//div[@class='product']"));
		
//	WebElement Carrot =	Allproducts.stream().filter(Product->Product.findElement(By.cssSelector(".product-name")).getText()
	//		.equals(InputVeggies)).findFirst().orElse(null);
	
//	System.out.println(Carrot.getText());
	
//	Carrot.findElement(By.cssSelector("product-action")).click();
	
	
	
	WebElement Carrot = Allproducts.stream().filter(Product->Product.findElement(By.xpath(".//h4[@class='product-name']")).getText()
		.equals(InputVeggies)).findFirst().orElse(null);
	
//	System.out.println(Carrot.getText());
	
	Carrot.findElement(By.xpath(".//div[@class='product-action']/button")).click();
	
	
	
//	WebElement Carrot = Allproducts.stream().filter(Product->Product.findElement(By.className("product-name")).getText()
//	.equals(InputVeggies)).findFirst().orElse(null);

//	System.out.println(Carrot.getText());	
	
	
	
		}



	
}
