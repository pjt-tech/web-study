package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalServlet
 */
@WebServlet("/calc")
public class CalServlet extends HttpServlet {

       
    private static float USD_RATE = 1124.70F;
	private static float JPY_RATE = 10.113F;
	private static float CNY_RATE = 163.30F;
	private static float GBP_RATE = 1444.35F;
	private static float EUR_RATE = 1295.97F;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public CalServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		if(command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won), operator);
			out.print("<html><font size=10>변환 결과</font><br>");
			out.print("<html><font size=10>" +result+ "</font><br>");
			out.print("<a href='/pro06/calc'>환율 계산기</a>");
			return;
				
		}
		out.print("<html><title>환율 계산기</title>");
		out.print("<font size= 5>환율 계산기</font><br>");
		out.print("<form name = 'frmCalc' method='get' action='/pro06/calc'/>");
		out.print("원화: <input type = 'text' name='won' size=10/>");
		out.print("<select name = 'operator'>");
		out.print("<option value = 'dollar'>달러</option>");
		out.print("<option value = 'en'>엔화</option>");
		out.print("<option value = 'wian'>위안</option>");
		out.print("<option value = 'pound'>파운드</option>");
		out.print("<option value = 'euro'>유로</option>");
		out.print("</select>");
		out.print("<input type='hidden' name='command' value='calculate'/>");
		out.print("<input type='submit' value='변환'/>");
		out.print("</form>");
		out.print("</html>");
		out.close();
	}
	
	private static String calculate(float won, String operator) {
		String result = null;
		if(operator.equals("dollar")) {
			result = String.format("%.6f", won / USD_RATE);
		} else if(operator.equals("en")) {
			result = String.format("%.6f", won / JPY_RATE);
		} else if(operator.equals("wian")) {
			result = String.format("%.6f", won / CNY_RATE);
		} else if(operator.equals("pound")) {
			result = String.format("%.6f", won / GBP_RATE);
		} else if(operator.equals("euro")) {
			result = String.format("%.6f", won / EUR_RATE);
		} 
		return result;
	}

}
