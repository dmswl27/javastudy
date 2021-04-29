package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
/*파일이 없는경우*/

/**
 * @author eunji
 *
 */
public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("hello.txt");
			int data = fis.read();
			System.out.println(data);
		} catch (FileNotFoundException e) {
			System.out.println("error:" + e);			
		}catch (IOException e) {
			System.out.println("error:" + e);			
		}finally {
			try {
				if(fis != null) {
					fis.close();
					}
			}catch (IOException e) {
				System.out.println("error:" + e);
			}
		}

	}
	

}
