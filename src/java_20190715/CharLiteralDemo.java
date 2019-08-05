package java_20190715;

public class CharLiteralDemo {
	public static void main(String[] args) {
		//char literal의 유니코드 표현 => '\u0000'
		char c1 = '\uc131';
		char c2 = '\uc601';
		char c3 = '\ud55c';
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		//char literal의 아스키코드 표현 => 65
		
		char c4 = 65;
		System.out.println(c4);
		
		//char literal의 문자표현 => ''
		
		char c5 = 'q';
		
		System.out.println(c5);
		
		char c6 = '"';
		
		//특수문자
		// \n => line feed
		// \t => tab
		// \\ => back slash
		// \' => single quotation
		// \" => double quatation
		
		String path = "aa\ncc";
		
		System.out.println(path);
		
		double d1 = 123.12f;
		
		
		
		
	}
}
