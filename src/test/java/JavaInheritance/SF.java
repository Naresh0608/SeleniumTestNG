package JavaInheritance;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SF extends EW {
	
		
	
	@Test
	public void CallEW(){
		int a = 10;
		Addition add = new Addition(a);
		Division div = new Division(a);
		Breed();
		int w = add.Addby50();
		System.out.println(w);
		int x = add.Addby30();
		System.out.println(x);
		int y = add.Multiplyby2();
		System.out.println(y);
		int z = div.Divideby2();
		System.out.println(z);


	}
	


	
}
