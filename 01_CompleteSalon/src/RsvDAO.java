import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RsvDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String password = "hr";

	private void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void close() {
		try {
			if (rs != null) rs.close();
			if (psmt != null) psmt.close();
			if (conn != null) conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String RsvDateselect(String input_id) {
		getConnection();
		String rsvdate = "없음";
		
		String sql = "select rsv_date from RESERVATION where rsv_cst_id = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, input_id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				rsvdate = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rsvdate;
	}

	public String RsvSvselect(String input_id) {
		
		getConnection();
		String rsvsvname = "없음";
		
		String sql = "select rsv_sv_name from RESERVATION where rsv_cst_id = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, input_id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				rsvsvname = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rsvsvname;
		
	}

	public int rsvPriceSelect(String input_id) {
		
		getConnection();
		int rsvPrice = 0;
		
		String sql = "select rsv_cost from RESERVATION where rsv_cst_id =? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, input_id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				rsvPrice = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rsvPrice;
	}

	public void rsvDelete(String deleteSchCode) {
		getConnection();

		String sql = "delete from RESERVATION where rsv_sch_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, deleteSchCode);
			rs = psmt.executeQuery();
//			if (rs.next()) {
//				psmt.executeUpdate();
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		

		
	}
	
	
}
