package assignmentJava;

public class MainCallerClass {

	public static void main(String[] args) {
		SuperClass supr = new SuperClass(); //superclass
		supr.print();
		
		SubClass sub = new SubClass(); //subclass
		sub.print();
		sub.calculate(5);	//overloaded method
		sub.calculate(4.5555, 8.4444);	//overloaded method
		
		EncapsulatedClass encap = new EncapsulatedClass(); //encapsulation 
		encap.setName("VIBHOR");
		System.out.println("\n Name : "+encap.getName());
		
		InterfaceBike inface = new ImplementationOfInterface(); //interface and implementation-class
		inface.apache();
		inface.bajaj();
		
		AbstractClass absc = new ImplementationOfAbstract(); // abstract and implementation class
		absc.onePlus();
		absc.apple();
	}
}