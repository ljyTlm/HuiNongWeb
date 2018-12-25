package ljy.active;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import ljy.dao.DaoStore;
import ljy.entity.EntCommodity;

/**
 * Servlet implementation class AtyGetStore
 */
@WebServlet("/AtyGetStore")
public class AtyGetStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtyGetStore() {
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
		String username = request.getParameter("username");
		String id = request.getParameter("id");
		if ("0".equals(operation)) {
			List<EntCommodity> list = DaoStore.getAll();
			response.getWriter().append(JSON.toJSONString(list));
		}else if("1".equals(operation)){
			Boolean flag = DaoStore.addCar(username, id);
			response.getWriter().append(JSON.toJSONString(new Boolean[]{flag}));
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
