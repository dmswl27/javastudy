package chat.gui;
import java.awt.BorderLayout;
import java.net.ConnectException;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatWindow {
	public static final int PORT = 9000;

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String nickname  ) {
		frame = new Frame(nickname);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		
	}
	/*
	 * UI 출력 건들지마
	 * */

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER)
					sendMessage();
			}
			
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
	
	/*
	 * 2. IOSTREAM 생성
	 * */
	Socket socket = null; 
    try { 
         
        socket = new Socket("0.0.0.0", PORT); // 소켓을 생성하여 연결을 요청한다.
         System.out.println("서버에 연결되었습니다.");

        // 메시지 전송용 Thread 생성 
         ClientSender sender = new ClientSender(socket);

         /*
     	 * 3. Chat Client Thread 생성 (receiver Thread)
     	 * */
     	
        // 메시지 수신용 Thread 생성 
        Thread receiver = new Thread(new ClientReceiver(socket));

        receiver.start(); 
    } catch (ConnectException ce) { 
        ce.printStackTrace(); 
    } catch (IOException e) {
    	e.printStackTrace();
    }
    } 

	
	private void sendMessage() {
		String message = textField.getText();
		System.out.println("프로토콜 구현: " + message);
		
		textField.setText("");
		textField.requestFocus();
	}
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	private class ChatClientTread extends Thread{
		@Override
		public void run() {
			Socket socket = null;
			try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                while(true) {
                    String msg = br.readLine();
                    textArea.append(msg);
                    textArea.append("\n");
                }
			}catch (IOException e) {
                e.printStackTrace();
            }
		}
//		public void finish() {
//			System.out.println("방 나가기");
//			System.out.println("소켓 닫기");
//			System.exit(0);
//		}
	}
	class ClientSender { 
        Socket socket; 
        DataOutputStream out;
		private String frame; 

        ClientSender(Socket socket) { 
            this.socket = socket; 

            try { 
                this.out = new DataOutputStream(socket.getOutputStream());
 
                // 시작하자 마자, 자신의 대화명을 서버로 전송 
                if (out != null) {
                     out.writeUTF(frame); 
                } 

            } catch (Exception e) {
            	e.printStackTrace();
            } 
        } 

        public void buttonSend(String message) {
             if (out != null) {
                 try { 
                    // 키보드로 입력받은 데이터를 서버로 전송
                     out.writeUTF("[" + frame + "] " + message);
                 } catch (IOException e) { 
                	 e.printStackTrace();
                } 
            } 
        } 
    } 

    // 메시지 수신용 Thread 
    class ClientReceiver implements Runnable {
        Socket socket; 
        DataInputStream in; 

        // 생성자 
        ClientReceiver(Socket socket) { 
            this.socket = socket; 

            try { 
                // 서버로 부터 데이터를 받을 수 있도록 DataInputStream 생성
                 this.in = new DataInputStream(socket.getInputStream());
             } catch (IOException e) { 
            	 e.printStackTrace();
            } 
        } 

        public void run() {
             while (in != null) { 
                try { 
                    // 서버로 부터 전송되는 데이터를 출력 
                    ChatWindow.this.setMessage(in.readUTF());
                 } catch (IOException e) { 
                	 e.printStackTrace();
                } 
            } 
        } 
    }

	public void setMessage(String readUTF) {
		System.out.println("[" + frame + "] " + readUTF); 
		
	} 



}
