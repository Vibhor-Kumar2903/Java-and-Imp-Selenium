package array;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorDemo {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add("vibhor");
		ll.add("tinku");
		ll.add("chini");
		ll.add("viku");
		ll.add("navin-Z");
		System.out.println(ll);
		
		ListIterator litr = ll.listIterator();
		while(litr.hasNext()) {
			String s = (String) litr.next();
			if (s.equals("doga")) {
				litr.remove();
			}else if(s.equals("navin-Z")){
				litr.add("shubbu");
			}else if(s.equalsIgnoreCase("viku")) {
				litr.set("calculative-doga");
			}
		}
		
		System.out.println(ll);
		
		
	}
}
