package JavaInheritance;

public class Addition extends Multiplication {
	
	int a;
	
public Addition(int a) {
	//constructor should not have return type
	//purpose is to convert value from test case to class variable and use in methods
	super(a);
	this.a=a;
	
		
	}


public int Addby50() {
	
	a = a + 50;
	return a;
}

public int Addby30() {
	
	a = a + 30;
	return a;
}


}
