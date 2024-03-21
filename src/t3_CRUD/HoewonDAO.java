package t3_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoewonDAO {
	private Connection conn = null;
	
	public HoewonDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javaclass";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패");
		}
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	// 전체 회원 조회
	public HoewonVO getList() {
		HoewonVO vo = new HoewonVO();
		try {
			Statement stmt = conn.createStatement(); 
			String sql = "select * from hoewon";
			ResultSet rs = stmt.executeQuery(sql); // 데이터베이스의 자료를 꺼내오는 방법
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("Idx"));
				vo.setName(rs.getString("Name"));
				vo.setAge(rs.getInt("Age"));
				vo.setGender(rs.getString("Gender"));
				vo.setAddress(rs.getString("Address"));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage()); 
		}
		return vo;
	}
}
