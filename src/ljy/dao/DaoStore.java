package ljy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ljy.entity.EntCommodity;
import ljy.util.Db;

public class DaoStore {

	public static List<EntCommodity> getAll() {
		// TODO Auto-generated method stub
		List<EntCommodity> list = new ArrayList<>();
		Connection conn = Db.getConnection();
		String sql = "select * from commodity where status=1";
		try {
			ResultSet ex = conn.createStatement().executeQuery(sql);
			while (ex.next()) {
				EntCommodity commodity = new EntCommodity();
				commodity.setId(ex.getInt("id"));
				commodity.setName(ex.getString("name"));
				commodity.setPrice(ex.getDouble("price"));
				commodity.setSellername(ex.getString("sellername"));
				commodity.setStatus(1);
				list.add(commodity);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static Boolean addCar(String username, String id) {
		// TODO Auto-generated method stub
		Connection conn = Db.getConnection();
		String sql = "select * from commodity where id="+id+" and status=1";
		try {
			ResultSet ex = conn.createStatement().executeQuery(sql);
			while (ex.next()) {
				sql = "INSERT INTO `consumption` (`username`, `commodityid`, `money`, `status`) VALUES ('"+username+"', "+id+", "+ex.getDouble("price")+", 0);";
				conn.createStatement().executeUpdate(sql);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
