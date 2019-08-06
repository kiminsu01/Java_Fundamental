package java_20190806;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingDemo {

	public static void main(String[] args) {
		/*String url = "http://www.imbc.com/";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("성공...");
		
		Elements elements = doc.select(".con-wrap.notice-wrap");// 자식이 있으면 elements(복수)
		// ".con-wrap.notice-wrap"는 부모
		Elements noticeElements = elements.select("h3");
		String noticeTitle = noticeElements.text();
		System.out.println(noticeTitle);
		
		Elements liElements = elements.select(".notice-list li");//<class>.notice-list 아래 li만 크롤링
		for(int i=0;i<liElements.size();i++) {
			Element liElement = liElements.get(i);
			System.out.println(liElement.text());
		*/	
		
		String url = "https://sports.news.naver.com/kfootball/news/index.nhn";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("성공...");
		
		Elements elements = doc.select(".news_wrap");// 자식이 있으면 elements(복수)
		// ".con-wrap.notice-wrap"는 부모
		Elements noticeElements = elements.select("h3");
		String noticeTitle = noticeElements.text();
		System.out.println(noticeTitle);
		
		Elements liElements = elements.select(".news_wrap_list li");//<class>.notice-list 아래 li만 크롤링
		for(int i=0;i<liElements.size();i++) {
			Element liElement = liElements.get(i);
			System.out.println(liElement.text());
			
		}
	}
	}

