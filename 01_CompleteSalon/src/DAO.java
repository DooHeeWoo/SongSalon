import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
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
	
	public int insert(VO vo) {
		getConnection();
		int row = 0;
		try {
			//String sql = "insert into test_rsv values(?,?,?,?,?,?,?)";
			String sql = "insert into reservation values(?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getRsv_num());
			psmt.setString(2, vo.getRsv_date());
			psmt.setString(3, vo.getRsv_gen());
			psmt.setInt(4, vo.getRsv_cost());
			psmt.setString(5, vo.getRsv_cst_id());
			psmt.setString(6, vo.getRsv_sv_name());
			psmt.setString(7, vo.getRsv_sch_code());
			row = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}
	
//	public String select(VO vo) {
//		getConnection();
//		String cost = "";
//		String sql = "select rsv_cost from ";
//		try {
//			psmt = conn.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			while(rs.next()) {
//				cost = rs.getString(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		return cost;
//	}
	
	
}
