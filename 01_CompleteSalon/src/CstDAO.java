import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CstDAO {
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

	public int Cstinsert(MemberVO_User us) {
		getConnection();
		int row = 0;
		try {
			String sql = "insert into CUSTOMER values(?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, us.getid());
			psmt.setString(2, us.getpassword());
			psmt.setString(3, us.getName());
			psmt.setString(4, us.getPhoneNumber());
			row = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}
	
	public String CstIdPwselect(String id, String password) {
		getConnection();
		String name = null;
		String sql = "select cst_name from CUSTOMER where cst_id = ? and cst_pw = ?"; // 오탈자 조심
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, password);
			rs = psmt.executeQuery();
			if (rs.next()) {
				name = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return name;
	}

	public String RsvCstNameSelect(String input_id) {
		getConnection();
		String rsvcstname = "없음";
		String sql = "select cst_name from CUSTOMER where cst_id =(select rsv_cst_id from RESERVATION where rsv_cst_id = ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, input_id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				rsvcstname = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rsvcstname;
	}
}
