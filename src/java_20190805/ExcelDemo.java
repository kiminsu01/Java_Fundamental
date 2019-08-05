package java_20190805;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
// jar download => https://www.apache.org/dyn/closer.lua/poi/release/bin/poi-bin-4.1.0-20190412.zip
// 다운받은후에 압축 해제후 6개의 jar파일 클래스 패스에 추가하기
public class ExcelDemo {
	public static void main(String[] args) {
		HSSFWorkbook workbook = new HSSFWorkbook();// 새 엑셀파일 생성
		HSSFSheet sheet = workbook.createSheet("새파일");//새 시트 생성
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("테스트 데이터(0,0)");
		
		cell = row.createCell(1);
		cell.setCellValue("테스트 데이터(0,1)");
		cell = row.createCell(2);
		cell.setCellValue("테스트 데이터(0,2)");
		
		row = sheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue("테스트 데이터(1,0)");
		
		cell = row.createCell(1);
		cell.setCellValue("테스트 데이터(1,1)");
		cell = row.createCell(2);
		cell.setCellValue("테스트 데이터(1,2)");
		
		row = sheet.createRow(2);
		cell = row.createCell(0);
		cell.setCellValue("테스트 데이터(2,0)");
		
		cell = row.createCell(1);
		cell.setCellValue("테스트 데이터(2,1)");
		cell = row.createCell(2);
		cell.setCellValue("테스트 데이터(2,2)");
		
		try {
			FileOutputStream fos = new FileOutputStream(
					"c:\\dev\\test\\test.xls");
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
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
