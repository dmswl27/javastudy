package collection;

import java.util.List;
import java.util.Vector;
import java.util.Iterator;


public class VectorTest02 {

	public static void main(String[] args) {
		List<String> list = new Vector<>();
		
		list.add("둘리");
		list.add("마이틀");
		list.add("또치");
		
		int count = list.size();
		for(int i=0;i<count;i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		list.remove(2);
		
		//순회2
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
			
		}
		
		for(String s : list) {
			System.out.println(s);
		}

	}

}
