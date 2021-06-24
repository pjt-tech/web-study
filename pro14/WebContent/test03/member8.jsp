<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    import="java.util.*,sec01.ex01.*"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	request.setCharacterEncoding("utf-8");
    %>
    <jsp:useBean id="membersList" class="java.util.ArrayList"/>
    <%
    	
    	MemberBean m1 = new MemberBean("son","1234","손흥민","son@son.com");
    	MemberBean m2 = new MemberBean("park","1234","박지성","park@son.com");
    	MemberBean m3 = new MemberBean("ki","1234","기성용","ki@son.com");
    	
    	membersList.add(m1);
    	membersList.add(m2);
    	membersList.add(m3);
    	
    %>
    
    <c:set var="membersList" value="${membersList }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
			
		</tr>
		
		<c:forEach var="member" items="${membersList }">
		<tr align="center">
			<td>${member.id}</td>
			<td>${member.pwd}</td>
			<td>${member.name}</td>
			<td>${member.email}</td>			
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>