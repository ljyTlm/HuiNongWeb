package ljy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import ljy.entity.EntGift;
import ljy.util.Db;

public class DaoGifts {

	public static List<EntGift> getGifts() {
		// TODO Auto-generated method stub
		List<EntGift> list = new ArrayList<>();
		Connection conn = Db.getConnection();
		String sql = "select * from gift";
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet ex = sta.executeQuery();
			while (ex.next()) {
				EntGift gift = new EntGift();
				gift.setId(ex.getInt("id"));
				gift.setImgurl(ex.getString("imgurl"));
				gift.setName(ex.getString("name"));
				gift.setScore(ex.getInt("score"));
				list.add(gift);
			}
			sta.close();
			conn.close();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static int getGiftByScore(int giftId, String username) {
		// TODO Auto-generated method stub
		Connection conn = Db.getConnection();
		String sql = "select * from gift where id=?";
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setInt(1, giftId);
			ResultSet ex = sta.executeQuery();
			int giftScore = Integer.MAX_VALUE;
			int giftNum = 0;
			while (ex.next()) {
				giftScore = ex.getInt("score");
				giftNum = ex.getInt("num");
			}
			sql = "select * from user where name=?";
			sta = conn.prepareStatement(sql);
			sta.setString(1, username);
			ex = sta.executeQuery();
			int vipScore = 0;
			while (ex.next()) {
				vipScore = ex.getInt("score");
			}
			if (giftNum == 0) {
				sta.close();
				conn.close();
				return 0;
			}
			if (vipScore < giftScore) {
				sta.close();
				conn.close();
				return 1;
			}
			conn.createStatement().executeUpdate("update user set score="+(vipScore-giftScore)+" where name='"+username+"'");
			conn.createStatement().executeUpdate("update gift set num="+(giftNum-1)+" where id="+giftId);
			sta.close();
			conn.close();
			return 2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
