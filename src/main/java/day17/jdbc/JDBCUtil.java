package day17.jdbc;



import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

/**
 * 封装用德鲁伊连接数据池
 *
 * @author wsl
 * @version 2020-09-26
 * JDBC封装方法
 *
 * <p>
 * 操作数据库的连接类:只有SQL语句和？不同
 */
public class JDBCUtil {

    private static DataSource dds;

    //1.私有化构造器
    private JDBCUtil() {
    }

    //3.给dds进行初始化
    static {
        //创建配置文件对象
        try {
            Properties pro = new Properties();
            //Properties方法
            //public void load(InputStream inStream)从输入流中读取属性列表（键和元素对）。

            //ClassLoader方法
            //public InputStream getResourceAsStream(String name)返回读取指定资源的输入流。
            pro.load(JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            dds = DruidDataSourceFactory.createDataSource(pro);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConn() throws SQLException {
        //4.对外提供
        Connection conn = dds.getConnection();
        return conn;
    }

    public static void close(Connection conn) {
        if (conn == null) {
            throw new RuntimeException("连接对象失败");
        }

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void update(String sql, Object... arr) throws SQLException, ClassNotFoundException {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        //3.填充占位符  sql中占位符的个数与可变形参个数相同,传几个？就set几次

        for (int i = 0; i < arr.length; i++) {
            ps.setObject(i + 1, arr[i]);
        }

        ps.execute();
        JDBCUtil.closeResourse2(conn, ps);

    }


    //方法3.通过的连接数据库
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "WSL156230");

        return conn;
    }

    //方法3.通过的关闭资源的操作
    public static void closeResourse(Connection conn, Statement st, ResultSet rs) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //方法4.通过的关闭资源的操作
    public static void closeResourse2(Connection conn, Statement st) {
        if (st == null) {
            throw new RuntimeException("Statement关闭失败");
        }

        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
