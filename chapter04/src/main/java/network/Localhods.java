package network;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhods {
	//로컬 호스트의 ip주소 알아보고 숫자로 변경하는 방법

	public static void main(String[] args) {
		 try {
			InetAddress inetAddress = Inet4Address.getLocalHost();
			
			String hostAddress = inetAddress.getHostAddress();
			String hostname = inetAddress.getHostName();			
			System.out.println(hostname);
			System.out.println(hostAddress);
			
			byte[] addresses = inetAddress.getAddress();
			for(byte address : addresses) {
				System.out.print(address & 0x000000ff); 
				System.out.print(".");
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
