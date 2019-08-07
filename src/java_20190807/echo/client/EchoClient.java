package java_20190807.echo.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	private String ip;
	private int port;
	
	public EchoClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	public void run() {
		
		Socket socket = null;
		OutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;	
		
		try { 
			// ip와 port로 서버와 접석을 시도한다. 
			// 3. 소켓을 생성한다.
			// 4. 서버와 연결을 한다. 
			socket = new Socket (ip, port);
			
			//6. 소켓을 출력스트림을 생성한 후에 서버에게 메세지를 보낸다. 
			out = socket.getOutputStream();
			osw = new OutputStreamWriter(out);
			bw = new BufferedWriter(osw);
			bw.write("안녕하세요? 저는 성영한입니다.");
			bw.newLine(); //개행
			bw.flush(); 
			
			// 9. 소켓으로 입력스트림을 생성한 후에 서버에서 보낸 메세지를 읽는다.

			in = socket.getInputStream();
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			String readLine = br.readLine();
			System.out.println(readLine);
			
		} catch (UnknownHostException e) {
			System.out.println("서버주소가 잘못되었습니다.");
			
		} catch (IOException e) {
			System.out.println("서버의 전원이 연결되지 않았습니다.");	
			
		} finally {
			try {
				if(out != null) out.close();
				if(osw != null) osw.close();
				if(bw != null) br.close();
				if(in != null) in.close();
				if(isr != null) isr.close();
				if(br != null) br.close();
				if(socket != null) socket.close();
			}catch (IOException e2) {
							
			}
		}
		}
	public static void main(String[] args) {
		new EchoClient ("192.168.0.52", 3000).run();
	}
	}

