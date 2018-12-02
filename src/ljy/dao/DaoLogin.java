package ljy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ljy.util.Db;

public class DaoLogin {

	public static Integer select(String username, String userpwd) {
		// TODO Auto-generated method stub
		Connection conn = Db.getConnection();
		String sql = "select * from user where name=?";
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, username);
			ResultSet ex = sta.executeQuery();
			while (ex.next()) {
				String value = ex.getString("passwd");
				if (userpwd.equals(value)) {
					Integer vip = ex.getInt("vip");
					sta.close();
					conn.close();
					return vip;
				}
			}
			sta.close();
			conn.close();
			return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
