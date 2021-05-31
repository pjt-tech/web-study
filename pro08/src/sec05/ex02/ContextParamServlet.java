package sec05.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextParamServlet
 */
@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextParamServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = this.getServletContext();
		
		String menu_member = context.getInitParameter("menu-member");
		String menu_order = context.getInitParameter("menu-order");
		String menu_goods = context.getInitParameter("menu-goods");
		
		out.print("<html><body>");
		out.print("<table border=1 cellspacing='0'><tr>메뉴이름</tr>");
		out.print("<tr><td>" + menu_member + "</td></tr>");
		out.print("<tr><td>" + menu_order + "</td><tr>");
		out.print("<tr><td>" + menu_goods + "</td><tr>");
		out.print("</table></body></html>");
			
	}

}
