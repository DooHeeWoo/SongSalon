
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_RESERVATION {
	
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
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insert(VO_RESERVATION vr) {
		getConnection();
		int row = 0;
		try {
			String sql = "insert into RESERVATION values(seq_rsv_num.nextVal,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vr.getRsv_date());
			psmt.setString(2, vr.getRsv_gen());
			psmt.setInt(3, vr.getRsv_cost());
			psmt.setString(4, vr.getRsv_cst_id());
			psmt.setString(5, vr.getRsv_sv_name());
			psmt.setString(6, vr.getRsv_sch_code());
			row = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}
	
	public String select(String code) {
		getConnection();
		String info = null;
		ArrayList<String> rsvlist = new ArrayList<>();
		
		String sql = "select rsv_cst_id, rsv_sv_name from reservation where rsv_sch_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setObject(1, code);
			rs = psmt.executeQuery();
			if(rs.next()) {
				info = rs.getString("rsv_cst_id") +"\n"+ rs.getString("rsv_sv_name");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return info;		
	}
	}

