package java_20190807.echo.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;

public class EchoServer {
	private String ip;
	private int port; 
	private ServerSocket serverSocket;
	public EchoServer(int port) {
		this.ip = ip;
		this.port = port;
		
	}
	public void run() {  // run 메소드 
		Socket socket = null;
		ServerSocket serverSocket = null;
		try {
			//1. ServerSocket를 생성한다.
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		while(true) {
			System.out.println("클라이언트 접속을 기다리고 있습니다.");
			try {
				//1.ServerSocket을 생성한다. 
				// 클라이언트가 접속하면 클라이언트와 통신 할 수 있는 Socket 객체를 생성해줌
				//2. 서버소켓으로 클라이언트의 접속을 기다린다. 
				
				serverSocket = new ServerSocket(3000); // 포트 번호 3000으로 설정
				//5. 클라이언트와 통신할 수 있는 소켓을 생성한다.
				InetAddress i = socket.getInetAddress();
				String ip = i.getHostAddress();
				System.out.println("클라이언트가...");
				
				//7. 소켓으로 입력 스트림을 생성한 후에 클라이언트의 메세지를 읽는다.
				//	Socket socket = serverSocket.accept();
				//	InetAddress i= socket.getInetAddress();
				//	String ip = i.getHostAddress();
				System.out.println("클라이언트가 접속했습니다. IP:" +ip);
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				String readLine = br.readLine();
				System.out.println(readLine);
				
				//8. 소켓으로 출력 스트림을 생성한 후에 클라이언트에게 메세지를 보낸다.
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out);
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write("안녕하세요? 저는 성영한입니다.");
				bw.newLine();
				bw.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//public static void main(String[] args) {
	//	new EchoServer(3000).run();
	}

