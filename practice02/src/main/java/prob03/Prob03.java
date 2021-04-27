package prob03;

public class Prob03 {
	public static void main(String args[]) {
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };
		printCharArray(c);  // 원래 배열 원소 출력	 
		replaceSpace(c);    // 공백 문자 바꾸기
		printCharArray(c);  // 수정된 배열 원소 출력
	}
		public static void replaceSpace(char a[]) {
	    	for(int i =0;i<a.length;i++) 
	    		if(a[i] == ' ' ) 
	    			a[i]= ',';
	    		
	    	
	    }
	     
	    public static void printCharArray(char a[]) {
	    	System.out.println(a);
	    }
		/*// 원래 배열 원소 출력
		System.out.println(c.toString());

		// 공백 문자 바꾸기
		c = c.replace(" ",",");

		// 수정된 배열 원소 출력
		System.out.println(CharArray(c));
		*/
	

}
