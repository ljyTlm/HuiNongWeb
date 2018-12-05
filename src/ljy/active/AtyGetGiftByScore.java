package ljy.active;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import ljy.dao.DaoGifts;
import ljy.dao.DaoNews;
import ljy.entity.EntNews;

/**
 * Servlet implementation class AtyGetGiftByScore
 */
@WebServlet("/AtyGetGiftByScore")
public class AtyGetGiftByScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtyGetGiftByScore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int giftId = Integer.valueOf(request.getParameter("id"));
		String username = request.getParameter("username");
		HashMap<String, Integer> mp = new HashMap<>();
		int status = DaoGifts.getGiftByScore(giftId, username);
		mp.put("status", status);
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(JSON.toJSONString(mp));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
