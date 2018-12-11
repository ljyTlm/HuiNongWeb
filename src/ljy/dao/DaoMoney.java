package ljy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ljy.entity.EntCommodity;
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
			sta.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static String buyCdy(String username, Integer id) {
		// TODO Auto-generated method stub
		Connection conn = Db.getConnection();
		Double userMoney = Double.valueOf(getMoney(username));
		EntConsumption ctn = getCtnById(id);
		if (userMoney < ctn.getMoney()) {
			return "余额不足！请充值后再进行结算！";
		}
		EntCommodity cdy = getCdyById(ctn.getCommodityId());
		if (cdy.getStatus() < 1) {
			return "此商品库存已无！！";
		}
		try {
			conn.createStatement().executeUpdate("update user set money="+(userMoney-ctn.getMoney())+" where name='"+username+"'");
			conn.createStatement().executeUpdate("update consumption set status=1 where id="+id+"");
			conn.createStatement().executeUpdate("update commodity set status=0 where id="+cdy.getId()+"");
			conn.close();
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	private static EntCommodity getCdyById(Integer id) {
		// TODO Auto-generated method stub
		Connection conn = Db.getConnection();
		String sql = "select * from commodity where id=?";
		EntCommodity cdy = new EntCommodity();
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setInt(1, id);
			ResultSet ex = sta.executeQuery();
			while (ex.next()) {
				cdy.setId(ex.getInt("id"));
				cdy.setName(ex.getString("name"));
				cdy.setPrice(ex.getDouble("price"));
				cdy.setSellername(ex.getString("sellername"));
				cdy.setStatus(ex.getInt("status"));
			}
			sta.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cdy;
	}

	private static EntConsumption getCtnById(Integer id) {
		// TODO Auto-generated method stub
		Connection conn = Db.getConnection();
		String sql = "select * from consumption where id=?";
		EntConsumption ctn = new EntConsumption();
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setInt(1, id);
			ResultSet ex = sta.executeQuery();
			while (ex.next()) {
				ctn.setCommodityId(ex.getInt("commodityid"));
				ctn.setDate(ex.getString("date"));
				ctn.setId(ex.getInt("id"));
				ctn.setMoney(ex.getDouble("money"));
				ctn.setStatus(ex.getInt("id"));
				ctn.setUsername(ex.getString("username"));
			}
			sta.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ctn;
	}

	public static String deleteCdy(Integer id) {
		// TODO Auto-generated method stub
		Connection conn = Db.getConnection();
		try {
			conn.createStatement().executeUpdate("delete from consumption where id="+id);
			conn.close();
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

}
