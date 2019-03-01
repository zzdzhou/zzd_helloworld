package jack.helloworld.jdbc;

import java.sql.*;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-17
 */
public class DriverManagerDemo {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String email = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mmal?serverTimezone=UTC", "root", "zzde");
            //con.setAutoCommit(false);
            pstmt = con.prepareStatement("select email from user where id = ?");
            pstmt.setInt(1, 3);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                email = resultSet.getString("email");
            }
            //con.commit();
            System.out.println("log INFO - " + email);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
