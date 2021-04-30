package prob01;

public class Printer {
//	public void println(int println) {
//		System.out.println(println);
//	}
//	public void println(boolean println) {
//		System.out.println(println);
//	}
//	public void println(double println) {
//		System.out.println(println);
//	}
//	public void println(String println) {
//		System.out.println(println);
//	}
//
//	public <T> void println(T t) {
//		System.out.println(t);
//	}

	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.print(t);
			System.out.print(" ");
		}
		System.out.print("\n");
	}
	
	public int sum(Integer... nums) {
		Integer sum = 0;
		for(Integer i : nums) {
			sum += i;
		}
		return sum;
	}
}
