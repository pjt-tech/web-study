package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class JsonServlet1
 */
@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	@SuppressWarnings("unchecked")
	private void doHandle (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("test/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		JSONObject totalObject = new JSONObject();
		JSONArray membersArray = new JSONArray();
		JSONObject memberInfo = new JSONObject();
		memberInfo.put("name", "±è¿¬¾Æ");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "¿©");
		memberInfo.put("nickname", "Ä®Ä¡");
		membersArray.add(memberInfo);
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "¹ÚÁö¼º");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "³²");
		memberInfo.put("nickname", "Ä®Ä¡");
		membersArray.add(memberInfo);
		
		totalObject.put("members", membersArray);
		String jsonInfo = totalObject.toJSONString();
		System.out.println(jsonInfo);
		out.print(jsonInfo);
	}
}
