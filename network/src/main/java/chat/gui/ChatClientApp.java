package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import network.echo.EchoServer;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = ChatWindow.PORT;

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		 
      

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();
		
		
		 
		socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("connected");
			
			//4. IO Stream 받아오기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			//join
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		//join
		
		String line = "JOIN:OK";
		if("JOIN:OK".equals(line)) {
			new ChatWindow(name).show();
		}

		
	}

	private static void log(String log) {
		System.out.println(log);
		
	}
	

}
