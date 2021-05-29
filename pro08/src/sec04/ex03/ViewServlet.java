package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		List<MemberVO> list = (List) request.getAttribute("listMembers");
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'><td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
		
		if(list.size()!=0) {
			for(MemberVO vo : list) {
				out.print("<tr><td>"+ vo.getId() + "</td><td>" + vo.getPwd() + "</td><td>" + vo.getName()
				+ "</td><td>" + vo.getEmail() + "</td><td>" + vo.getJoinDate() + "</td><td><a href='/pro08/member?command=delMember&user_id=" +vo.getId()+"'>삭제</a></td></tr>");
			}					
		}
		out.print("</table>");	
		out.print("<a href=/pro08/memberForm.html>회원등록</a>");
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
