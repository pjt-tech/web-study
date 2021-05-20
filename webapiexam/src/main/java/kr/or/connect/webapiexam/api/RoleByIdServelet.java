package kr.or.connect.webapiexam.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

/**
 * Servlet implementation class RoleByIdServelet
 */
@WebServlet("/roles/*")
public class RoleByIdServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleByIdServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		String pathInfo = request.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		String idStr = pathParts[1];
		int id = Integer.parseInt(idStr);
		
		RoleDao dao = new RoleDao();
		
		Role role = dao.getRole(id);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(role);
		
		PrintWriter out = response.getWriter();
		out.println(idStr);
		out.println(json);
		out.close();
		
		
	}

}
