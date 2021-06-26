<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
%>
 <c:set var="contextPath" value="${pageCotext.request.contextPath}"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="file1" value="${param.param1 }"></c:set>
<c:set var="file2" value="${param.param2 }"></c:set>
<title>Insert title here</title>
</head>
<body>
매개변수 1 :
<c:out value="${file1 }"/><br>
매개변수 2 :
<c:out value="${file2 }"/><br>

<c:if test="${not empty file1 }">
	<img src=" ${contextPath}/pro15/download.do?fileName=${file1}" width=300 height=300/><br>
</c:if>
<c:if test="${not empty file2 }">
	<img src=" ${contextPath}/pro15/download.do?fileName=${file2}" width=300 height=300/><br>
</c:if>
파일 내려받기 : <br>
<a href='${contextPath}/pro15/download.do?fileName=${file2}'>파일 내려받기</a>
</body>
</html>