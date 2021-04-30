package collection;
import java.util.Set;
import java.util.HashSet;

public class HashSetTest02 {

	public static void main(String[] args) {
		Set<Gugodan> s = new HashSet<>();
		
		s.add(new Gugodan(2,3));
		s.add(new Gugodan(9,9));
		s.add(new Gugodan(2,3));
		s.add(new Gugodan(3,2));
		
		for(Gugodan g : s) {
			System.out.println(g);
		}

	}

}
