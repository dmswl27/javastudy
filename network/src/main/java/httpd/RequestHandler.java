package httpd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class RequestHandler extends Thread {
//	private static final String DOCUMENTROOT = "./webapp";
	private static String DOCUMENTROOT = "";
	private Socket socket;
	static {
		DOCUMENTROOT = RequestHandler.class.getClass().getResource("./webapp").getPath();
		System.out.println(DOCUMENTROOT);
	}
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream os = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			
			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
			
			String request = null;
			
			while(true) {
				String line = br.readLine();
				
				// 브라우저가 연결을 끊으면,
				if(line == null) {
					break;
				}
				
				// Request Header만 읽음
				if("".equals(line)) {
					break;
				}
				
				// 첫 번째 라인만 처리
				if(request == null) {
					request = line;
					break;
				}
			}
			
			// 요청 처리
			String[] tokens = request.split(" ");
			if("GET".equals(tokens[0])) {
				consoleLog("request:" + tokens[1]);
				responseStaticResource(os, tokens[1], tokens[2]);
				
				System.out.println("궁금 : " +tokens[0] + "  "+ tokens[1] + "    "+ tokens[2]);
			} else { // methods: POST, PUT, DELETE, HEAD, CONNECT
				/* Simple Http Server 에서는 무시 */	
				File file = new File(DOCUMENTROOT + tokens[1]);
				String contentType = Files.probeContentType(file.toPath());	
				FileInputStream fin = new FileInputStream("./webapp/error/400.html");
	    
			    os.write((tokens[2] + " 400 Bas Request\r\n").getBytes("UTF-8"));
				os.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes( "UTF-8" ));
				os.write("\r\n".getBytes() );
			    while(true){
		        int data = fin.read();
		        if(data == -1) break;
		        os.write(data);
		        }
				// 응답 예시
				// HTTP/1.1 400 Bas Request\r\n
				// Content-Type:text/html; charset=utf-8\r\n
				// \r\n
				// HTML 에러 문서 (./webapp/error/400.html)

				
				// response400Error(os, token[1], token[2]);
			}
			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
			// os.write( "HTTP/1.1 200 OK\r\n".getBytes( "UTF-8" ) );
			// os.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
			// os.write( "\r\n".getBytes() );
			// os.write( "<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) );
		} catch(Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}

	private void responseStaticResource(
		OutputStream os,
		String url,
		String protocol) throws IOException {
		
		System.out.println("너무 궁금 " +os + "    " + url + "   " + protocol);
		
		// welcome file set
		if("/".equals(url)) {
			url = "/index.html";
		}
		
		File file = new File(DOCUMENTROOT + url);
		if(file.exists() == false) {
			String contentType = Files.probeContentType(file.toPath());	
			
			FileInputStream fin = new FileInputStream("./webapp/error/404.html");
    
		    os.write((protocol + " 404 File Not Found\r\n").getBytes("UTF-8"));
			os.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes( "UTF-8" ));
			os.write("\r\n".getBytes() );
		    while(true){
	        int data = fin.read();
	        if(data == -1) break;
	        os.write(data);
	        }
					  
			//os.write(os, url, protocol);
			// 응답 예시
			// HTTP/1.1 404 File Not Found\r\n
			// Content-Type:text/html; charset=utf-8\r\n
			// \r\n
			// HTML 에러 문서 (./webapp/error/404.html)
			
			// response404Error(os, url, protocol);
			return;
		}
		
		// nio
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());		
		os.write((protocol + " 200 OK\r\n").getBytes("UTF-8"));
		os.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes( "UTF-8" ));
		os.write("\r\n".getBytes() );
		os.write(body);
	}

	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
}
