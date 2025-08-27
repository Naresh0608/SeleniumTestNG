package Framework.SeleniumRevision.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Framework.SeleniumRevision.AbstractComponents.AbstractComponent;
//5th Page
public class OrderConfirmationPage extends AbstractComponent {

	WebDriver driver;

	public OrderConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(className = "hero-primary")
	WebElement ConfirmOrder;

	public String OrderConfirmationValidation() {

		String ConfirmationMsg = ConfirmOrder.getText();
		return ConfirmationMsg;

	}

}
