package java_20190807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionDemo {
	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://sports.news.naver.com/wbaseball/index.nhn");
		URLConnection urlCon = url.openConnection();
		
		String cacheControl = urlCon.getHeaderField("cache-control");
		String contentType = urlCon.getHeaderField("content-type");
		String date = urlCon.getHeaderField("date");
			
		System.out.println("cacheControl : " +cacheControl);
		System.out.println("contentType : " +contentType);
		System.out.println("date : " +date);
		
		InputStream is = url.openStream(); // html 페이지 소스정보
		InputStreamReader isr = new InputStreamReader (is);
		BufferedReader br = new BufferedReader(isr);
		String readLine = null;
		try {
			while((readLine = br.readLine()) !=null) {
				System.out.println(readLine);
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		/*while((readLine = br.readLine()) != null) {
			System.out.println(readLine);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		*/
			}
		}
		
	}

