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
@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet3() {
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
		memberInfo.put("name", "김연아");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "여");
		memberInfo.put("nickname", "칼치");
		membersArray.add(memberInfo);
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "박지성");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "남");
		memberInfo.put("nickname", "칼치");
		membersArray.add(memberInfo);
		totalObject.put("members", membersArray);
		
		JSONArray bookArray = new JSONArray();
		JSONObject bookInfo = new JSONObject();
		bookInfo = new JSONObject();
		bookInfo.put("title", "초보자를 위한 자바 프로그래밍");
		bookInfo.put("writer", "박진태");
		bookInfo.put("price", "30000");
		bookInfo.put("genre", "IT");
		bookInfo.put("image", "http://localhost:8090/pro16/image/image1.jpg");
		bookArray.add(bookInfo);
		
		bookInfo = new JSONObject();
		bookInfo.put("title", "초보자를 위한 파이썬 프로그래밍");
		bookInfo.put("writer", "박진태");
		bookInfo.put("price", "27000");
		bookInfo.put("genre", "IT");
		bookInfo.put("image", "http://localhost:8090/pro16/image/image2.jpg");
		bookArray.add(bookInfo);
		
		totalObject.put("books", bookArray);
		String jsonInfo = totalObject.toJSONString();
		System.out.println(jsonInfo);
		out.print(jsonInfo);
	}

}
