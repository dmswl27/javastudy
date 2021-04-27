package prob5;

public class Prob5 {
		
	public static void main(String[] args) {
		for(int i=1; i<=99; i++) { 
		      int first = i / 10; 
		      int second = i % 10; 
		      int cnt = 0; 
		      if(first ==3 || first == 6 || first == 9) cnt++; 
		      if(second ==3 || second == 6 || second == 9) cnt++; 
		      if(cnt == 2)  
		      System.out.println(i+" 짝짝"); 
		      else if(cnt == 1) 
		      System.out.println(i+" 짝"); 
		   } 
	}
}
