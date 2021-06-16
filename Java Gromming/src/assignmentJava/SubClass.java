package assignmentJava;

public class SubClass extends SuperClass{
	
	@Override
	public void print() {
		System.out.println("\n print() method of sub class..");
	}
	
	public void calculate(int x) {
		System.out.println("\n calculate() method of sub class to calculate square..");
		int c = x*x;
		System.out.println(" Square of "+x+" is "+c);
	}
	
	public void calculate(double x, double y) {
		System.out.println("\n Overloaded calculate() method of sub class to calculate multiplication..");
		double c = x*y;
		System.out.println(" Multiplication of "+x+" and "+y+" is "+c);
	}
}