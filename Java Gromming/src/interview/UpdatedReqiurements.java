package interview;
// super class 
public class UpdatedReqiurements extends Requirements {
	@Override
	public void mediatek() { //overridden method
		System.out.println("\n25 vacancies");
		System.out.println("Throughtout 70% in Academics and B.Tech ");
		System.out.println("Manual testing");
		System.out.println("Java");
	}	
	public void tcs() { //overload method
		System.out.println("\n07 vacancies"); 
		System.out.println("Throughtout 60% in Academics and B.Tech ");
		System.out.println("Manual testing");
		System.out.println("Java");
		System.out.println("Selenium (Automation Testing)");
	}	
	public void tcs(String s) {	//overload method
		System.out.println("\nVacancy for : "+s);
		System.out.println("10 vacancies");
		System.out.println("Throughtout 65% in Academics and B.Tech ");
		System.out.println("Java Developer");
		System.out.println("Advance Java");
		System.out.println("Spring boot");
	}	
}