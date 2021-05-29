package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
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
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String command = request.getParameter("command");
		
		if(command != null && command.equals("addMember")) {
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);
			dao.addMember(vo);
			
		} else if(command != null && command.equals("delMember")) {
			MemberVO vo = new MemberVO();
			vo.setId(id);
			dao.delMember(vo);
		}
				
		List<MemberVO> list = dao.listMember();
		request.setAttribute("listMembers", list);
		RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");
		dispatch.forward(request, response);
				
		/*
		 * out.print("<html><body>"); out.
		 * print("<table border=1><tr align='center' bgcolor='lightgreen'><td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>"
		 * );
		 * 
		 * for(MemberVO vo : list) { out.print("<tr><td>"+ vo.getId() + "</td><td>" +
		 * vo.getPwd() + "</td><td>" + vo.getName() + "</td><td>" + vo.getEmail() +
		 * "</td><td>" + vo.getJoinDate() + "</td></tr>"); }
		 * out.print("</table></body></html>");
		 */
	}
}
