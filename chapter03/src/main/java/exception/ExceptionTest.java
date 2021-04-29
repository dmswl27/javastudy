package exception;
/**
 * 
 * @author eunji
 * 
 * try~catch~finaly
 */
import java.io.UncheckedIOException;

import com.sun.org.apache.bcel.internal.classfile.Code;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 0;
	    int b = 0-a;                       
	    System.out.println("Some Codes...1");
	    try {
	    	System.out.println("Some Codes...2"); 
	    	int result = (1+2+3)/b;
	    	System.out.println("some Codes...3"); 

	    } catch (ArithmeticException e) {
	    	// 예외 처리 
	    	// 1.사과
	    	System.out.println("미안합니다....");
	    	// 2.로킹 
	    	System.out.println("error"+e); 
	    	// 3.정상 종료
	    	return;
	    }//catch (UncheckedIOException e) {x} 
	    //catch (ckedIOException e) {} (x)
	    finally {
	    	/* 자원 정리*/
	    	//
	    	System.out.println("some Codes...final(자원정리)"); 
	    }
	}

}
