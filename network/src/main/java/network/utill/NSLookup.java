package network.utill;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {
	//도메인 주소 알아보는 방법 www.douzone.com ...

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				System.out.print(">>");
				String line = scanner.nextLine();
			
				if("exit".equals(line)) {
				break;
				}
				InetAddress[] inetAddresses = InetAddress.getAllByName(line);
				for(InetAddress inetAddress : inetAddresses) {
					System.out.println(line + ":" + inetAddress.getHostAddress());
				}
			}catch (UnknownHostException e) {
				System.out.println("unknown host");
			}
			
		}

	}

}
