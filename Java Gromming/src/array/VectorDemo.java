package array;

import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
	Vector v = new Vector();
	System.out.println(v.capacity());
	v.add('a');
	v.add("Vibhor");
	v.add("saurabh");
	v.add("tinku");
	v.add(8920097461l);
	v.add(2500);
	v.add(2.5f);
	v.add(29.29);
	System.out.println(v.capacity());
	System.out.println(v);
	v.remove(0);
	System.out.println(v);	
	}
}