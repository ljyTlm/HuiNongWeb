package ljy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ljy.util.Db;

public class DaoGetData {

	public static void getData() {
		// TODO Auto-generated method stub
		
	}

	public static void createData() {
		Connection conn = Db.getConnection();
		String [] name = {"»Æ¶¹","ÓñÃ×"};  
		try {
			for (int i = 2017; i < 2019; i++) {
				for (int j = 0; j < name.length; j++) {
					for (int j2 = 1; j2 < 13; j2++) {
						double chanliang = 50+Math.random()*50;
						double price = 0.7+Math.random();
						String sql = "INSERT INTO `produce` (`name`, `year`, `mouth`, `transaction`, `price`) VALUES ('"+name[j]+"', "+i+", "+j2+", "+chanliang+","+price+");";
						conn.createStatement().executeUpdate(sql);
					}
				}
			}
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<String> getAllYear() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		Connection conn = Db.getConnection();
		String sql = "select * from years";
		try {
			ResultSet ex = conn.createStatement().executeQuery(sql);
			while (ex.next()) {
				list.add(ex.getString("year"));
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static List<String> getAllFram() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		Connection conn = Db.getConnection();
		String sql = "select * from farm";
		try {
			ResultSet ex = conn.createStatement().executeQuery(sql);
			while (ex.next()) {
				list.add(ex.getString("name"));
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static List<String> getTraByFY(String year, String farm) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		Connection conn = Db.getConnection();
		String sql = "select * from produce where year="+Integer.valueOf(year)+" and name='"+farm+"' ";
		try {
			for (int i = 3; i <= 12; i+=3) {
				ResultSet ex = conn.createStatement().executeQuery(sql+"and mouth="+Integer.valueOf(i));
				while (ex.next()) {
					list.add(ex.getDouble("transaction")+"");
				}
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static List<String> getPricByFY(String year, String farm) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		Connection conn = Db.getConnection();
		String sql = "select * from produce where year="+Integer.valueOf(year)+" and name='"+farm+"' ";
		try {
			for (int i = 3; i <= 12; i+=3) {
				ResultSet ex = conn.createStatement().executeQuery(sql+"and mouth="+Integer.valueOf(i));
				while (ex.next()) {
					list.add(ex.getDouble("price")+"");
				}
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
