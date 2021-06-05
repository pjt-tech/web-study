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
 * Servlet implementation class setAttributeServlet
 */
@WebServlet(name = "set", urlPatterns = { "/set" })
public class setAttributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public setAttributeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String ctxMsg = "context에 바인딩";
		String sesMsg = "session에 바인딩";
		String reqMsg = "request에 바인딩";
		
		ServletContext ctx = request.getServletContext();
		HttpSession session = request.getSession();
		
		ctx.setAttribute("ctxMsg", ctxMsg);
		session.setAttribute("sesMsg", sesMsg);
		request.setAttribute("reqMsg", reqMsg);
		
		out.print("바인딩 설정완료");
		
	}

}
