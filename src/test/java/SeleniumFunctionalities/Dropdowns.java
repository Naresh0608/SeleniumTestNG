package SeleniumFunctionalities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdowns {
	
	
	@Test
	public void Tables() throws InterruptedException {
		
		WebDriver driver =WebDriverManager.chromedriver().create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize(); // maximize the window
		driver.get("https://www.leafground.com/select.xhtml;jsessionid=node013fsibykytj7iq2ei29yzl8kq7649735.node0");
		
		
		//Select Value
		WebElement ToolDropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		
		Select Sel = new Select(ToolDropdown);
	//	Sel.selectByIndex(1);
	 	Sel.selectByVisibleText("Selenium");
	 	String SelectedValue = Sel.getFirstSelectedOption().getText();
	 	System.out.println(SelectedValue);
		Thread.sleep(5000);
	}

}
