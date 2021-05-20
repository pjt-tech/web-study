<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var = "score" scope = "request" value = "83"> </c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test = "${score >= 90 }">
		 A학점입니다.
		 </c:when>
		 <c:when test = "${score >= 80 }">
		 B학점입니다.
		 </c:when>
		 <c:when test = "${score >= 70 }">
		 C학점입니다.
		 </c:when>
		 <c:when test = "${score >= 60 }">
		 D학점입니다.
		 </c:when>
	 </c:choose>
</body>
</html>