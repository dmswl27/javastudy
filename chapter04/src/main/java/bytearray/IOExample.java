package bytearray;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import javax.print.DocFlavor.INPUT_STREAM;

public class IOExample {

	public static void main(String[] args)throws IOException {
		byte[] src = {1,2,3,4};
		
		InputStream is = new ByteArrayInputStream(src);		
		OutputStream os =  new ByteArrayOutputStream();
		
		int data = -1;
		
		while((data = is.read()) != -1) {
			os.write(data);
		}
		byte[] dest = ((ByteArrayOutputStream)os).toByteArray();
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(dest));
		

	}

}
