import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceDAO {
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
               if (rs!= null) rs.close();
               if (psmt != null)
                  psmt.close();
               if (conn != null)
                  conn.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
   
//      public ArrayList select_male() {
//            getConnection();
//            ArrayList <String> dao_list2 = new ArrayList<>();
//            String name = null;
//            int price;
//            int time;
//            String sql = "select * from SERVICE where SV_NAME like '남성%'";
//            try {
//               psmt = conn.prepareStatement(sql);
//               rs = psmt.executeQuery();
//               while(rs.next()) {
//                  name = rs.getString(1);
//                  price = rs.getInt(2);
//                  time = rs.getInt(3);
//                  dao_list2.add("시술 이름:"+name+"    시술가격:"+price+"    소요시간:"+time +"시간");
//               }
//            } catch(SQLException e) {
//               e.printStackTrace();
//            }finally {
//             
//               close();
//            
//            }
//            return dao_list2;
//           
//            }
//   
//
//      
//      public ArrayList select_female() {
//         getConnection();
//         ArrayList <String> dao_list = new ArrayList<>();
//         String name = null;
//         int price;
//         int time;
//         String sql = "select * from SERVICE where SV_NAME like '여성%'";
//         try {
//            psmt = conn.prepareStatement(sql);
//            rs = psmt.executeQuery();
//            while(rs.next()) {
//               name = rs.getString(1);
//               price = rs.getInt(2);
//               time = rs.getInt(3);
//               dao_list.add("시술명 :"+name+" 기본가격 : "+price+" 소요시간 : "+time +"시간");
//            }
//         } catch(SQLException e) {
//            e.printStackTrace();
//         }finally {
//          
//            close();
//         
//         }
//         return dao_list;
//        
//         }

      
      
}
