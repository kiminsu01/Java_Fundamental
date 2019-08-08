package java_20190808.file.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class FileServerThread implements Runnable {
	private Socket socket;
	public FileServerThread(Socket socket) { // 쓰레드를   Run 시키기 위해 socket 변수 생성
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		InputStream in = null;
		OutputStream out = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			in = socket.getInputStream();
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			String fileName = br.readLine();
			System.out.println("클라이언트가 요청한 파일 : "+fileName);
			
			fis = new FileInputStream("c:\\dev\\test\\"+fileName);// 서버의 로컬파일
			
			out = socket.getOutputStream();
			byte[] readBytes = new byte[1024*8];
			int readByteCount = 0;
			
			while((readByteCount = in.read(readBytes)) != -1) {
				out.write(readBytes,0,readByteCount);
			}
		
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) in.close();
				if (isr != null) isr.close();
				if (br != null) br.close();
				if (out != null) out.close();
				if (fis != null) fis.close();
				if (socket != null) socket.close();
			} catch (IOException e2) {
				// TODO: handle exception
		}
	}	

}
}
