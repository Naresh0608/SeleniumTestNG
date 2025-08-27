package SeleniumFunctionalities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	
	
@Test
public void Tables() throws InterruptedException {

		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize(); // maximize the window
		driver.get("https://letcode.in/table");

		// WebTablesRowCount
		WebElement MyTable = driver.findElement(By.id("simpletable"));

		List<WebElement> AllRows = MyTable.findElements(By.xpath("//table[@id='simpletable']/tbody/tr"));
		int RowCount = AllRows.size();
		System.out.println(RowCount);

		// Print Header Names

		List<WebElement> Headers = MyTable.findElements(By.tagName("th"));
		for (WebElement Header : Headers) {

			String HeaderName = Header.getText();
			System.out.println(HeaderName);

		}

		// Print First Names of the Table
		List<WebElement> FirstNames = MyTable.findElements(By.xpath("//table[@id='simpletable']//tr/td[1]"));
		for (WebElement FirstName : FirstNames) {

			String FName = FirstName.getText();
			System.out.println(FName);

		}

		// Fetch second column based on Constraint in first column
		List<WebElement> SecondNames = MyTable.findElements(By.xpath("//table[@id='simpletable']//tr/td[2]"));

		for (int i = 0; i < FirstNames.size(); i++) {
			if (FirstNames.get(i).getText().equalsIgnoreCase("Yashwanth")) {

				String SecondName = SecondNames.get(i).getText();
				System.out.println(SecondName);

				// table[@id='simpletable']/tbody/tr/td[4]/input

				break;

			}

		}

		// Embedded Cell based on constraint value in first column
		List<WebElement> Checkboxes = driver.findElements(By.xpath("//table[@id='simpletable']/tbody/tr/td[4]/input"));

		for (int i = 0; i < FirstNames.size(); i++) {
			if (FirstNames.get(i).getText().equalsIgnoreCase("Yashwanth")) {

				Checkboxes.get(i).click();
				break;

			}

		}

		//// Print All cells in one Row
		// List<WebElement> AllRows =
		//// MyTable.findElements(By.xpath("//table[@id='simpletable']/tbody/tr")); == 3
		//// Rows

		for (WebElement OneRow : AllRows) {

			String RowValue = OneRow.getText();

			System.out.println(RowValue);

		}

	}

}