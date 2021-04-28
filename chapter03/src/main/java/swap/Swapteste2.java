package swap;

public class Swapteste2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =10;
		int m = 20;
		
		System.out.println(n+":"+m);
		swap(n,m);
		System.out.println(n+":"+m);

	}
	public static void swap(int p, int q) {
		int temp = p;
		p=q;
		q=temp;
	}
		

}
