package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//MIME TYPE
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pwd");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("아이디 : " + id +"<br>");
		out.print("비밀번호 : " + pwd );
		out.print("</body></html>");
		out.close();
	}
}
