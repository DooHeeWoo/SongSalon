import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DsgDAO {
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

	public String dsgNameselect(String input_id) {
		getConnection();
		String rsvdsgname = "¾øÀ½";
		
		String sql = "select dsr_name from DESIGNER where dsr_code = (select RSVSCH_DSRCODE from RSV_SCHEDULE where RSVSCH_CODE = (select rsv_sch_code from RESERVATION where rsv_cst_id = ?))";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, input_id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				rsvdsgname = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rsvdsgname;
	}
	
}
