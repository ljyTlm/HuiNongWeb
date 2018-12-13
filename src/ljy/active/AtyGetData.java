package ljy.active;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import ljy.dao.DaoGetData;

/**
 * Servlet implementation class AtyGetData
 */
@WebServlet("/AtyGetData")
public class AtyGetData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtyGetData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String operation = request.getParameter("operation");
		List<String> list = new ArrayList<>();
		if ("1".equals(operation)) { //year
			list = DaoGetData.getAllYear();
		}else if ("2".equals(operation)) {// name
			list = DaoGetData.getAllFram();
		}else if ("3".equals(operation)) {
			String year = request.getParameter("year");
			String farm = request.getParameter("farm");
			list = DaoGetData.getTraByFY(year, farm);
		}else if ("4".equals(operation)) {
			String year = request.getParameter("year");
			String farm = request.getParameter("farm");
			list = DaoGetData.getPricByFY(year, farm);
		}
		response.getWriter().append(JSON.toJSONString(list));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
