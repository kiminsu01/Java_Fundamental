package java_20190808.unicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UnicastServerThread implements Runnable {
	private Socket socket; 
		
	public UnicastServerThread (Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			boolean isStop = false; // 멈출래? 아니!
			while (!isStop) { //  멈추지 말고 돌아
				// 정상메세지 => id : message
				// 종료 메세지 =>  shutdown
				String readLine = br.readLine();
				System.out.println(readLine);
				if(readLine.equals("shutdown")) {
					bw.write("shutdown\n");
					bw.flush();
					isStop = true; // 이제 멈출께~!
				}else {
					bw.write(readLine +"\n");
					bw.flush();
					}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("비정상적으로 종료하셨습니다.");
			
		} finally {
			try {
				if(bw != null) bw.close();
				if(br != null) br.close();
			} catch (IOException e2) {
				// TODO: handle exception
		}
		}
	}		
}
