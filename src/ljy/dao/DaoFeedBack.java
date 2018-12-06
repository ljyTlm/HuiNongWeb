package ljy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ljy.entity.EntGift;
import ljy.util.Db;

public class DaoFeedBack {

	public static void postFeedBack(String username, String text, String title) {
		// TODO Auto-generated method stub
		Connection conn = Db.getConnection();
		String sql = "INSERT INTO `feedback` (`name`, `title`, `text`) VALUES ('"+username+"', '"+title+"', '"+text+"');";
		try {
			conn.createStatement().executeUpdate(sql);
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
