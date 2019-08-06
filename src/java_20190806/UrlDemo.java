package java_20190806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://sports.news.naver.com/wbaseball/news/read.nhn?oid=224&aid=0000004260#content"); //#content는 레퍼런스
		
		String protocol = url.getProtocol();
		String host = url.getHost();
		int port = url.getPort(); // 디스플레이상 없으면 -1로 출력됨.
		//int port = url.getDefaultPort(); https의 포트번호
		String path = url.getPath();
		String query = url.getQuery();
		String ref = url.getRef();
		System.out.println("protocol :"+protocol);
		System.out.println("host :"+host);
		System.out.println("port :"+port);
		System.out.println("path :"+path);
		System.out.println("query :"+query);
		System.out.println("ref :"+ref);
		
		InputStream is = url.openStream(); // html 페이지 소스정보
		InputStreamReader isr = new InputStreamReader (is);
		BufferedReader br = new BufferedReader(isr);
		String readLine = null;
		/*try {
			while((readLine = br.readLine()) !=null) {
				System.out.println(readLine);
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		*/
		while((readLine = br.readLine()) != null) {
			System.out.println(readLine);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			}
		}
	}
}
	
	
	
