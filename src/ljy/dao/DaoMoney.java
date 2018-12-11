package ljy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ljy.entity.EntConsumption;
import ljy.util.Db;

public class DaoMoney {

	public static String getMoney(String username) {
		// TODO Auto-generated method stub
		Double value = 0.00;
		Connection conn = Db.getConnection();
		String sql = "select * from user where name=?";
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, username);
			ResultSet ex = sta.executeQuery();
			while (ex.next()) {
				value = ex.getDouble("money");
			}
			sta.close();
			conn.close();
			return value.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return value.toString();
	}

	public static List<EntConsumption> getCtn(String username, Integer status) {
		// TODO Auto-generated method stub
		List<EntConsumption> list = new ArrayList<>();
		Connection conn = Db.getConnection();
		String sql = "select * from consumption where username=? and status=?";
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, username);
			sta.setInt(2, status);
			ResultSet ex = sta.executeQuery();
			while (ex.next()) {
				EntConsumption ctn = new EntConsumption();
				ctn.setCommodityId(ex.getInt("commodityid"));
				ctn.setDate(ex.getString("date"));
				ctn.setId(ex.getInt("id"));
				ctn.setMoney(ex.getDouble("money"));
				ctn.setStatus(status);
				ctn.setUsername(username);
				list.add(ctn);
			}
			sql = "select * from commodity where id=?";
			for (EntConsumption ctn : list) {
				sta = conn.prepareStatement(sql);
				sta.setInt(1, ctn.getCommodityId());
				ex = sta.executeQuery();
				while (ex.next()) {
					ctn.setCtnname(ex.getString("name"));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
