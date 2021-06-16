package array;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationDemo {

	public static void main(String[] args) {
		Vector v = new Vector();
		for (char i = 'A'; i <= 'O'; i++) {
			v.addElement(i);
		} 
		
		System.out.println(v);
		Enumeration e = v.elements();
		
		while(e.hasMoreElements()) {
			Character C = (Character) e.nextElement();
			if (C%2==0) {
				System.out.print(C+",");
			}
		}
		System.out.println("\n"+v);
	}
}