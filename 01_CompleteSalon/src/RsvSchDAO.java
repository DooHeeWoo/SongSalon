import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RsvSchDAO {
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

	public String RsvTimeSelect(String input_id) {
		getConnection();
		String rsvschtime = "¾øÀ½";
		
		String sql = "select RSVSCH_TIME from RSV_SCHEDULE where RSVSCH_CODE = (select rsv_sch_code from RESERVATION where rsv_cst_id = ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, input_id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				rsvschtime = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rsvschtime;
	}

	public DsgSchVO CancelListSelect(String input_id) {
		getConnection();
		DsgSchVO dsgschvo =null;
		String sql = "select * from RSV_SCHEDULE where RSVSCH_CODE = (select rsv_sch_code from RESERVATION where rsv_cst_id = ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, input_id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dsgschvo = new DsgSchVO(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return dsgschvo;
	}
	
	public void CancelListDelete(String input_id) {
		getConnection();

		String sql = "delete from RSV_SCHEDULE where RSVSCH_CODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, input_id);
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
