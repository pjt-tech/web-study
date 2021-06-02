package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest2
 */
@WebServlet("/sess2")
public class SessionTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();//세션이 있으면 리턴하고, 없으면 새로 생성
		out.println("세션아이디 : " + session.getId()+"<br>");
		out.println("세션 생성 시각 : " + new Date(session.getCreationTime())+"<br>");
		out.println("세션 접근 시각 : " + new Date(session.getLastAccessedTime())+"<br>");
		out.println("기본 세션 유효 시각 : " + session.getMaxInactiveInterval()+"<br>"); //세션 유효시간
		session.setMaxInactiveInterval(5);
		out.println("세션 유효 시각 : " + session.getMaxInactiveInterval()+"<br>"); //세션 유효시간
		
		if(session.isNew()) {
			out.print("새 세션이 만들어졌습니다.");
		}	
	}

}
