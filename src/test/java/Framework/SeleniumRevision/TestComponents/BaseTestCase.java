package Framework.SeleniumRevision.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Framework.SeleniumRevision.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestCase {
	
	public WebDriver driver;
	public LandingPage Login;
	
	public WebDriver driverInitilazation() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Framework\\SeleniumRevision\\resources\\GlobalData.properties");
		prop.load(fis);
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			
			driver = WebDriverManager.chromedriver().create();
		}else if(BrowserName.equalsIgnoreCase("edge")) {
				
				//edgedriver declaration
			}	
			
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize(); // maximize the window
		
		return driver;
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage LoginPageObject() throws IOException {
		
		driver=driverInitilazation();
		Login = new LandingPage(driver);
		return Login;
		
		
	}
	
	public String GetScreesnhot(String TestCaseName,WebDriver driver) throws IOException {

		TakesScreenshot Ts = (TakesScreenshot) driver;
		File Source = Ts.getScreenshotAs(OutputType.FILE);
		File Destination = new File(System.getProperty("user.dir") + "//reports//" + TestCaseName + ".png");								
		FileUtils.copyFile(Source, Destination);
		return System.getProperty("user.dir") + "//reports//" + TestCaseName + ".png";

	}

	public List<HashMap<String, String>> GetJsonHashMapData(String Filepath) throws IOException {

		String JsonContent = FileUtils.readFileToString(new File(Filepath), StandardCharsets.UTF_8);

		// Convert Json File to list of Multiple Maps
		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(JsonContent,
				new TypeReference<List<HashMap<String, String>>>() {

				});

		return data;

	}

}
