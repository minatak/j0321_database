package t4_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HoewonDAO2 {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	HoewonVO vo = null;
	private String sql = "";
	
	
	public HoewonDAO2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
//			String url = "jdbc:mysql://localhost:3306/javaclass";
			String url = "jdbc:mysql://192.168.50.59:3306/javaclass";
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
	
	public void stmtClose() {
		try {
			if(stmt != null) stmt.close();
		} catch (SQLException e) {}
	}
	
	public void rsClose() {
		try {
			if(rs != null) rs.close();
			stmtClose();
		} catch (SQLException e) {}
	}
	
	// 전체 회원 조회
	public ArrayList<HoewonVO> getList() {
		ArrayList<HoewonVO> vos = new ArrayList<HoewonVO>();
		try {
			stmt = conn.createStatement(); 
			sql = "select * from hoewon";
			rs = stmt.executeQuery(sql); // 데이터베이스의 자료를 꺼내오는 방법
			
//			HoewonVO vo = null;
			while(rs.next()) {
				vo = new HoewonVO();
				vo.setIdx(rs.getInt("Idx"));
				vo.setName(rs.getString("Name"));
				vo.setAge(rs.getInt("Age"));
				vo.setGender(rs.getString("Gender"));
				vo.setAddress(rs.getString("Address"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage()); 
		} finally {
			rsClose();
		}
		return vos;
	}
	
	// 개별검색처리
	public HoewonVO getSearch(String name) {
		
		HoewonVO vo = new HoewonVO();
		
		try {
			 stmt = conn.createStatement(); 
			sql = "select * from hoewon where name = '"+name+"'";
			 rs = stmt.executeQuery(sql); // 데이터베이스의 자료를 꺼내오는 방법
			
			if(rs.next()) {
				vo = new HoewonVO();
				vo.setIdx(rs.getInt("Idx"));
				vo.setName(rs.getString("Name"));
				vo.setAge(rs.getInt("Age"));
				vo.setGender(rs.getString("Gender"));
				vo.setAddress(rs.getString("Address"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage()); 
		} finally {
			rsClose();
		}
		
		return vo;
	}
	
	/*
	// 회원자료 수정처리
	// System.out.print("수정할 항목 (1.성명 2.나이 3.성별 4.주소) ==> ");
	public void setUpdate(int idx, int choice, String content) {
		try {
			 stmt = conn.createStatement();
			if(choice == 1) {
				sql = "update hoewon set name='"+content+"' where idx="+idx;
			}
			else if(choice == 2) {
				sql = "update hoewon set age="+Integer.parseInt(content)+" where idx="+idx; 
			}
			else if(choice == 3) {
				sql = "update hoewon set gender='"+content+"' where idx="+idx; 
			}
			else if(choice == 4) {
				sql = "update hoewon set name='"+content+"' where idx="+idx; 
			}
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage()); 
		} finally {
			stmtClose();
		}
	}
	*/

	// 회원 삭제 처리
	public void setDelete(String name) {
		try {
			 stmt = conn.createStatement();
			sql = "delete from hoewon where name='"+name+"'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage()); 
		} finally {
			stmtClose();
		}
	}

	// 회원 등록 처리
	public void setInput(HoewonVO vo) {
		try {
			 stmt = conn.createStatement();
			sql = "insert into hoewon values (default,'"+vo.getName()+"',"+vo.getAge()+",'"+vo.getGender()+"','"+vo.getAddress()+"')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage()); 
		} finally {
			stmtClose();
		}
	}

	// 회원 정보 수정하기
	public int setUpdate(HoewonVO vo) {
		int res = 0;
		try {
			stmt = conn.createStatement();
			sql = "update hoewon set name='"+vo.getName()+"', age="+vo.getAge()+", gender='"+vo.getGender()+"', address='"+vo.getAddress()+"' where idx="+vo.getIdx();
			res = stmt.executeUpdate(sql);
			System.out.println("수정한 자료의 갯수 : " + res);
			res = 0;
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage()); 
		} finally {
			stmtClose();
		}
		return res;
	}
}
