<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,sec01.brd01.*"
    
    %>
    
<%
 	request.setCharacterEncoding("utf-8");
	List memberLists = new ArrayList();
	MemberBean member1 = new MemberBean("son","1234","손흥민","aa@test.com");
	MemberBean member2 = new MemberBean("park","1234","박지성","bb@test.com");
	memberLists.add(member1);
	memberLists.add(member2);
	
	request.setAttribute("memberLists", memberLists);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="member3.jsp"></jsp:forward>

</body>
</html>