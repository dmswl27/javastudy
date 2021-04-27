package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		char[] c1 = str.toCharArray();
		for (int i=0;i<str.length()/2;i++){
			char temp = c1[i];
			c1[i] = c1[str.length()-i-1];
			c1[str.length()-i-1] = temp;
		}
			/*String temp = "캐릭터 변환하기";

		/* 코드를 완성합니다 */
		return c1;
	}

	public static void printCharArray(char[] array){
		System.out.println( array );
	}
}