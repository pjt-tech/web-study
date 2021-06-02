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
		HttpSession session = request.getSession();//������ ������ �����ϰ�, ������ ���� ����
		out.println("���Ǿ��̵� : " + session.getId()+"<br>");
		out.println("���� ���� �ð� : " + new Date(session.getCreationTime())+"<br>");
		out.println("���� ���� �ð� : " + new Date(session.getLastAccessedTime())+"<br>");
		out.println("�⺻ ���� ��ȿ �ð� : " + session.getMaxInactiveInterval()+"<br>"); //���� ��ȿ�ð�
		session.setMaxInactiveInterval(5);
		out.println("���� ��ȿ �ð� : " + session.getMaxInactiveInterval()+"<br>"); //���� ��ȿ�ð�
		
		if(session.isNew()) {
			out.print("�� ������ ����������ϴ�.");
		}	
	}

}
