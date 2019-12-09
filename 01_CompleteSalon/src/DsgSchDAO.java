

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//디자이너 스케줄 DAO
public class DsgSchDAO extends TimeSelect {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String password = "hr";

	private void getConnection() {// DB 접속
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void close() {// DB 접속 끝
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	   public void select() {
//	         getConnection();
//	         String name = null;
//	         int price;
//	         int time;
//	         String sql = "select * from service";
//	         try {
//	            psmt = conn.prepareStatement(sql);
//	            rs = psmt.executeQuery();
//	            while(rs.next()) {
//	               name = rs.getString(1);
//	               price = rs.getInt(2);
//	               time = rs.getInt(3);
//	               timeList.add("시술 이름 :"+name+"\t시술가격 : "+price+"\t소요시간 : "+time +"시간");
//	            }
//	         } catch(SQLException e) {
//	            e.printStackTrace();
//	         }finally {
//	            close();
//	         }
//	         }

	public ArrayList timeselect(String dsgCode) {
		getConnection();
		String inputTime = null;
		ArrayList<String> timeList = new ArrayList<String>();
		String sql = "select DSRSCH_TIME from DSR_SCHEDULE where DSRSCH_DCODE = ?";
		try {
			psmt = conn.prepareStatement(sql);// SQl문을 가져가서
			psmt.setString(1, dsgCode);// ?에 값을 넣은 다음에
			//psmt.setString(2, selectedDate);
			rs = psmt.executeQuery();// 쿼리문 실행
			while (rs.next()) {// DB전체 데이터 검색
				inputTime = rs.getString(1);//시술 가능한 시간대 모두 가져와서
				timeList.add(inputTime);//ArrayList에 넣기
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return timeList;//시술 가능 시간대를 모두 다음 Arrlist 반환
	}

	public int CancelListInsert(DsgSchVO inputCancelList) {
		getConnection();
		int row = 0;
		try {
			String sql = "insert into DSR_SCHEDULE values(?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, inputCancelList.getDsrsch_code());
			psmt.setString(2, inputCancelList.getDsrsch_dcode());
			psmt.setString(3, inputCancelList.getDsrsch_time());
			psmt.setString(4, inputCancelList.getDsrsch_date());
			row = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
		
	}

}
