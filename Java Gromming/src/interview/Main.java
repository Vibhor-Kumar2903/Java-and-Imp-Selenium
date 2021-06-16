package interview;
// main class (caller class)
public class Main {
	public static void main(String[] args) {
		System.out.println("Main caller class..");
		
		Requirements r = new Requirements(); //superclass
		r.mediatek();
		r.tcs();
		
		UpdatedReqiurements ur = new UpdatedReqiurements();	//subclass
		ur.mediatek();
		ur.tcs();
		ur.tcs("Developer");
		
		Salary sl = new Salary();	//encapsulation
		sl.setTestSalary(20000);
		sl.setDevlopSalary(22000);
		
		System.out.println("\nTest engineer salary : "+sl.getTestSalary());
		System.out.println("Java developer salary : "+sl.getDevlopSalary());
		
		Policy pl = new GetPolicy();
		pl.policy();		
		pl.leaves();
	}
}
