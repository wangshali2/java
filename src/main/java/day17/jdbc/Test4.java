package day17.jdbc;

import java.sql.*;

/**
 *
 */


public class Test4 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://172.31.0.81:3306/bigdata";
        String user = "matrix";
        String password = "7xNetworks@C0M";

        Connection conn = DriverManager.getConnection(url, user, password);

        String sql5 = "select count(*) from wsl ";
        PreparedStatement ps2 = conn.prepareStatement(sql5);

        ResultSet result2 = ps2.executeQuery();

        if (result2.next()) {
            System.out.println(result2.getInt(1));
            int ct = result2.getInt(1);

            int n = ct / 5;

            PreparedStatement ps3 = conn.prepareStatement("select * from wsl limit 0," + n + " ");
            ResultSet result3 = ps3.executeQuery();

            while (result3.next()) {
                int id = result3.getInt(1);
                String name = result3.getString(2);
                int age = result3.getInt(3);


                System.out.println(id + ":" + name + ":" + age);
            }

            PreparedStatement ps4 = conn.prepareStatement("select * from wsl limit " + n + "," + n + " ");
            ResultSet result4 = ps4.executeQuery();

            while (result4.next()) {
                int id = result4.getInt(1);
                String name = result4.getString(2);
                int age = result4.getInt(3);


                System.out.println(id + ":" + name + ":" + age);
            }

            PreparedStatement ps5 = conn.prepareStatement("select * from wsl limit " + 2*n + "," + n + " ");
            ResultSet result5 = ps5.executeQuery();

            while (result5.next()) {
                int id = result5.getInt(1);
                String name = result5.getString(2);
                int age = result5.getInt(3);


                System.out.println(id + ":" + name + ":" + age);
            }

        }


    }

}















