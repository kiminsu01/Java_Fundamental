package java_20190802;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

public class NaverCafeScaningDemo {
	public static void main(String[] args) throws IOException {
		
		
		URL url = new URL(
				"https://blog.naver.com/PostView.nhn?blogId=harloveysj&logNo=221460034406&redirect=Dlog&widgetTypeCall=true&directAccess=false");
		InputStream is = url.openStream();
		// 1. InputStream을 InputStreamReader로 바꾼다.
		// 2. InputStreamReader을 BufferedReader 바꾼다.(stream chaining)
		// 3. BufferedReader로 읽은 정보(html)를
		// c:\dev\test\navercafe.html 파일 저장한다.

		InputStreamReader ir = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		ir = new InputStreamReader(is);
		br = new BufferedReader(ir);

		fw = new FileWriter("c:\\dev\\test\\navercafe.html");
		bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw,true);

		String readLine = null;
		while ((readLine = br.readLine()) != null) {
			//System.out.println(readLine);
			pw.println(readLine);
		}
		
		
		//https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile23.uf.tistory.com%2Fimage%2F12475D134AA7786D07E441
		/*
		URL url = new URL(
				"https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile23.uf.tistory.com%2Fimage%2F12475D134AA7786D07E441");
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("c:\\dev\\test\\sung.jpg");
		int readByteCount = 0;
		byte[] readBytes = new byte[1024*8];
		while((readByteCount = is.read(readBytes)) != -1) {
			fos.write(readBytes,0,readByteCount);
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
