package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginTestServlet
 */
@WebServlet("/loginTest")
public class LoginTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pwd");
		PrintWriter out = response.getWriter();
		
		if((id == null || id.equals("")) || (pwd == null || pwd.equals(""))) {
			out.print("<html><body>");
			out.print("아이디와 비밀번호를 입력하세요!!! <br>");
			out.print("<a href='http://localhost:8090/pro06a/test01/loginTest.html'>로그인으로</a>");
			out.print("</body></html>");			
		} else {
			out.print("<html><body>");
			out.print(id + "님께서 로그인하셨습니다.");
			out.print("</body></html>");		
		}
		
		out.close();
	}
}
