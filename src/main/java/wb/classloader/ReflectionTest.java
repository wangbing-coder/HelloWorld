package wb.classloader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author bing.wang
 * @date 2020/7/29 22:41
 */
public class ReflectionTest {
    /**
     * 反射的特征：动态
     *
     * 反射更多体现在框架中
     *
     */

    /**
     * 获取Oracle数据库Connection
     * @return
     */
    public static Connection getConnection() {
        String driver = "oracle.jdbc.driver.OracleDriver"; // Oracle数据库驱动类
        String url = "jdbc:oracle:thin:@192.168.90.205:1521/datacent"; // Oracle数据库连接url
        String user = "zhaoxu"; // Oracle数据库登录账号
        String password = "zhaoxu"; // Oracle数据库登录密码
        return getConnection(driver, url, user, password);
    }

    public static Connection getConnection(String driver, String url, String user, String password) {
        Connection conn = null;
        try {
            Class.forName(driver); // 加载数据库驱动
            conn = DriverManager.getConnection(url, user, password); // 获取数据库连接
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public static void executeQuery() {
        // 查询SQL
        String sql = "select * from dual";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection(); // 获取Oracle连接
            ps = conn.prepareStatement(sql); // 处理需要执行的SQL
            rs = ps.executeQuery(); // 执行SQL
            while (rs.next()) { // 处理SQL返回的结果
                System.out.println("---");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        executeQuery();
    }



}
