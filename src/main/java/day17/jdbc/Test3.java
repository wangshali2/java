package day17.jdbc;

import java.sql.*;

/**
 *
 */


public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://172.31.0.81:3306/bigdata";
        String user = "matrix";
        String password = "7xNetworks@C0M";

        Connection conn = DriverManager.getConnection(url, user, password);

        String sql5 = "select * from wsl ";
        PreparedStatement ps2 = conn.prepareStatement(sql5);

        ResultSet result2 = ps2.executeQuery();

        while (result2.next()) {
            int id = result2.getInt(1);
            String name = result2.getString(2);
            int age = result2.getInt(3);


            System.out.println(id + ":" + name + ":" + age);
        }

    }
}

















