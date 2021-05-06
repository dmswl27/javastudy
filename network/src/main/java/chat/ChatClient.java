package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = ChatServer.PORT;
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		try {
		   //1. 키보드 연결
			scanner = new Scanner(System.in);
		   //2. socket 생성
			socket = new Socket();
		   //3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
			log("connected");
		   //4. reader/writer 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter os = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
		   //5. join 프로토콜
		   System.out.print("닉네임>>" );
		   String nickname = scanner.nextLine();
		   os.println( "join:" + nickname );
		   

		   //6. ChatClientReceiveThread 시작

		   //7. 키보드 입력 처리
		   while(true) {
				//5. 키보드 입력 받기
				System.out.print(">");
				String line = scanner.nextLine();
				
				if("exit".equals(line)) {
					break;
				}
				
				//6. 데이터 쓰기
				os.println(line);
				
				//7. 데이터 읽기
				String data = br.readLine();
				if(data == null) {
					log("closed by server");
					break;
				}
				
				//8. 콘솔 출력
				System.out.println("<" + data);
			}
			
		} catch (SocketException e) {
			log("suddenly closed by server");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void log(String log) {
		System.out.println("[EchoClient] " + log);
		
	}

}
