package JavaInheritance;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class EW {
	
	public void Breed() {
		
		System.out.println("I am EW API");
	}
	
	@BeforeMethod
	public void BeforeM() {
		
		System.out.println("Before Method Execute First");

	}

	
	@AfterMethod
	public void AfterM() {
		
		System.out.println("After Method Execute Last");

	}


}
