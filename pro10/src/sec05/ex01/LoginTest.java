package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/login")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	List user_list = new ArrayList();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		context = getServletContext();

		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		boolean loginCheck = true;
		
		  List items = (ArrayList)context.getAttribute("user_list"); 
		  if(items != null && items.size() != 0 ) { 
			  for(int i = 0; i<items.size(); i++) {
				  if(items.get(i).equals(user_id)) { 
				  loginCheck = false;
				  out.print("<html><body>"); out.print("이미 접속중인 계정입니다.<br>");
				  out.print("<a href='login.html'>다시 로그인</a>"); out.close(); 
		  		} 
		  	} 
		 }
		 
		if (loginCheck) {
			HttpSession session = request.getSession();
			LoginImpl loginUser = new LoginImpl(user_id, user_pw);
			if (session.isNew()) {
				session.setAttribute("loginUser", loginUser);
				user_list.add(user_id);
				context.setAttribute("user_list", user_list);
			}

			out.println("<html><body>");
			out.println("아이디는 " + loginUser.user_id + "<br>");
			out.println("총 접속자수는 " + LoginImpl.total_user + "<br>");
			out.println("접속 아이디 : <br>");
			List list = (ArrayList) context.getAttribute("user_list");
			for (int i = 0; i < list.size(); i++) {				
				out.println(list.get(i) + "<br>");
			}
			out.println("<a href='logout?user_id=" + user_id + "'>로그아웃</a>");
			out.println("</body></html>");
		}
	}
}
