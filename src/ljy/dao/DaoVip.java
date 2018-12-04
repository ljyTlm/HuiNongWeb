package ljy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.org.apache.regexp.internal.recompile;

import ljy.util.Db;

public class DaoVip {
	
	public static Integer getVip(String name, String code) {
		// TODO Auto-generated method stub
		Connection conn = Db.getConnection();
		String sql = "select * from vipcode where code=?";
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, code);
			ResultSet ex = sta.executeQuery();
			while (ex.next()) {
				String value = ex.getString("code");
				if (code.equals(value)) {
					conn.createStatement().executeUpdate("update user set vip=2 where name='"+name+"'");
					conn.createStatement().executeUpdate("delete from vipcode where code='"+code+"'");
					return 1;
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

	public static Integer getVipScore(String name) {
		// TODO Auto-generated method stub
		Connection conn = Db.getConnection();
		String sql = "select * from user where name=?";
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, name);
			ResultSet ex = sta.executeQuery();
			while (ex.next()) {
				Integer value = ex.getInt("score");
				return value;
			}
			sta.close();
			conn.close();
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
}
