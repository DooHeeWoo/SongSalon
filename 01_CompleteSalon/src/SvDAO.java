import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SvDAO {
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

	/*
	 * public ArrayList select_male() { getConnection(); ArrayList <String>
	 * dao_list2 = new ArrayList<>(); String name = null; int price; int time;
	 * String sql = "select * from SERVICE where SV_NAME like '남성%'" ; try { psmt =
	 * conn.prepareStatement(sql); rs = psmt.executeQuery(); while(rs.next()) { name
	 * = rs.getString(1); price = rs.getInt(2); time = rs.getInt(3);
	 * dao_list2.add("시술 이름:"+name+"    시술가격:"+price+"    소요시간:"+time +"시간"); } }
	 * catch(SQLException e) { e.printStackTrace(); }finally {
	 * 
	 * close();
	 * 
	 * } return dao_list2;
	 * 
	 * }
	 */

	public ArrayList select_male2() {
		getConnection();
		ArrayList<Sv_VO> dao_list2 = new ArrayList<>();
		String name = null;
		int price;
		int time;
		String sql = "select * from SERVICE where SV_NAME like '남성%'";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);
				price = rs.getInt(2);
				time = rs.getInt(3);
				dao_list2.add(new Sv_VO(name, price, time));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();

		}
		return dao_list2;

	}

	public ArrayList select_female2() {
		getConnection();
		ArrayList<Sv_VO> dao_list2 = new ArrayList<>();
		String name = null;
		int price;
		int time;
		String sql = "select * from SERVICE where SV_NAME like '여성%'";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);
				price = rs.getInt(2);
				time = rs.getInt(3);
				dao_list2.add(new Sv_VO(name, price, time));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();

		}
		return dao_list2;

	}

	public VO_SCHEDULE selectSchcode(String date, String time, String dCode) {
		getConnection();
		VO_SCHEDULE vosch = null;
		String sql = "select * from  DSR_SCHEDULE where DSRSCH_DCODE = ? and DSRSCH_TIME = ? and DSRSCH_DATE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dCode);
			psmt.setString(2, time);
			psmt.setString(3, date);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vosch = new VO_SCHEDULE(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();

		}
		return vosch;

	}

//	public ArrayList select_female() {
//		getConnection();
//		ArrayList<String> dao_list = new ArrayList<>();
//		String name = null;
//		int price;
//		int time;
//		String sql = "select * from SERVICE where SV_NAME like '여성%'";
//		try {
//			psmt = conn.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			while (rs.next()) {
//				name = rs.getString(1);
//				price = rs.getInt(2);
//				time = rs.getInt(3);
//				dao_list.add("시술명 :" + name + " 기본가격 : " + price + " 소요시간 : " + time + "시간");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			close();
//
//		}
//		return dao_list;
//
//	}

	public int selectextraprice(String designer_code) {
		getConnection();
		int extra_price = 0;
		String sql = "select pr_add from price where pr_pst = (select DSR_PST from designer where DSR_CODE =?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, designer_code);
			rs = psmt.executeQuery();
			if (rs.next()) {
				extra_price = rs.getInt("pr_add");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();

		}
		return extra_price;
	}

	public int insertrsvsch(VO_SCHEDULE sch) {
		getConnection();
		int row = 0;
		try {
			String sql = "insert into RSV_SCHEDULE values(?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sch.getSch_code());
			psmt.setString(2, sch.getSch_id());
			psmt.setString(3, sch.getSch_time());
			psmt.setString(4, sch.getSch_date());
			row = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	public void deletedsgsch(String deleteschcode) {
		getConnection();
		//String sql = "delete from DH_SCH_TEST where sch_code = ?";
		String sql = "delete from DSR_SCHEDULE where DSRSCH_CODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, deleteschcode);
			rs = psmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();

		}
	}

}
