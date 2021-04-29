package exception;

import java.io.IOError;
import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) throws MyException {
		
		try {
			MyClass myClass = new MyClass();
			myClass.denger();
		}catch(IOException e) {
			
		}

	}

}
