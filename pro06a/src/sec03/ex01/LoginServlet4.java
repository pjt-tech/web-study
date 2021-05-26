package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet4
 */
@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pwd");
		String address = request.getParameter("address");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("아이디 : " + id + "<br>");
		out.print("비밀번호 : " + pwd + "<br>");
		out.print("주소 : " + address );
		out.print("</body></html>");
		out.close();
	}
}
