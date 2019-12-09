

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//�����̳� ������ DAO
public class DsgSchDAO extends TimeSelect {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String password = "hr";

	private void getConnection() {// DB ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void close() {// DB ���� ��
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
//	               timeList.add("�ü� �̸� :"+name+"\t�ü����� : "+price+"\t�ҿ�ð� : "+time +"�ð�");
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
			psmt = conn.prepareStatement(sql);// SQl���� ��������
			psmt.setString(1, dsgCode);// ?�� ���� ���� ������
			//psmt.setString(2, selectedDate);
			rs = psmt.executeQuery();// ������ ����
			while (rs.next()) {// DB��ü ������ �˻�
				inputTime = rs.getString(1);//�ü� ������ �ð��� ��� �����ͼ�
				timeList.add(inputTime);//ArrayList�� �ֱ�
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return timeList;//�ü� ���� �ð��븦 ��� ���� Arrlist ��ȯ
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
