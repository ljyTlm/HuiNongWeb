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

import ljy.dao.DaoFeedBack;
import ljy.dao.DaoMoney;
import ljy.entity.EntConsumption;

/**
 * Servlet implementation class AtyGetMoney
 */
@WebServlet("/AtyGetMoney")
public class AtyGetMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtyGetMoney() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String operation = request.getParameter("operation");
		response.setCharacterEncoding("utf-8");
		if ("0".equals(operation)) {
			HashMap<String, String> map = new HashMap<>();
			map.put("money", DaoMoney.getMoney(username));
			response.getWriter().append(JSON.toJSONString(map));
		}else {
			List<EntConsumption> list = DaoMoney.getCtn(username, 1);
			response.getWriter().append(JSON.toJSONString(list));
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
