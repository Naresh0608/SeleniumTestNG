package JavaInheritance;

public class Multiplication {
	
	int a;
	
	public Multiplication(int a) {
	//constructor should not have return type
	//purpose is to convert value from test case to class variable and use in methods
	this.a=a;
	
		
	}


public int Multiplyby2() {
	
	a = a*2;
	return a;
}


}
