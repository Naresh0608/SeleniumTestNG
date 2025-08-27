package SeleniumFunctionalities;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {
	
	
	@Test
	public void Tables() throws InterruptedException {
		
		WebDriver driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize(); // maximize the window

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// JavaScript Executor

		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("window.scrollBy(0,600)");
		Thread.sleep(5000);
		JS.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		// Table Steering :

		List<WebElement> AmountList = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody/tr/td[4]"));
		
		List<String> AmountValuesList = AmountList.stream().map(Amount -> Amount.getText())
				.collect(Collectors.toList());

		AmountValuesList.forEach(System.out::println);

		int sum = 0;

		for (int i = 0; i < AmountList.size(); i++) {

			String Amt = AmountValuesList.get(i);
			int Amount = Integer.parseInt(Amt);
			sum = sum + Amount;

		}
		
		System.out.println(sum);
		
		
	String TotalAmountSection = driver.findElement(By.className("totalAmount")).getText();
	String TotalAmountArray [] = TotalAmountSection.split(":");
	String TotalAmount = TotalAmountArray[1].trim();
		
	int uisum = Integer.parseInt(TotalAmount);
	System.out.println(uisum);
	
	Assert.assertEquals(sum, uisum);

	}

}
