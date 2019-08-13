package java_20190813;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java_20190812.MemberDto;

public class DeptDao {
	private static DeptDao single;
	
	
	private DeptDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
	public static DeptDao getInstance() {
		if(single == null) {
			single = new DeptDao();
		}
		return single;
	}
	public boolean insert(DeptDto d) {
		Connection con = null;
		PreparedStatement pstmt =  null;
		boolean isSuccess = false;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic2", "kic13", "kic13");
			StringBuffer sql = new StringBuffer();
			sql.append("insert into dept(deptno, dname, loc) ");
			sql.append("values(?,?,?)");

			pstmt = con.prepareStatement(sql.toString());
			//바인딩 변수가 있으면 아래에 코딩
			pstmt.setInt(index++,d.getNo());
			pstmt.setString(index++,d.getName());
			pstmt.setString(index++, d.getLoc());
			
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return isSuccess;
	}
	public boolean update(DeptDto d) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic2", "kic13", "kic13");
			StringBuffer sql = new StringBuffer();
			sql.append("update dept ");
			sql.append("set dname=?, loc=? ");
			sql.append("where deptno = ?");
			pstmt = con.prepareStatement(sql.toString());
			//바인딩 변수가 있으면 아래에 코딩
			pstmt.setString(index++,d.getName());
			pstmt.setString(index++, d.getLoc());
			pstmt.setInt(index++, d.getNo());
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return isSuccess; 
	}
	
	public boolean delete(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic2", "kic13", "kic13");
			StringBuffer sql = new StringBuffer();
			sql.append("delete from dept ");
			sql.append("where deptno = ?");

			pstmt = con.prepareStatement(sql.toString());

			pstmt.setInt(index++, no);
			
			pstmt.executeUpdate();
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null)con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return isSuccess;
	}

	public ArrayList<DeptDto> select(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<DeptDto> list = new ArrayList<DeptDto>();
		int index = 1;

		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic2", "kic13", "kic13");

			StringBuffer sql = new StringBuffer();
			sql.append("select deptno, dname, loc ");
			sql.append("from dept ");
			sql.append("order by deptno");

			pstmt = con.prepareStatement(sql.toString());
			//바인딩 변수가 있다면 코딩
			//pstmt.setString(index++,);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				index = 1;
				int no = rs.getInt(index++);
				String name = rs.getString(index++);
				String loc = rs.getString(index);
				list.add(new DeptDto(no,name,loc));
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}

		return list;
	}
}