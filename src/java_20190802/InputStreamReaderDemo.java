package java_20190802;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class InputStreamReaderDemo {
	public static void main(String[] args) {
		/*
		FileOutputStream fos = null;
		System.out.print("�엯�젰�븯�꽭�슂>");
		InputStream in = System.in;//�냼�뒪(Source)媛� �궎蹂대뱶�씤 寃쎌슦
		byte[] b = new byte[10000];
		int readByteCount = 0;
		*/
		System.out.print("�엯�젰�븯�꽭�슂>");
		InputStream in = System.in;//�냼�뒪(Source)媛� �궎蹂대뱶�씤 寃쎌슦
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			fw = new FileWriter(
				"c:\\dev\\test\\keyboard.txt",true);//true �씠�뼱�벐湲�
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw,true);//true : autoFlush
			
			String readLine = null;
			while((readLine = br.readLine()) != null) {
				if(readLine.equals("exit")) break;
				pw.println(readLine);
				System.out.print("�엯�젰�븯�꽭�슂>");
			}
			
			/*
			fos = new FileOutputStream(
				"c:\\dev\\test\\keyboard.txt",true);//true �씠�뼱�벐湲�
			//in.read(b) => �궎蹂대뱶�뿉�꽌 enter瑜� 移섎㈃ �씫�뒗�떎.
			while((readByteCount = in.read(b)) != -1) {
				String str = new String(b,0,readByteCount).trim();
				if(str.equals("exit")) break;
				fos.write(b,0,readByteCount);
				System.out.print("�엯�젰�븯�꽭�슂>");
			}
			*/
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
				//if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
