package Framework.SeleniumRevision.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.SeleniumRevision.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	//1st Page
	//Each POC Constructor gets executed from Object creation In Test Cases ,and methods needs to be called through Object
	
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement UserEmail;
	@FindBy(id = "userPassword")
	WebElement UserPassword;
	@FindBy(id = "login")
	WebElement LoginBtn;
	@FindBy(xpath = "//div[contains(@class,'ng-trigger-flyInOut')]")
	WebElement ErrorMsgWebElement;
	
	
	public ProductCatalogue LoginApplication(String Email, String Password) {
		
		goTo();
		UserEmail.sendKeys(Email);
		UserPassword.sendKeys(Password);
		LoginBtn.click();
		ProductCatalogue Prod = new ProductCatalogue(driver);
		return Prod;
	}

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String ErrorMsgValidation() {
		
		waitforWebElementtoAppear(ErrorMsgWebElement);
		String ErrorMsg = ErrorMsgWebElement.getText();
		return ErrorMsg;
		
	}

}
