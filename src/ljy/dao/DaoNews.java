package ljy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ljy.entity.EntNews;
import ljy.util.Db;

public class DaoNews {

	public static List<EntNews> getNews(int num) {
		// TODO Auto-generated method stub
		Connection conn = Db.getConnection();
		List<EntNews> data = new ArrayList<>();
		String sql = "select * from news";
		
		try {
			ResultSet ex = conn.prepareStatement(sql).executeQuery();
			while (ex.next() && num > 0) {
				int flag = (int)(Math.random()*2);
				if (flag == 1) {
					num --;
					EntNews news = new EntNews();
					news.setImgname(ex.getString("imgname"));
					news.setTitle(ex.getString("title"));
					news.setUrl(ex.getString("url"));
					data.add(news);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return data;
	}

}
