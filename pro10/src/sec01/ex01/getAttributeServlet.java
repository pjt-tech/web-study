package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class getAttributeServlet
 */
@WebServlet(name = "get", urlPatterns = { "/get" })
public class getAttributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAttributeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext ctx = request.getServletContext();
		HttpSession session = request.getSession();
		
		String ctxMsg = (String)ctx.getAttribute("ctxMsg");
		String sesMsg = (String)session.getAttribute("sesMsg");
		String reqMsg = (String)request.getAttribute("reqMsg");
		
		out.print("context Message : " + ctxMsg +"<br>");
		out.print("session Message : " + sesMsg +"<br>");
		out.print("request Message : " + reqMsg);
		
	}
}
