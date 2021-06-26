<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%
    	request.setCharacterEncoding("utf-8");
    %>
    <c:set var="id" value="hong" scope="page"/>
    <c:set var="pwd" value="1234" scope="page"/>
    <c:set var="name" value="" scope="page"/>
    <c:set var="email" value="${'abcd@test.com'}" scope="page"/>
    <c:set var="age" value="${22 }" scope="page"/>
    <c:set var="height" value="${180 }" scope="page"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="15%"><b>아이디</b></td>
			<td width="15%"><b>비밀번호</b></td>
			<td width="15%"><b>이름</b></td>
			<td width="15%"><b>이메일</b></td>
			
		</tr>
		
		<c:choose>
			<c:when test='${empty name}'>
				<tr align="center">
					<td colspan='6'>이름을 입력하세요~!!</td>
				</tr>
			</c:when>
		<c:otherwise>
		<tr align="center">
			<td>${id}</td>
			<td>${pwd}</td>
			<td>${name}</td>
			<td>${email}</td>
			
		</tr>
		</c:otherwise>
		</c:choose>	
	</table>
</body>
</html>