package work.VoucherApp.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {
    public static final String TAG = "JDBCUtils";
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String dbName = "testdb";
    public static final String URL = "jdbc:mysql://192.168.68.76:3306/" + dbName;
    public static final String USER = "root";
    public static final String PASSWORD = "123123";
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception | Error e) {
            e.printStackTrace();
        }
        return conn;
    }
}
