package java_20190812;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcInsertDemo {
	public static void main(String[] args) {
	 try {
		Class.forName("org.mariadb.jdbc.Driver");
		System.out.println("Driver Loaded Successfully");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("Failed to load the driver");
		e.printStackTrace();
	}
	 
	 Connection  con = null;
	 PreparedStatement pstmt = null;
	 try {
		con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true","kic12","kic12"); // url, 사용자, 패스워드
		
		StringBuffer sql = new StringBuffer(); // StringBuffer를 쓰는 이유는 객체생성(메모리) 최소화
		sql.append("insert into member(num, name, addr)");
		sql.append("values(?,?,?)"); // ? => 바인딩 변수
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setInt(1, 12);
		pstmt.setString(2, "마크주커버그");
		pstmt.setString(3, "팔로알토");
		// sql문 전송
		// executeUpdate() => insert, update, delete문일 때 사용
		// 반환값은 갱신된 행의 수이다. 
		int resultCount = pstmt.executeUpdate(); 
		System.out.println("갱신된 행의 수 : " +resultCount);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
}
}
