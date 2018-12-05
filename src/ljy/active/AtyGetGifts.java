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
import ljy.entity.EntGift;
import ljy.entity.EntNews;

/**
 * Servlet implementation class AtyGetGifts
 */
@WebServlet("/AtyGetGifts")
public class AtyGetGifts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtyGetGifts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<EntGift> data = DaoGifts.getGifts();
		HashMap<String, List<EntGift>> mp = new HashMap<>();
		mp.put("gifts", data);
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
