<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    import="java.util.*,sec01.ex01.*"%>
    
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
     <c:url var="url1" value="/test01/member1.jsp">
     <c:param name="id" value="hong"/>
     <c:param name="pwd" value="1234"/>
     <c:param name="name" value="홍길동"/>
     <c:param name="email" value="hong@naver.com"/>
     </c:url>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href='${url1}'>회원정보출력</a>
</body>
</html>