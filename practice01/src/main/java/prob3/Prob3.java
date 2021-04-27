package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요:");
		int num =scanner.nextInt();
		int total = 0;
		if(num%2==0) {
			for(int i=2;i<=num;i=i+2) {
				
				total+=i;
			}
			System.out.println("결과 값 : "+total);
		}
		if(num%2==1) {
			for(int i=1;i<=num;i=i+2) {
				total+=i;
			}
			System.out.println("결과 값 : "+total);
		}
	scanner.close();
		/* 코드 작성 */
		
	}
}
