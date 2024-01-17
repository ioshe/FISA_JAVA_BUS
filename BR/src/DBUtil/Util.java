package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
        static {
                try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (Exception e) {
                        e.printStackTrace();//예외 발생 상황을 디테일하게 출력
                        //System.out.println("여기서 뜨는거야?");
                }
        }
        
        // get Connection
        public static Connection getConnection() throws SQLException{
                String url = "jdbc:mysql://localhost:3306/your_database_name?characterEncoding=UTF-8&serverTimezone=UTC";
                String id = "ID";
                String pw = "password";
                //localhost:3306/your_database_name 의 부분을 고쳐서 사용가능
                
                return DriverManager.getConnection(url, id, pw);
        }
        


        
        // close 전용 함수
        public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException{
                rs.close();
                stmt.close();
                conn.close();
        }




        public static void close(Connection conn, PreparedStatement pstmt)  throws SQLException{
//                rs.close();
                pstmt.close();
                conn.close();
        }
}
