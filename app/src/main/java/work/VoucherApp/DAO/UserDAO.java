package work.VoucherApp.DAO;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import work.VoucherApp.utils.JDBCUtils;

public class UserDAO {
    private static final String TAG = "UserDAO";
    public int login(String username, String password) {
        HashMap<String, Object> map = new HashMap<>();
        Connection conn = JDBCUtils.getConnection();
        int msg = 0;
        try {
            String sql = "select * from user where username = ?";
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(sql);
                if (ps != null) {
                    Log.e(TAG, "login: " + username);
                    ps.setString(1, username);
                    ResultSet rs = ps.executeQuery();
                    int count = rs.getMetaData().getColumnCount();
                    while (rs.next()) {
                        for (int i = 1; i <= count; i++) {
                            String columnName = rs.getMetaData().getColumnName(i);
                            map.put(columnName, rs.getObject(columnName));
                        }
                    }
                    conn.close();
                    ps.close();
                    if(!map.isEmpty()) {
                        if ("admin".equals(map.get("type"))) {
                            msg = 3;
                        } else if (password.equals(map.get("password"))) {
                            msg = 1;
                        } else {
                            msg = 2;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "login: " + e.getMessage());
        }
        return msg;
    }
    public boolean register(String username, String password) {
        Connection conn = JDBCUtils.getConnection();
        boolean flag = false;
        try {
            String sql = "insert into user(username,password,type) values(?,?,?)";
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(sql);
                if (ps != null) {
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ps.setString(3, "user");
                    int i = ps.executeUpdate();
                    if (i > 0) {
                        flag = true;
                    }
                    conn.close();
                    ps.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "register: " + e.getMessage());
        }
        return flag;
    }
}
