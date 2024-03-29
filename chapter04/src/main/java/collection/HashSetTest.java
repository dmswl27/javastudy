package collection;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		String s1 = new String("도우넛");
		String s2 = new String("도우넛");
		
		s.add("둘리");
		s.add("마이콜");
		s.add("또치");
		s.add(s1);
		
		System.out.println(s.size());
		System.out.println(s.contains("둘리"));
		
		//순회1
		
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
		
	}

}
