package java_20190806;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import bonus.Utility;

public class CrawlingThread extends Thread{
	private String coinName;
	private String fileName;
	
	public CrawlingThread(String coinName, String fileName) {//생성자에서 초기화
		this.coinName = coinName;
		this.fileName = fileName;
	}
	@Override
	public void run() {
		while(true) { //반복 시행 명령
			Document doc = null;
			String url = "https://coinmarketcap.com/currencies/"+coinName+"/historical-data/?start=20190101&end=20190806";
			// "+coinName+" 변수 생성
		
			try {
				doc = Jsoup.connect(url).get();
			
				/*}  catch (IOException e) {
					e.printStackTrace();
				}*/
			
				//System.out.println("Date\tOpen\tHigh\tLow\tClose\tVolume\tMarket Cap");
		
				Elements bodyElements = doc.select(".table-responsive .table tbody tr");// 자식이 있으면 elements(복수)
				// System.out.println(bodyElements.size());
		
				HSSFWorkbook workbook = new HSSFWorkbook();// 새 엑셀파일 생성
				HSSFSheet sheet = workbook.createSheet("새파일");//새 시트 생성
				HSSFRow row = null;
				HSSFCell cell = null;
		
		
				row = sheet.createRow(0);
				cell = row.createCell(0); 
				cell.setCellValue("Date");
				
				cell = row.createCell(1);
				cell.setCellValue("Open");
				
				cell = row.createCell(2);
				cell.setCellValue("High");
				
				cell = row.createCell(3);
				cell.setCellValue("Low");
				
				cell = row.createCell(4);
				cell.setCellValue("Close");
				
				cell = row.createCell(5);
				cell.setCellValue("Volume");
				
				cell = row.createCell(6);
				cell.setCellValue("Market Cap");
			
				for(int i = 0; i < bodyElements.size(); i++) {
					int index = 0;
					Element trElement = bodyElements.get(i);
					//Element dateElement = trElement.child(index++);
					
					String date = trElement.child(index++).text();
					//Element openElement = trElement.child(index++);
					date = Utility.getKoreanDate(date); //유틸리티 클래스 import
					String open = trElement.child(index++).text();
					String high = trElement.child(index++).text();
					String low = trElement.child(index++).text();
					String close = trElement.child(index++).text();
					String volume = trElement.child(index++).text();
					String marketCap = trElement.child(index++).text();
											
					row = sheet.createRow(i+1);
					cell = row.createCell(0);
					cell.setCellValue(date);
					
					cell = row.createCell(1);
					cell.setCellValue(open);
					
					cell = row.createCell(2);
					cell.setCellValue(high);
					
					cell = row.createCell(3);
					cell.setCellValue(low);
					
					cell = row.createCell(4);
					cell.setCellValue(close);
					
					cell = row.createCell(5);
					cell.setCellValue(volume);
					
					cell = row.createCell(6);
					cell.setCellValue(marketCap);
					
					//System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s%n",
					//		date,open,high,low,close,volume,marketCap);
				
				}
					//try {
								
					FileOutputStream fos = new FileOutputStream("c:\\dev\\test\\" + fileName); //파일생성
					workbook.write(fos);
			
					fos.close();
					workbook.close();
					System.out.println("성공...");
	
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				try { //while 블럭 닫기
					Thread.sleep(1000*60*60); // 1시간단위로 Running 상태의 쓰레드 실행
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
	}
