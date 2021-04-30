package chapter04;

public class WrapperClassTest {

	public static void main(String[] args) {
		Integer j = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		Integer j1 = 10;
		Integer j2 = 10;
		
		System.out.println(j1==j2);
		System.out.println(j==j1);
		
		//auto unboxing
		//int j3 = j1.intValue();
		int j3 = j1;

	}

}
