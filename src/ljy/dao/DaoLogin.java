package ljy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ljy.entity.EntUser;
import ljy.util.Db;

public class DaoLogin {

	public static EntUser select(String username) {
		EntUser user = new EntUser();
		Connection conn = Db.getConnection();
		String sql = "select * from user where name=?";
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, username);
			ResultSet ex = sta.executeQuery();
			while (ex.next()) {
				user.setName(ex.getString("name"));
				user.setPasswd(ex.getString("passwd"));
				user.setMoney(ex.getDouble("money"));
				user.setScore(ex.getInt("score"));
				user.setVip(ex.getInt("vip"));
			}
			sta.close();
			conn.close();
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public static Integer select(String username, String userpwd) {
		// TODO Auto-generated method stub
		EntUser user = select(username);
		if (user.getName() != null) {
			if (userpwd.equals(user.getPasswd())) {
				return user.getVip();
			}
		}
		return 0;
	}

	public static Integer regist(String username, String userpwd) {
		// TODO Auto-generated method stub
		EntUser user = select(username);
		if (user.getName() != null) {
			return 0;
		}
		String sql = "INSERT INTO `user` (`name`, `passwd`, `vip`, `score`, `money`) VALUES ('"+username+"', '"+userpwd+"', 1, 0, 0.0)";
		try {
			Db.getConnection().createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

}
